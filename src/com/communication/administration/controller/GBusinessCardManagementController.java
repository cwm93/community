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

import com.communication.entity.GBusinessCardManagement;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GBusinessCardManagementService;
import com.communication.util.Constants;

/**
 * 行业卡管理
 */
@Controller
@RequestMapping("/gj/")
public class GBusinessCardManagementController {
	private static Logger logger = LoggerFactory.getLogger(GBroadbandTariffController.class);

	@Autowired
	private GBusinessCardManagementService businessCardManagementService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("hykgl/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取行业卡数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GBusinessCardManagement> businessCardManagementlist = businessCardManagementService.queryByYear(year);
		returnMap.put("businessCardManagementlist", businessCardManagementlist);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("hykgl/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GBusinessCardManagement businessCardManagement = businessCardManagementService.find(id);
		returnMap.put("entity", businessCardManagement);
		return returnMap;

	}

	/**
	 * 保存信息
	 * 
	 * @param GBusinessCardManagement
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "hykgl/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GBusinessCardManagement businessCardManagement, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (businessCardManagement.getId() != null && businessCardManagement.getId() > 0) {
				GBusinessCardManagement temp = businessCardManagementService.find(businessCardManagement.getId());
				businessCardManagement.setYear(temp.getYear());
				businessCardManagement.setMonth(temp.getMonth());
				businessCardManagement.setInsertTime(temp.getInsertTime());
				businessCardManagement.setUpdateTime(new Date());
				businessCardManagement.setCreateUserId((Long) session.getAttribute("curUserId"));
				temp = businessCardManagement;
				businessCardManagementService.update(temp);
				status = "success";
			} else {
				if (businessCardManagementService.isExisted(businessCardManagement.getYear(),businessCardManagement.getMonth())) {
					status = "fail";
				} else {
					businessCardManagement.setInsertTime(new Date());
					businessCardManagement.setUpdateTime(new Date());
					businessCardManagement.setCreateUserId((Long) session.getAttribute("curUserId"));
					businessCardManagementService.save(businessCardManagement);
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
	 * @param GBusinessCardManagement
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "hykgl/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			businessCardManagementService.deleteById(id);
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
	@RequestMapping(value = "hykgl/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近行业卡管理12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GBusinessCardManagement> businessCardManagementList = businessCardManagementService.queryByYear(year);
		/*
		 * if(businessCardManagementList!=null) {
		 * Collections.reverse(businessCardManagementList); }
		 */
		returnMap.put("businessCardManagementList", businessCardManagementList);
		return returnMap;
	}
}
