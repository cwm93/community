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

import com.communication.entity.GCutFees;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GCutFeesService;
import com.communication.util.Constants;

/**
 * 降费
 **/
@Controller
@RequestMapping("/gj/")
public class GCutFeesController {
	private static Logger logger = LoggerFactory.getLogger(GCutFeesController.class);

	@Autowired
	private GCutFeesService cutFeesService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("kdjf/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取宽带资费列表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GCutFees> cutFeesList = cutFeesService.queryByYear(year);
		returnMap.put("cutFeesList", cutFeesList);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("kdjf/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GCutFees cutFees = cutFeesService.find(id);
		returnMap.put("entity", cutFees);
		return returnMap;

	}

	/**
	 * 保存信息
	 * 
	 * @param GCutFees
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "kdjf/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GCutFees cutFees, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (cutFees.getId() != null && cutFees.getId() > 0) {
				GCutFees temp = cutFeesService.find(cutFees.getId());
				temp.setField_11(cutFees.getField_11());
				temp.setField_12(cutFees.getField_12());
				temp.setField_21(cutFees.getField_21());
				temp.setField_22(cutFees.getField_22());
				temp.setField_31(cutFees.getField_31());
				temp.setField_32(cutFees.getField_32());
				cutFeesService.update(temp);
				status = "success";
			} else {
				if (cutFeesService.isExisted(cutFees.getYear(), cutFees.getMonth())) {
					status = "fail";
				} else {
					cutFees.setInsertTime(new Date());
					cutFees.setUpdateTime(new Date());
					cutFees.setCreateUserId((Long) session.getAttribute("curUserId"));
					cutFeesService.save(cutFees);
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
	 * @param GCutFees
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "kdjf/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			cutFeesService.deleteById(id);
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
	@RequestMapping(value = "kdjf/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近实名制12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		List<GCutFees> cutFeesList = cutFeesService.queryByYear(year);
		
		/*
		 * if(cutFeesList!=null) { Collections.reverse(cutFeesList); }
		 */
		returnMap.put("cutFeesList", cutFeesList);
		return returnMap;
	}
}
