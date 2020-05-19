package com.communication.administration.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.GLandlineFraudReport;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GLandlineFraudReportService;
import com.communication.util.Constants;

/**
 * 通讯信息诈骗举报（固定电话）
 **/
@Controller
@RequestMapping(value = "/gj/")
public class GLandlineFraudReportController {
	private static final Logger logger = Logger.getLogger(GLandlineFraudReportController.class);

	@Resource
	private GLandlineFraudReportService landlineFraudReportService;

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("f_txxxzpjb/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取信息诈骗信息（固定电话）");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GLandlineFraudReport> landlineFraudReportList = landlineFraudReportService.queryByYear(year);
		returnMap.put("landlineFraudReportList", landlineFraudReportList);
		return returnMap;
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("f_txxxzpjb/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long landlineFraudReportId) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GLandlineFraudReport landlineFraudReport = landlineFraudReportService.find(landlineFraudReportId);
		returnMap.put("entity", landlineFraudReport);
		return returnMap;
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "f_txxxzpjb/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GLandlineFraudReport landlineFraudReport, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (landlineFraudReport.getId() != null && landlineFraudReport.getId() > 0) {
				GLandlineFraudReport temp = landlineFraudReportService.find(landlineFraudReport.getId());
				temp.setField_11(landlineFraudReport.getField_11());
				temp.setField_12(landlineFraudReport.getField_12());
				temp.setField_13(landlineFraudReport.getField_13());
				temp.setField_21(landlineFraudReport.getField_21());
				temp.setField_22(landlineFraudReport.getField_22());
				temp.setField_23(landlineFraudReport.getField_23());
				temp.setField_31(landlineFraudReport.getField_31());
				temp.setField_32(landlineFraudReport.getField_32());
				temp.setField_33(landlineFraudReport.getField_33());
				temp.setUpdateTime(new Date());
				landlineFraudReportService.update(temp);
				status = "success";
			} else {
				if (landlineFraudReportService.isExisted(landlineFraudReport.getYear(),
						landlineFraudReport.getMonth())) {
					status = "fail";
				} else {
					landlineFraudReport.setCreateUserId((Long) session.getAttribute("curUserId"));
					landlineFraudReport.setInsertTime(new Date());
					landlineFraudReport.setUpdateTime(new Date());
					landlineFraudReportService.save(landlineFraudReport);
					status = "success";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		returnMap.put("status", status);
		return returnMap;
	}

	/**
	 * 删除操作
	 * 
	 * @param GLandlineFraudReport
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "f_txxxzpjb/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			landlineFraudReportService.deleteById(id);
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
	@RequestMapping(value = "f_txxxzpjb/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近通讯信息诈骗举报（固定号码）12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GLandlineFraudReport> landlineFraudReportList = landlineFraudReportService.queryByYear(year);
		/*
		 * if(landlineFraudReportList!=null) {
		 * Collections.reverse(landlineFraudReportList); }
		 */
		returnMap.put("landlineFraudReportList", landlineFraudReportList);
		return returnMap;
	}

}
