/**
 * 
 */
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.communication.entity.Data;
import com.communication.entity.FResaleRealNameRegistration;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FResaleRealNameRegistrationService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;

/**
 * @author Administrator
 *
 */
@Controller
public class FormResaleRealNameRegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(FormResaleRealNameRegistrationController.class);
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FResaleRealNameRegistrationService formService;

	@RequestMapping("/zsqysmz/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (reportLog.getToUser().getId() == curUser.getId()) {
			FResaleRealNameRegistration fResaleRealNameRegistration = formService.queryByReportLogId(reportLogId);

			if (fResaleRealNameRegistration == null) {
				fResaleRealNameRegistration = new FResaleRealNameRegistration();
			}

			model.addAttribute("reportLog", reportLog);
			model.addAttribute("fResaleRealNameRegistration", fResaleRealNameRegistration);
			urlReturn = "/form/form_zsqysmz";
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("processing in zsqysmz edit");

		return urlReturn;
	}

	@RequestMapping(value = "/zsqysmz/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		FResaleRealNameRegistration fResaleRealNameRegistration = formService.queryByReportLogId(reportLogId);
		model.addAttribute("fResaleRealNameRegistration", fResaleRealNameRegistration);
		model.addAttribute("reportLog", reportLog);

		return "/form/form_zsqysmz_view";
	}

	@RequestMapping(value = "/zsqysmz/save", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("fResaleRealNameRegistration") FResaleRealNameRegistration fResaleRealNameRegistration,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Data data = Data.failure("操作失败");

		try {
			if (fResaleRealNameRegistration.getId() > 0) {
				FResaleRealNameRegistration fResaleRealNameRegistrationTemp = formService
						.find(fResaleRealNameRegistration.getId());
				fResaleRealNameRegistrationTemp = fResaleRealNameRegistration;
				fResaleRealNameRegistrationTemp.setUpdateTime(new Date());
				formService.update(fResaleRealNameRegistrationTemp);
			} else {
				fResaleRealNameRegistration.setCreateTime(new Date());
				fResaleRealNameRegistration.setUpdateTime(new Date());
				formService.save(fResaleRealNameRegistration);
			}

			ReportLog reportLog = reportLogService.find(fResaleRealNameRegistration.getReportLogId());
			reportLog.setStatus("1");
			reportLog.setAuditStatus("0");
			reportLog.setSubmitTime(new Date());
			reportLogService.update(reportLog);

			data = Data.success("提交成功", "/report/history", "进入历史报表");
		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("data", data);
		return "redirect:/message";
	}

}
