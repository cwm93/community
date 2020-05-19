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
/**
 * @author liliang
 * 打击通讯信息诈骗相关业务数据周报
 */
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FXxzp;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FXxzpService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

@Controller
public class FormXxzpController {
	private static final Logger logger = LoggerFactory.getLogger(FormXxzpController.class);
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FXxzpService formService;

	@RequestMapping(value = "/xxzp/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		logger.info("edit xxzp form");
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);
		if (reportLog.getToUser().getId() == curUser.getId()) {
			FXxzp fXxzp = formService.queryByReportLogId(reportLog.getId());
			if (fXxzp == null) {
				fXxzp = new FXxzp();
			}

			model.addAttribute("reportLog", reportLog);
			model.addAttribute("FXxzp", fXxzp);
			urlReturn = "/form/form_xxzpyw";
		} else {
			urlReturn = "redirect:/hasNoRight";
		}

		return urlReturn;
	}

	@RequestMapping(value = "/xxzp/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		FXxzp fXxzp = formService.queryByReportLogId(reportLog.getId());
		model.addAttribute("FXxzp", fXxzp);
		model.addAttribute("reportLog", reportLog);

		return "/form/form_xxzpyw_view";
	}

	@RequestMapping(value = "/xxzp/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("FXxzp") FXxzp entity, HttpServletRequest request) {
		String flag = request.getParameter("flag");
		try {
			if (entity.getId() > 0) {
				FXxzp tempFXxzp = formService.find(entity.getId());
				tempFXxzp = entity;
				tempFXxzp.setUpdateTime(new Date());
				formService.update(tempFXxzp);
			} else {
				formService.save(entity);
			}
			ReportLog reportLog = reportLogService.find(entity.getReportLogId());
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
			return R.error("提交失败");
		}
		return R.ok("提交成功");
	}
}
