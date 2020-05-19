package com.communication.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FIOTSecurityManagement;
import com.communication.entity.FIOTSecurityManagementSegment;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FIOTSecurityManagementSegmentService;
import com.communication.service.FIOTSecurityManagementService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.util.R;

@Controller
@RequestMapping("/iot_management/")
public class FormIOTSecurityManagementController {

	private static Logger logger = LoggerFactory.getLogger(FormIOTSecurityManagementController.class);

	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FIOTSecurityManagementService fIOTSecurityManagementService;
	@Resource
	private FIOTSecurityManagementSegmentService fIOTSecurityManagementSegmentService;

	/**
	 * edit action
	 **/
	@GetMapping("/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);
		logger.info("进入表单编辑页面");
		if (reportLog.getToUser().getId() == curUser.getId()) {
			FIOTSecurityManagement fIOTSecurityManagement = fIOTSecurityManagementService
					.queryByReportLogId(reportLogId);
			if (null == fIOTSecurityManagement) {
				fIOTSecurityManagement = new FIOTSecurityManagement();
				fIOTSecurityManagement.setId(0L);
			}
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("fIOTSecurityManagement", fIOTSecurityManagement);
			urlReturn = "/form/form_iot_security_management";
		} else {
			return "redirect:/hasNoRight";
		}

		model.addAttribute("reportLog", reportLog);
		return urlReturn;
	}

	/**
	 * view action
	 **/
	@RequestMapping(value = "/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}

		FIOTSecurityManagement fIOTSecurityManagement = fIOTSecurityManagementService.queryByReportLogId(reportLogId);
		List<FIOTSecurityManagementSegment> iotSecurityManagementSegmentList = fIOTSecurityManagementSegmentService.queryListByReportLogId(reportLogId);
		
		
		model.addAttribute("reportLog", reportLog);
		model.addAttribute("fIOTSecurityManagement", fIOTSecurityManagement);
		model.addAttribute("iotSecurityManagementSegmentList", iotSecurityManagementSegmentList);

		return "/form/form_iot_security_management_view";
	}

	/**
	 * save action
	 **/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody R save(
			@ModelAttribute("fIOTSecurityManagement") FIOTSecurityManagement fIOTSecurityManagement,
			@RequestParam("flag") String flag) {
		try {
			if (fIOTSecurityManagement != null && fIOTSecurityManagement.getId() > 0) {
				fIOTSecurityManagement.setUpdateTime(new Date());
				fIOTSecurityManagementService.update(fIOTSecurityManagement);
			} else {
				fIOTSecurityManagement.setInsertTime(new Date());
				fIOTSecurityManagement.setUpdateTime(new Date());
				fIOTSecurityManagementService.save(fIOTSecurityManagement);
			}

			ReportLog reportLog = reportLogService.find(fIOTSecurityManagement.getReportLogId());
			if ("1".equals(flag)) {
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
