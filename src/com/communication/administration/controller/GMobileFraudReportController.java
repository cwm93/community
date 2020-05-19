package com.communication.administration.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.GMobileFraudReport;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GMobileFraudReportService;
import com.communication.util.Constants;

/**
 * 通讯信息诈骗举报（手机号）
 **/
@Controller
@RequestMapping(value = "/gj/")
public class GMobileFraudReportController {
	private static final Logger logger = Logger.getLogger(GMobileFraudReportController.class);

	@Resource
	GMobileFraudReportService mobileFraudReportService;

	/**
	 * 获取信息诈骗信息（手机号）
	 * 
	 * @param year
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("/m_txxxzpjb/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取信息诈骗信息（手机号）");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GMobileFraudReport> mobileFraudReportList = mobileFraudReportService.queryListByYear(year);
		returnMap.put("mobileFraudReportList", mobileFraudReportList);
		return returnMap;
	}

	/**
	 * 获取单条信息诈骗信息（手机号）
	 * 
	 * @param mobileFraudReportId
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("/m_txxxzpjb/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long mobileFraudReportId) {
		logger.info("获取信息诈骗信息（手机号）");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GMobileFraudReport mobileFraudReport = mobileFraudReportService.find(mobileFraudReportId);
		returnMap.put("entity", mobileFraudReport);
		return returnMap;
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/m_txxxzpjb/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GMobileFraudReport mobileFraudReport, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (mobileFraudReport.getId() != null && mobileFraudReport.getId() > 0) {
				GMobileFraudReport temp = mobileFraudReportService.find(mobileFraudReport.getId());
				temp.setField_11(mobileFraudReport.getField_11());
				temp.setField_12(mobileFraudReport.getField_12());
				temp.setField_13(mobileFraudReport.getField_13());
				temp.setField_21(mobileFraudReport.getField_21());
				temp.setField_22(mobileFraudReport.getField_22());
				temp.setField_23(mobileFraudReport.getField_23());
				temp.setField_31(mobileFraudReport.getField_31());
				temp.setField_32(mobileFraudReport.getField_32());
				temp.setField_33(mobileFraudReport.getField_33());
				temp.setUpdateTime(new Date());
				mobileFraudReportService.update(temp);
				status = "success";
			} else {
				if (mobileFraudReportService.isExisted(mobileFraudReport.getYear(), mobileFraudReport.getMonth())) {
					status = "fail";
				} else {
					mobileFraudReport.setCreateUserId((Long) session.getAttribute("curUserId"));
					mobileFraudReport.setInsertTime(new Date());
					mobileFraudReport.setUpdateTime(new Date());
					mobileFraudReportService.save(mobileFraudReport);
					status = "success";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = "error";
		}

		returnMap.put("status", status);
		return returnMap;
	}

	/**
	 * 删除操作
	 * 
	 * @param GMobileFraudReport
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/m_txxxzpjb/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			mobileFraudReportService.deleteById(id);
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();

		}
		returnMap.put("status", status);
		return returnMap;
	}
	
	/**
	 * 获取图表数据
	 * 
	 * @param null
	 * @return json
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "m_txxxzpjb/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近通讯信息诈骗举报（手机号）12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GMobileFraudReport> mobileFraudReportList = mobileFraudReportService.queryListByYear(year);
		/*
		 * if(mobileFraudReportList!=null) { Collections.reverse(mobileFraudReportList);
		 * }
		 */
		returnMap.put("mobileFraudReportList", mobileFraudReportList);
		return returnMap;
	}

}
