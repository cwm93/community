package com.communication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.communication.entity.FAppealAnalysis;
import com.communication.entity.FAppealAnalysisContent;
import com.communication.entity.ReportLog;
import com.communication.entity.User;
import com.communication.service.FAppealAnalysisService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.R;

/**
 * 申诉情况分析月报
 */
@Controller
@RequestMapping("/appeal_analysis")
public class FormAppealAnalysisController {
private static final Logger logger = LoggerFactory.getLogger(FormAppealAnalysisController.class);
	
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FAppealAnalysisService appealAnalysisService;
	
	/**
	 * 编辑
	 **/
	@RequestMapping("/edit/{report_log_id}")
	public String edit(@PathVariable("report_log_id") long reportLogId, Model model, HttpSession session) {
		User curUser = (User) session.getAttribute("curUser");
		ReportLog reportLog = reportLogService.find(reportLogId);
		if (reportLog.getToUser().getId() == curUser.getId()) {
			FAppealAnalysis appealAnalysis = appealAnalysisService.queryByReportLogId(reportLogId);
			if (null == appealAnalysis) {
				List<FAppealAnalysisContent> appealAnalysisContentList = new ArrayList<FAppealAnalysisContent>(5);
				for(int i=0;i<5;i++) {
					FAppealAnalysisContent appealAnalysisContent = new FAppealAnalysisContent();
					appealAnalysisContentList.add(appealAnalysisContent);
				}
				appealAnalysis = new FAppealAnalysis();
				appealAnalysis.setAppealAnalysisContentList(appealAnalysisContentList);
			}
			model.addAttribute("reportLog", reportLog);
			model.addAttribute("appealAnalysis", appealAnalysis);
		} else {
			return "redirect:/hasNoRight";
		}
		logger.info("编辑申诉情况分析月报：reportLogId：" + reportLogId);
		return "/form/form_appeal_analysis";
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

		FAppealAnalysis appealAnalysis = appealAnalysisService.queryByReportLogId(reportLogId);
		model.addAttribute("reportLog", reportLog);
		model.addAttribute("appealAnalysis", appealAnalysis);

		return "/form/form_appeal_analysis_view";
	}

	/**
	 * 保存
	 **/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody R save(@ModelAttribute("appealAnalysis") FAppealAnalysis appealAnalysis,@RequestParam("flag") String flag) {
		try {
			if (appealAnalysis.getId() > 0) {
				appealAnalysis.setUpdateTime(new Date());
				appealAnalysisService.update(appealAnalysis);
			} else {
				appealAnalysis.setInsertTime(new Date());
				appealAnalysis.setUpdateTime(new Date());
				appealAnalysisService.save(appealAnalysis);
			}

			ReportLog reportLog = reportLogService.find(appealAnalysis.getReportLogId());
			if ("1".equals(flag)) {
				reportLog.setStatus("1");
				reportLog.setAuditStatus("0");
				reportLog.setSubmitTime(new Date());
			} else {
				reportLog.setStatus("2");
			}
			reportLogService.update(reportLog);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return R.error("操作失败");
		}
		return R.ok("操作成功");
	}
}
