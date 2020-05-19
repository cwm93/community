package com.communication.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FSpamMessage;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FSpamMessageService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

@Controller
public class FormSpamMessageController {
	private static final Logger logger = LoggerFactory.getLogger(FormWlwhdController.class);

	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FSpamMessageService formService;

	@RequestMapping(value = "/ljdxx/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		String urlReturn = null;
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (reportLog.getToUser().getId() == curUser.getId()) {
			FSpamMessage spamMessage = formService.queryByReportLogId(reportLogId);

			if (spamMessage == null) {
				spamMessage = new FSpamMessage();
			}
			String oneOperator = "";
			String anotherOperator = "";
			if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
				oneOperator = "移动";
				anotherOperator = "联通";
			} else if (curUser.getTelecomOperator().getId() == 2) {
				oneOperator = "电信";
				anotherOperator = "联通";
			} else {
				oneOperator = "电信";
				anotherOperator = "移动";
			}
			model.addAttribute("oneOperator", oneOperator);
			model.addAttribute("anotherOperator", anotherOperator);
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("spamMessage", spamMessage);
			urlReturn = "/form/form_ljdxx";
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("processing in ljdxx edit");

		return urlReturn;
	}

	@RequestMapping(value = "/ljdxx/view/{report_log_id}")
	public String view(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);

		if (curUser.getRole().getCode().equals("USER")) {
			if (reportLog.getToUser().getId() != curUser.getId()) {
				return "redirect:/hasNoRight";
			}
		}
		FSpamMessage spamMessage = formService.queryByReportLogId(reportLogId);
		String oneOperator = "";
		String anotherOperator = "";
		if (reportLog.getToUser().getTelecomOperator().getId() == 1) {
			oneOperator = "移动";
			anotherOperator = "联通";
		} else if (curUser.getTelecomOperator().getId() == 2) {
			oneOperator = "电信";
			anotherOperator = "联通";
		} else {
			oneOperator = "电信";
			anotherOperator = "移动";
		}
		model.addAttribute("oneOperator", oneOperator);
		model.addAttribute("anotherOperator", anotherOperator);
		model.addAttribute("spamMessage", spamMessage);
		model.addAttribute("reportLog", reportLog);

		return "/form/form_ljdxx_view";
	}

	@RequestMapping(value = "/ljdxx/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("spamMessage") FSpamMessage spamMessage,
			@RequestParam("flag") String flag) {
		try {
			logger.info(spamMessage.toString());
			if (spamMessage.getId() > 0) {
				FSpamMessage tempSpamMessage = formService.find(spamMessage.getId());
				tempSpamMessage = spamMessage;
				tempSpamMessage.setUpdateTime(new Date());
				formService.update(tempSpamMessage);
			} else {
				spamMessage.setCreateTime(new Date());
				spamMessage.setUpdateTime(new Date());
				formService.save(spamMessage);
			}

			ReportLog reportLog = reportLogService.find(spamMessage.getReportLogId());
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
