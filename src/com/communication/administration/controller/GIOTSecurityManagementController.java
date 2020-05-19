package com.communication.administration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.Data;
import com.communication.entity.ReportLog;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.FIOTSecurityManagementSegmentService;
import com.communication.service.ReportLogService;
import com.communication.util.Constants;

/**
 * 1、物联网号段分配使用情况（管理处统计表）
 * 2、直接读取数据库表，不再新建表格
 **/
@Controller
@RequestMapping("/gj/")
public class GIOTSecurityManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(GIOTSecurityManagementController.class);
	@Autowired
	private FIOTSecurityManagementSegmentService iOTSecurityManagementSegmentService; 
	@Autowired
	private ReportLogService reportLogService;
	
	/**
	 * 获取列表
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/codeclass/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year, @RequestParam("month") Integer month) {
		logger.info("物联网号段分配使用情况（管理处统计表）");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Data data = Data.failure("操作失败");
		try {
			//List<ReportLog> reportLogList = reportLogService.quer
			//iOTSecurityManagementSegmentService.
		}catch (Exception e) {
			data = Data.failure("系统异常");
		}
		returnMap.put("data", data);
		return returnMap;
	}

}
