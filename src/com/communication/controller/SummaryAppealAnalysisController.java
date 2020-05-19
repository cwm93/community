package com.communication.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FAppealAnalysis;
import com.communication.entity.ReportLog;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.FAppealAnalysisService;
import com.communication.service.ReportLogService;
import com.communication.service.ReportService;
import com.communication.service.UserService;
import com.communication.util.Constants;
import com.communication.util.R;

/**
 * 申诉情况分析月报
 */
@Controller
@RequestMapping(value = "/summary")
public class SummaryAppealAnalysisController {

	private static final Logger logger = LoggerFactory.getLogger(SummaryAppealAnalysisController.class);
	@Resource
	private FAppealAnalysisService appealAnalysisService;
	@Resource
	private UserService userService;
	@Resource
	private ReportService reportService;
	@Resource
	private ReportLogService reportLogService;

	/**
	 * @author liliang
	 * @desc 申诉情况分析月报
	 * @param year,month,reportId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/appealAnalysisJson", method = RequestMethod.GET)
	public @ResponseBody R appealAnalysisJson(@RequestParam(value = "loadingYear", required = true) int loadingYear,
			@RequestParam(value = "loadingMonth", required = true) int loadingMonth,
			@RequestParam(value = "reportId", required = true) long reportId) {
		logger.info("获取申诉情况分析月报:" + loadingYear + "-" + loadingMonth);
		List<ReportLog> reportLogList =  reportLogService.queryByReport(reportId, loadingYear, loadingMonth, "0");
		
		return R.ok("获取数据成功").put("reportLogList", reportLogList);
	}
}
