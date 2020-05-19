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

import com.communication.entity.FCrankCall;
import com.communication.entity.ReportFormRemark;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FCrankCallService;
import com.communication.service.ReportFormRemarkService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 *  骚扰电话举报分类汇总表
 */
@Controller
@RequestMapping("/crank_call")
public class FormCrankCallController {
	
	private static final Logger logger = LoggerFactory.getLogger(FormCrankCallController.class);
	
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FCrankCallService crankCallService;
	@Resource
	private ReportFormRemarkService reportFormRemarkService;
	
	/**
	 * 编辑
	 **/
	@RequestMapping("/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);
		if (reportLog.getToUser().getId() == curUser.getId()) {
			FCrankCall crankCall = crankCallService.queryByReportLogId(reportLogId);
			if (null == crankCall) {
				crankCall = new FCrankCall();
				crankCall.setId(0L);
			}
			ReportFormRemark reportFormRemark = reportFormRemarkService.queryByReportIdAndYear(reportLog.getReport().getId(),reportLog.getWriteYear());
			model.addAttribute("reportFormRemark", reportFormRemark);
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("crankCall", crankCall);
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("编辑有效申诉量统计情况：reportLogId：" + reportLogId);
		return "/form/form_crank_call";
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

		FCrankCall crankCall = crankCallService.queryByReportLogId(reportLogId);
		model.addAttribute("reportLog", reportLog);
		model.addAttribute("crankCall", crankCall);

		return "/form/form_crank_call_view";
	}

	/**
	 * 保存
	 **/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("crankCall") FCrankCall crankCall,@RequestParam("flag") String flag) {
		try {
			if (crankCall != null && crankCall.getId() > 0) {
				crankCall.setUpdateTime(new Date());
				crankCallService.update(crankCall);
			} else {
				crankCall.setInsertTime(new Date());
				crankCall.setUpdateTime(new Date());
				crankCallService.save(crankCall);
			}

			ReportLog reportLog = reportLogService.find(crankCall.getReportLogId());
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
