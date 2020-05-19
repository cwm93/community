package com.communication.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.ReportLog;
import com.communication.interceptor.RequiresPermission;
import com.communication.util.Constants;
import com.communication.util.R;

/**
 * 本地投诉情况
 **/
@Controller
@RequestMapping(value="/summary")
public class SummaryAppealLocalController {

	private static final Logger logger = LoggerFactory.getLogger(SummaryAppealLocalController.class);
	
	/**
	 * @author liliang
	 * @desc 本地投诉情况
	 * @param year,month,reportId;
	 */
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/appealLocalJson", method = RequestMethod.GET)
	public @ResponseBody R appealLocalJson(@RequestParam("loadingYear") Integer year,@RequestParam("loadingMonth") Integer month,@RequestParam("reportId") Integer reportId) {
		logger.info("获取本地投诉情况:"+year+"-"+month);
		List<ReportLog> reportLogList = new ArrayList<ReportLog>();
		reportLogList = null;
		return R.ok("获取数据成功").put("reportLogList", reportLogList);
	}
}
