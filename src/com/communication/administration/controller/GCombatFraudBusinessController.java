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

import com.communication.entity.GCombatFraudBusiness;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GCombatFraudBusinessService;
import com.communication.util.Constants;

/**
 * 打击通讯信息诈骗相关业务数据周报
 **/
@Controller
@RequestMapping(value = "/gj/")
public class GCombatFraudBusinessController {

	private static final Logger logger = Logger.getLogger(GCombatFraudBusinessController.class);

	@Resource
	private GCombatFraudBusinessService combatFraudBusinessService;

	/**
	 * 获取列表
	 * 
	 * @param year
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "djxxzpsjzb/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取打击通讯信息诈骗相关业务数据周报");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GCombatFraudBusiness> combatFraudBusinessList = combatFraudBusinessService.queryByYear(year);
		returnMap.put("combatFraudBusinessList", combatFraudBusinessList);
		return returnMap;
	}

	/**
	 * 获取单条详细信息
	 * 
	 * @param combatFraudBusinessId
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "djxxzpsjzb/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long combatFraudBusinessId) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GCombatFraudBusiness combatFraudBusiness = combatFraudBusinessService.find(combatFraudBusinessId);
		returnMap.put("entity", combatFraudBusiness);
		return returnMap;
	}

	/**
	 * 获取单条详细信息
	 * 
	 * @param combatFraudBusinessId
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "djxxzpsjzb/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GCombatFraudBusiness combatFraudBusiness, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (combatFraudBusiness.getId() != null && combatFraudBusiness.getId() > 0) {
				GCombatFraudBusiness temp = combatFraudBusinessService.find(combatFraudBusiness.getId());
				temp.setField_11(combatFraudBusiness.getField_11());
				temp.setField_12(combatFraudBusiness.getField_12());
				temp.setField_13(combatFraudBusiness.getField_13());
				temp.setField_21(combatFraudBusiness.getField_21());
				temp.setField_22(combatFraudBusiness.getField_22());
				temp.setField_23(combatFraudBusiness.getField_23());
				temp.setField_31(combatFraudBusiness.getField_31());
				temp.setField_32(combatFraudBusiness.getField_32());
				temp.setField_33(combatFraudBusiness.getField_33());
				temp.setField_41(combatFraudBusiness.getField_41());
				temp.setField_42(combatFraudBusiness.getField_42());
				temp.setField_43(combatFraudBusiness.getField_43());
				temp.setField_51(combatFraudBusiness.getField_51());
				temp.setField_61(combatFraudBusiness.getField_61());
				temp.setField_62(combatFraudBusiness.getField_62());
				temp.setField_71(combatFraudBusiness.getField_71());
				temp.setField_81(combatFraudBusiness.getField_81());
				temp.setUpdateTime(new Date());
				combatFraudBusinessService.update(temp);
				status = "success";
			} else {
				if (combatFraudBusinessService.isExisted(combatFraudBusiness.getYear(), combatFraudBusiness.getMonth(),combatFraudBusiness.getDay())) {
					status = "fail";
				} else {
					combatFraudBusiness.setCreateUserId((Long) session.getAttribute("curUserId"));
					combatFraudBusiness.setInsertTime(new Date());
					combatFraudBusiness.setUpdateTime(new Date());
					combatFraudBusinessService.save(combatFraudBusiness);
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
	 * @param combatFraudBusinessId
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "djxxzpsjzb/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			combatFraudBusinessService.deleteById(id);
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
	@RequestMapping(value = "djxxzpsjzb/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近打击通讯信息诈骗相关业务数据周报15个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GCombatFraudBusiness> combatFraudBusinessList = combatFraudBusinessService.queryByYear(year);
		/*
		 * if(combatFraudBusinessList!=null) {
		 * Collections.reverse(combatFraudBusinessList); }
		 */
		returnMap.put("combatFraudBusinessList", combatFraudBusinessList);
		return returnMap;
	}

}
