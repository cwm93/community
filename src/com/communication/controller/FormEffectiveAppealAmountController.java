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

import com.communication.entity.FEffectiveAppealAmount;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FEffectiveAppealAmountService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 * 有效申诉量统计情况
 **/
@Controller
@RequestMapping("/appeal_amount")
public class FormEffectiveAppealAmountController {
	
	private static final Logger logger = LoggerFactory.getLogger(FormEffectiveAppealAmountController.class);
	
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FEffectiveAppealAmountService effectiveAppealAmountService;

	/**
	 * 编辑
	 **/
	@RequestMapping("/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);
		if (reportLog.getToUser().getId() == curUser.getId()) {
			FEffectiveAppealAmount effectiveAppealAmount = effectiveAppealAmountService.queryByReportLogId(reportLogId);
			if (null == effectiveAppealAmount) {
				effectiveAppealAmount = new FEffectiveAppealAmount();
			}
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("effectiveAppealAmount", effectiveAppealAmount);
			logger.info(effectiveAppealAmount.toString());
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("编辑有效申诉量统计情况：reportLogId：" + reportLogId);
		return "/form/form_appeal_amount";
	}

	/**
	 * 预览
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

		FEffectiveAppealAmount effectiveAppealAmount = effectiveAppealAmountService.queryByReportLogId(reportLogId);
		model.addAttribute("reportLog", reportLog);
		model.addAttribute("effectiveAppealAmount", effectiveAppealAmount);

		return "/form/form_appeal_amount_view";
	}

	/**
	 * 保存
	 **/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("effectiveAppealAmount") FEffectiveAppealAmount effectiveAppealAmount,@RequestParam("flag") String flag) {
		try {
			if (effectiveAppealAmount.getId() > 0) {
				effectiveAppealAmount.setUpdateTime(new Date());
				effectiveAppealAmountService.update(effectiveAppealAmount);
			} else {
				effectiveAppealAmount.setInsertTime(new Date());
				effectiveAppealAmount.setUpdateTime(new Date());
				effectiveAppealAmountService.save(effectiveAppealAmount);
			}

			ReportLog reportLog = reportLogService.find(effectiveAppealAmount.getReportLogId());
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
