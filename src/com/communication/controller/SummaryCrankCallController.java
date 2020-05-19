package com.communication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.ReportLog;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.FCrankCallService;
import com.communication.service.ReportLogService;
import com.communication.service.ReportService;
import com.communication.service.UserService;
import com.communication.util.Constants;
import com.communication.util.R;

@Controller
@RequestMapping("/summary")
public class SummaryCrankCallController {

	private static final Logger logger = LoggerFactory.getLogger(SummaryCrankCallController.class);
	
	@Resource
	private FCrankCallService crankCallService;
	@Resource
	private UserService userService;
	@Resource
	private ReportService reportService;
	@Resource
	private ReportLogService reportLogService;
	/**
	 * @author liliang
	 * @desc 骚扰电话举报分类汇总表
	 * @param year,month,reportId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/crankCallJson", method = RequestMethod.GET)
	public @ResponseBody R crankCallJson(@RequestParam("loadingYear") Integer year,
			@RequestParam("loadingMonth") Integer month, @RequestParam("reportId") Integer reportId) {
		logger.info("获取本地投诉情况:" + year + "-" + month);
		List<ReportLog> reportLogList = new ArrayList<ReportLog>();
		reportLogList = reportLogService.queryByReport(reportId, year, month, "0");
		return R.ok("获取数据成功").put("reportLogList", reportLogList);
	}
}
