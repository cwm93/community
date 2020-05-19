package com.communication.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.communication.entity.AdministrationReport;
import com.communication.entity.CompanyAttribute;
import com.communication.entity.Data;
import com.communication.entity.Report;
import com.communication.entity.Role;
import com.communication.entity.TelecomOperator;
import com.communication.entity.User;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.AdministrationReportService;
import com.communication.service.CompanyAttributeService;
import com.communication.service.ReportService;
import com.communication.service.RoleService;
import com.communication.service.TelecomOperatorService;
import com.communication.service.UserService;
import com.communication.util.Constants;
import com.communication.util.R;
import com.communication.util.Tool;

@Controller
@RequestMapping(value = "user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;
	@Resource
	private TelecomOperatorService telecomOperatorService;
	@Resource
	private RoleService roleService;
	@Resource
	private ReportService reportService;
	@Resource
	private CompanyAttributeService companyAttributeService;
	@Autowired
	private AdministrationReportService administrationReportService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, HttpSession session) {
		logger.info("view profile");
		long loginUserId = (Long) session.getAttribute("curUserId");
		
		User user = userService.find(loginUserId);
		List<TelecomOperator> telecomOperatorList = telecomOperatorService.findAll();
		List<CompanyAttribute> companyAttributes = companyAttributeService.findAll();
		
		model.addAttribute("companyAttributes", companyAttributes);
		model.addAttribute("telecomOperatorList", telecomOperatorList);
		model.addAttribute("companyAttributes", companyAttributes);
	
		model.addAttribute("user", user);
		return "user/profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profile(RedirectAttributes redirectAttributes, @ModelAttribute User user, HttpSession session) {
		Data data = Data.success("个人资料更新成功");
		long id = (long) session.getAttribute("curUserId");
		User updateUser = userService.find(id);
		updateUser.setCompanyAttribute(companyAttributeService.find(user.getCompanyAttribute().getId()));
		updateUser.setPosition(user.getPosition());
		updateUser.setEmail(user.getEmail());
		updateUser.setAddress(user.getAddress());
		updateUser.setIdCardNumber(user.getIdCardNumber());
		updateUser.setTelephone(user.getTelephone());
		userService.update(updateUser);
		redirectAttributes.addFlashAttribute("data", data);
		return "redirect:/user/profile";

	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public @ResponseBody Data changePassword(HttpServletRequest request, HttpSession session) {
		logger.info("修改密码操作");
		Data data = Data.failure("操作失败");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");

		User loginUser = (User) session.getAttribute("curUser");
		if (userService.checkPassword(loginUser.getId(), oldpassword)) {
			userService.updatePassword(loginUser.getId(), newpassword);
			data = Data.success("密码修改成功");
		}
		return data;
	}

	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model model) {
		logger.info("用户详细信息");
		User user = userService.find(id);

		List<TelecomOperator> telecomOperatorList = telecomOperatorService.findAll();
		List<Role> roles = roleService.findAll();
		List<CompanyAttribute> companyAttributes = companyAttributeService.findAll();

		model.addAttribute("telecomOperatorList", telecomOperatorList);
		model.addAttribute("roles", roles);
		model.addAttribute("companyAttributes", companyAttributes);
		model.addAttribute("user", user);
		return "user/detail";
	}

	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value = "/detail/update", method = RequestMethod.POST)
	public String updateDetail(Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		Data data = Data.success("个人资料更新成功");
		Role role = roleService.find(user.getRole().getId());
		User updateUser = userService.find(user.getId());
		updateUser.setStatus(user.getStatus());
		updateUser.setRole(role);
		updateUser.setRealname(user.getRealname());
		updateUser.setCompany(user.getCompany());
		updateUser.setCompanyAttribute(companyAttributeService.find(user.getCompanyAttribute().getId()));
		updateUser.setPosition(user.getPosition());
		updateUser.setEmail(user.getEmail());
		updateUser.setAddress(user.getAddress());
		updateUser.setIdCardNumber(user.getIdCardNumber());
		updateUser.setTelephone(user.getTelephone());
		userService.save(updateUser);
		redirectAttributes.addFlashAttribute("data", data);
		return "redirect:/user/" + user.getId() + "/detail";
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		List<TelecomOperator> telecomOperatorList = telecomOperatorService.findAll();
		List<Role> roles = roleService.findAll();
		List<CompanyAttribute> companyAttributes = companyAttributeService.findAll();

		model.addAttribute("telecomOperatorList", telecomOperatorList);
		model.addAttribute("roles", roles);
		model.addAttribute("companyAttributes", companyAttributes);
		model.addAttribute("user", user);
		return "/user/add";
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		Data data = Data.success("添加用户成功");
		Role role = roleService.find(user.getRole().getId());
		User insertUser = userService.find(user.getId());
		insertUser.setStatus(user.getStatus());
		insertUser.setRole(role);
		insertUser.setRealname(user.getRealname());
		insertUser.setCompany(user.getCompany());
		insertUser.setCompanyAttribute(companyAttributeService.find(user.getCompanyAttribute().getId()));
		insertUser.setPosition(user.getPosition());
		insertUser.setEmail(user.getEmail());
		insertUser.setAddress(user.getAddress());
		insertUser.setIdCardNumber(user.getIdCardNumber());
		insertUser.setTelephone(user.getTelephone());
		insertUser.setPassword(Tool.getMD5("20zcjb17"));
		
		try{
			userService.save(insertUser);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		redirectAttributes.addFlashAttribute("data", data);
		return "user/list";
	}

	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value = "/{id}/privilege", method = RequestMethod.GET)
	public String privileges(Model model, @PathVariable("id") Long id) {
		User user = userService.find(id);
		Set<User> assignedUsers = user.getAssignedUsers();
		Set<Report> assignedReports = user.getAssignedReports();
		Set<AdministrationReport> assignedAdministrationReports = user.getAssignedAdministrationReports();
		
		
		List<User> userList = userService.findUsersByStatus("1");
		List<Report> reportList = reportService.findAll();
		List<AdministrationReport> administrationReportList = administrationReportService.findAll();

		model.addAttribute("assignedUsers", assignedUsers);
		model.addAttribute("assignedReports", assignedReports);
		model.addAttribute("assignedAdministrationReports", assignedAdministrationReports);
		model.addAttribute("reportList", reportList);
		model.addAttribute("administrationReportList", administrationReportList);
		model.addAttribute("userList", userList);
		model.addAttribute("user", user);

		return "user/privilege";
	}

	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		String status = request.getParameter("status");
		List<User> userList =null;
		if(status==""||status==null){
			userList = userService.findAll();
		}else{
			userList = userService.queryUsersByStatus(status);
		}
		/********统计**********/
		long countAll = userService.countAll();
		long countOk = userService.CountByStatus("1");
		long countNotOk = userService.CountByStatus("0");
		long countForbid = userService.CountByStatus("2");
		model.addAttribute("userList", userList);
		model.addAttribute("countAll", countAll);
		model.addAttribute("countOk", countOk);
		model.addAttribute("countNotOk", countNotOk);
		model.addAttribute("countForbid", countForbid);
		return "user/list";
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public @ResponseBody R resetPassword(@RequestParam("userId") Long userId) {
		try {
			User user = userService.find(userId);
			user.setPassword(Tool.getMD5("abc@123"));
			userService.update(user);
			return R.ok("密码重置成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return R.error("密码重置失败");
	}

}
