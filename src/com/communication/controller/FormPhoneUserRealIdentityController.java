package com.communication.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FPhoneUserRealIdentity;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FPhoneUserRealIdentityService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 * @author Administrator
 * @基础电信运营商电话用户真实身份信息登记数据统计表
 */

@Controller
public class FormPhoneUserRealIdentityController {

	private static final Logger logger = LoggerFactory.getLogger(FormPhoneUserRealIdentityController.class);
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FPhoneUserRealIdentityService fPhoneUserRealIdentityService;
	
	@RequestMapping("/yhsmz/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (reportLog.getToUser().getId() == curUser.getId()) {
			FPhoneUserRealIdentity fPhoneUserRealIdentity = fPhoneUserRealIdentityService
					.queryByReportLogId(reportLogId);

			if (fPhoneUserRealIdentity == null) {
				fPhoneUserRealIdentity = new FPhoneUserRealIdentity();
			}

			model.addAttribute("reportLog", reportLog);
			model.addAttribute("fPhoneUserRealIdentity", fPhoneUserRealIdentity);
			urlReturn = "/form/form_yhsmz";
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("processing in industry card edit");

		return urlReturn;
	}

	@RequestMapping(value = "/yhsmz/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		FPhoneUserRealIdentity fPhoneUserRealIdentity = fPhoneUserRealIdentityService.queryByReportLogId(reportLogId);
		model.addAttribute("fPhoneUserRealIdentity", fPhoneUserRealIdentity);
		model.addAttribute("reportLog", reportLog);

		return "/form/form_yhsmz_view";
	}

	@RequestMapping(value = "/yhsmz/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("fPhoneUserRealIdentity") FPhoneUserRealIdentity fPhoneUserRealIdentity, HttpServletRequest request) {
		String flag = request.getParameter("flag");
        
		try {
			if (fPhoneUserRealIdentity.getId() > 0) {
				FPhoneUserRealIdentity temp = new FPhoneUserRealIdentity();
				temp = fPhoneUserRealIdentity;
				temp.setUpdateTime(new Date());
				fPhoneUserRealIdentityService.update(temp);
			} else {
				fPhoneUserRealIdentity.setCreateTime(new Date());
				fPhoneUserRealIdentity.setUpdateTime(new Date());
				fPhoneUserRealIdentityService.save(fPhoneUserRealIdentity);
			}

			ReportLog reportLog = reportLogService.find(fPhoneUserRealIdentity.getReportLogId());
			if (flag.equals("1")) {
				reportLog.setStatus("1");
				reportLog.setAuditStatus("0");
				reportLog.setSubmitTime(new Date());
			} else {
				reportLog.setStatus("2");
			}
			reportLogService.update(reportLog);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("操作失败");
		}
		return R.ok("操作成功");
	}
}
