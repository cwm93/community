package com.communication.administration.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.GRealNameRegistration;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GRealNameRegistrationService;
import com.communication.util.Constants;

/**
 * 实名制数据
 * 
 **/
@Controller
@RequestMapping(value = "/gj/")
public class GRealNameRegistrationController {

	private static final Logger logger = Logger.getLogger(GRealNameRegistrationController.class);

	@Autowired
	private GRealNameRegistrationService realNameRegistrationService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("smz/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取实名制数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GRealNameRegistration> realNameRegistrationList = realNameRegistrationService.queryByYear(year);
		returnMap.put("realNameRegistrationList", realNameRegistrationList);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("smz/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		logger.info("获取实名制详细数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GRealNameRegistration realNameRegistration = realNameRegistrationService.find(id);
		returnMap.put("entity", realNameRegistration);
		return returnMap;
	}

	/**
	 * 保存信息
	 * 
	 * @param GRealNameRegistration
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "smz/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GRealNameRegistration realNameRegistration, HttpSession session) {
		logger.info("保存实名制数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (realNameRegistration.getId() != null && realNameRegistration.getId() > 0) {
				GRealNameRegistration temp = realNameRegistrationService.find(realNameRegistration.getId());
				realNameRegistration.setYear(temp.getYear());
				realNameRegistration.setMonth(temp.getMonth());
				realNameRegistration.setCreateUserId(temp.getCreateUserId());
				realNameRegistration.setInsertTime(temp.getInsertTime());
				realNameRegistration.setUpdateTime(new Date());
				temp = realNameRegistration;
				realNameRegistrationService.update(temp);
				status = "success";
			} else {
				if (realNameRegistrationService.isExisted(realNameRegistration.getYear(),
						realNameRegistration.getMonth())) {
					status = "fail";
				} else {
					realNameRegistration.setCreateUserId((Long) session.getAttribute("curUserId"));
					realNameRegistration.setInsertTime(new Date());
					realNameRegistration.setUpdateTime(new Date());
					realNameRegistrationService.save(realNameRegistration);
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
	 * @param GRealNameRegistration
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "smz/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			realNameRegistrationService.deleteById(id);
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
	@RequestMapping(value = "smz/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取"+year+"年的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GRealNameRegistration> realNameRegistrationList = realNameRegistrationService.queryByYear(year);
		
		/*
		 * if(realNameRegistrationList!=null) {
		 * Collections.reverse(realNameRegistrationList); }
		 */
		returnMap.put("realNameRegistrationList", realNameRegistrationList);
		return returnMap;
	}
}
