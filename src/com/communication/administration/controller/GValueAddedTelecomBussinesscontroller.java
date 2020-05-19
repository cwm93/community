package com.communication.administration.controller;

import java.util.Date;
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

import com.communication.entity.GValueAddedTelecomBussiness;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GValueAddedTelecomBussinessService;
import com.communication.util.Constants;

/**
 * 增值电信业务
 **/
@Controller
@RequestMapping("/gj/")
public class GValueAddedTelecomBussinesscontroller {
	private static Logger logger = LoggerFactory.getLogger(GValueAddedTelecomBussinesscontroller.class);
	@Autowired
	private GValueAddedTelecomBussinessService valueAddedTelecomBussinessService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("zzdxyw/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取增值电信业务数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GValueAddedTelecomBussiness> valueAddedTelecomList = valueAddedTelecomBussinessService.queryByYear(year);
		returnMap.put("valueAddedTelecomList", valueAddedTelecomList);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("zzdxyw/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GValueAddedTelecomBussiness valueAddedTelecomBussiness = valueAddedTelecomBussinessService.find(id);
		returnMap.put("entity", valueAddedTelecomBussiness);
		return returnMap;

	}

	/**
	 * 保存信息
	 * 
	 * @param GValueAddedTelecomBussiness
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "zzdxyw/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GValueAddedTelecomBussiness valueAddedTelecomBussiness, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (valueAddedTelecomBussiness.getId() != null && valueAddedTelecomBussiness.getId() > 0) {
				GValueAddedTelecomBussiness temp = valueAddedTelecomBussinessService.find(valueAddedTelecomBussiness.getId());
				temp.setField_11(valueAddedTelecomBussiness.getField_11());
				temp.setField_12(valueAddedTelecomBussiness.getField_12());
				temp.setField_13(valueAddedTelecomBussiness.getField_13());
				temp.setField_14(valueAddedTelecomBussiness.getField_14());
				temp.setField_21(valueAddedTelecomBussiness.getField_21());
				temp.setField_22(valueAddedTelecomBussiness.getField_22());
				temp.setField_23(valueAddedTelecomBussiness.getField_23());
				temp.setField_24(valueAddedTelecomBussiness.getField_24());
				temp.setField_31(valueAddedTelecomBussiness.getField_31());
				temp.setField_32(valueAddedTelecomBussiness.getField_32());
				temp.setField_33(valueAddedTelecomBussiness.getField_33());
				temp.setField_34(valueAddedTelecomBussiness.getField_34());
				temp.setField_41(valueAddedTelecomBussiness.getField_41());
				temp.setField_42(valueAddedTelecomBussiness.getField_42());
				temp.setField_43(valueAddedTelecomBussiness.getField_43());
				temp.setField_44(valueAddedTelecomBussiness.getField_44());
				valueAddedTelecomBussinessService.update(temp);
				status = "success";
			} else {
				if (valueAddedTelecomBussinessService.isExisted(valueAddedTelecomBussiness.getYear(),valueAddedTelecomBussiness.getMonth())) {
					status = "fail";
				} else {
					valueAddedTelecomBussiness.setInsertTime(new Date());
					valueAddedTelecomBussiness.setUpdateTime(new Date());
					valueAddedTelecomBussiness.setCreateUserId((Long) session.getAttribute("curUserId"));
					valueAddedTelecomBussinessService.save(valueAddedTelecomBussiness);
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
	 * @param GValueAddedTelecomBussiness
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "zzdxyw/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			valueAddedTelecomBussinessService.deleteById(id);
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
	@RequestMapping(value = "zzdxyw/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近增值电信业务12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GValueAddedTelecomBussiness> valueAddedTelecomBussinessList = valueAddedTelecomBussinessService.queryByYear(year);
		/*
		 * if(valueAddedTelecomBussinessList!=null) {
		 * Collections.reverse(valueAddedTelecomBussinessList); }
		 */
		returnMap.put("valueAddedTelecomBussinessList", valueAddedTelecomBussinessList);
		return returnMap;
	}
}
