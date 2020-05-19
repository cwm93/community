package com.communication.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.communication.entity.CompanyAttribute;
import com.communication.entity.Data;
import com.communication.entity.LogLogin;
import com.communication.entity.Role;
import com.communication.entity.SmsLogEntity;
import com.communication.entity.TelecomOperator;
import com.communication.entity.User;
import com.communication.service.CompanyAttributeService;
import com.communication.service.LogLoginService;
import com.communication.service.ReportLogService;
import com.communication.service.ReportService;
import com.communication.service.ScheduleReportService;
import com.communication.service.SmsLogService;
import com.communication.service.SmsService;
import com.communication.service.TelecomOperatorService;
import com.communication.service.UserService;
import com.communication.util.CharacterUtils;
import com.communication.util.Constants;
import com.communication.util.HttpClientUtil;
import com.communication.util.R;
import com.communication.util.SMSUtil;
import com.communication.util.Tool;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Resource
	private UserService userService;
	@Resource
	private TelecomOperatorService telecomOperatorService;
	@Resource
	private CompanyAttributeService companyAttributeService;
	@Resource
	private LogLoginService logLoginService;
	@Resource 
	private ReportService reportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private ScheduleReportService scheduleReportService;
	
	@Resource
	private SmsService smsService;
	@Autowired
	private SmsLogService smsLogService;
	
	private SmsLogEntity smsLogEntity = null;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		User loginUser = userService.find((Long) session.getAttribute("curUserId"));
		Role role = loginUser.getRole();

		long uncompeletedReportNumber = 0L;
		long historyReportNumber = 0L;
		long summaryReportNumber = 0L;
		long planReportNumber = 0L;

		if (role.getCode().equals(Constants.ROLE_ADMIN)) {
			uncompeletedReportNumber = reportLogService.ncount("1","0");
			historyReportNumber = reportLogService.count("1","0");
			summaryReportNumber = reportService.countAll();
			planReportNumber = scheduleReportService.count(0L, "");
		} else if (role.getCode().equals(Constants.ROLE_SUBADMIN)) {
			uncompeletedReportNumber = reportLogService.ncountByFromUser(loginUser, "1","0");
			historyReportNumber = reportLogService.countByFromUser(loginUser, "1","0");
			summaryReportNumber = loginUser.getAssignedReports().size();
			planReportNumber = scheduleReportService.count(loginUser.getId(), "");
		} else {
			uncompeletedReportNumber = reportLogService.countByToUser(loginUser, "0","0");
			historyReportNumber = reportLogService.countByToUser(loginUser, "1","0");
		}

		model.addAttribute("uncompeletedReportNumber", uncompeletedReportNumber);
		model.addAttribute("historyReportNumber", historyReportNumber);
		model.addAttribute("summaryReportNumber", summaryReportNumber);
		model.addAttribute("planReportNumber", planReportNumber);

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		logger.info("登录界面");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("curUser");
		
		if(user!=null){
			return "redirect:/index";	
		}
		if(smsService.isOpen(1)) {
			request.setAttribute("token", System.currentTimeMillis());
			return "login_sms";
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Data login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Data data = Data.failure("错误：登陆失败");

		User loginUser = userService.login(username, password);
		if (loginUser != null) {
			if (loginUser.getStatus().equals("0")) {
				data = Data.failure("账号尚未通过审核");
			} else if (loginUser.getStatus().equals("1")) {
				HttpSession session = request.getSession();
				session.setAttribute("curUser", loginUser);
				session.setAttribute("curUserId", loginUser.getId());
				try {
					userService.updateLoginIp(loginUser.getId(), Tool.getLocalIp(request), new Date());
				} catch (Exception e) {
					e.printStackTrace();
				}
				data = Data.success("登陆成功");
			} else if (loginUser.getStatus().equals("2")) {
				data = Data.failure("该账号已被禁用");
			}
			/*******保存登录日志***************/
			LogLogin logLogin =new LogLogin(loginUser.getId(),Tool.getLocalIp(request),data.getCode(),data.getMessage(),new Date());
			logLoginService.save(logLogin);
			
		} else {
			data = Data.failure("请输入正确的用户名或密码");
		}
		return data;
	}
	
	@RequestMapping(value = "/smsLogin", method = RequestMethod.POST)
	public @ResponseBody R smsLoginAction(HttpServletRequest request) {
		String mobile = request.getParameter("mobile");
		String smscode = request.getParameter("smsCode");

		User loginUser = userService.loginBySmscode(mobile, smscode);
		if (loginUser != null) {
			long nowtime = System.currentTimeMillis();
			//校验验证码
			if(loginUser.getSmscode()!="" && loginUser.getCodeExpire()>0) {
				if(nowtime > loginUser.getCodeExpire()) {
					return R.error("验证码已过期，请重新获取");
				}
			}else {
				return R.error("非法操作");
			}
			//校验通过后
			if (loginUser.getStatus().equals("0")) {
				return R.error("账号尚未通过审核");
			} else if (loginUser.getStatus().equals("1")) {
				HttpSession session = request.getSession();
				session.setAttribute("curUser", loginUser);
				session.setAttribute("curUserId", loginUser.getId());
				try {
					loginUser.setCodeExpire(nowtime);
					loginUser.setLastLoginIp(Tool.getLocalIp(request));
					loginUser.setLastLoginTime(new Date());
					userService.update(loginUser);
				} catch (Exception e) {
					e.printStackTrace();
				}
				/*******保存登录日志***************/
				LogLogin logLogin =new LogLogin(loginUser.getId(),Tool.getLocalIp(request),1,"登录成功",new Date());
				logLoginService.save(logLogin);
				return R.ok("登陆成功").put("url", "/index");
			} else if (loginUser.getStatus().equals("2")) {
				return R.error("该账号已被禁用");
			}
		} else {
			return R.error("输入的手机号码或者验证码不正确");
		}
		return R.error("未知错误");
	}
	
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
	public @ResponseBody R sendCode(@RequestParam(value="mobile") String mobile) {
		User loginUser = userService.findByMobile(mobile);
		if(null==loginUser) {
			return R.error("该手机用户不存在");
		}
		try {
			String smscode = CharacterUtils.getRandomCode(6);
			
			StringBuffer sb=new StringBuffer();
			sb.append("您的验证码为：");
			sb.append(smscode);
			sb.append("，五分钟内有效，请勿告诉他人【上海市通信管理局】");
			int returnCode = SMSUtil.sendSms(mobile, sb.toString());
			
			smsLogEntity  = new SmsLogEntity();
			if(returnCode>0) {
				long nowtime = System.currentTimeMillis();
				loginUser.setSmscode(smscode);
				loginUser.setSendCodeTime(nowtime);
				loginUser.setCodeExpire(nowtime+300000);//五分钟后过期
				userService.update(loginUser);
				smsLogEntity.setStatus("1");
				smsLogEntity.setPieces(returnCode);
				smsLogEntity.setContent(mobile+"手机号码获取验证码成功!");
				smsLogEntity.setInsertTime(new Date());
				smsLogService.save(smsLogEntity);
				return R.ok("短信验证码发送成功");
			}else {
				HttpClientUtil httpClient = HttpClientUtil.getInstance();
				smsLogEntity.setStatus("-1");
				smsLogEntity.setPieces(0);
				smsLogEntity.setContent(mobile+"手机号码获取验证码失败!失败原因:"+httpClient.getErrorMsg(returnCode));
				smsLogEntity.setInsertTime(new Date());
				smsLogService.save(smsLogEntity);
				return R.error(httpClient.getErrorMsg(returnCode));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return R.error("短信验证码发送失败");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {
	    List<TelecomOperator> telecomOperatorList = telecomOperatorService.findAll();
	    List<CompanyAttribute> companyAttributeList = companyAttributeService.findAll();
	    model.addAttribute("telecomOperatorList", telecomOperatorList);
	    model.addAttribute("companyAttributeList", companyAttributeList);
	    model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		
		Data data = Data.failure("错误：注册失败");
		if(!userService.isMobileExisted(request.getParameter("mobile"))){
			User regUser = new User();
			regUser.setUsername(request.getParameter("mobile"));
			regUser.setPassword(Tool.getMD5(request.getParameter("password")));
			regUser.setRealname(request.getParameter("realname"));
			regUser.setCompany(request.getParameter("company"));
			regUser.setTelecomOperator(telecomOperatorService.find(Long.valueOf(request.getParameter("telecomOperator"))));
			regUser.setCompanyAttribute(companyAttributeService.find(Integer.valueOf(request.getParameter("companyAttribute"))));
			regUser.setPosition(request.getParameter("position"));
			regUser.setAddress(request.getParameter("address"));
			regUser.setMobile(request.getParameter("mobile"));
			regUser.setEmail(request.getParameter("email"));
			regUser.setAddress(request.getParameter("address"));
			regUser.setIdCardNumber(request.getParameter("idCardNumber"));
			regUser.setTelephone(request.getParameter("telephone"));
			regUser.setStatus("0");//置为未审核
			Role role = new Role(3,"普通用户","系统默认","USER");
			regUser.setRole(role);//置为普通用户
			
			userService.save(regUser);
			
			data = Data.success("注册成功，请等待审核！");
		}else{
			data = Data.failure("注册失败，原因：该手机号码已经被注册！");
		}
		redirectAttributes.addFlashAttribute("data", data);
		
		return "redirect:/message";
	}
	
	

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "forgotPassword";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("curUser");
		session.removeAttribute("curUserId");
		return "redirect:/index.jsp";
	}
	@RequestMapping(value = "message", method = RequestMethod.GET)
	public String message() {
		return "message";
	}

	@RequestMapping(value = "/hasNoRight",method = RequestMethod.GET)
	public String hasNoRight() {
		return "hasNoRight";
	}
	
	@RequestMapping(value = "/permissionDenied",method = RequestMethod.GET)
	public String permissionDenied() {
		return "hasNoRight";
	}

}
