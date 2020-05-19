package com.communication.administration.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.GCheckedStore;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GCheckedStoreService;
import com.communication.util.Constants;

/**
 * 实名志愿者监督检查-志愿者检查门店数量form_03
 **/
@Controller
@RequestMapping(value = "/gj/")
public class GCheckedStoreController {

	private static final Logger logger = LoggerFactory.getLogger(GCheckedStoreController.class);

	@Resource
	private GCheckedStoreService checkedStoreService;

	/**
	 * 获取列表
	 * 
	 * @param year
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/zyzjcmdsl/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> list(@RequestParam Integer year) {
		logger.info("实名志愿者监督检查-志愿者检查门店数量列表获取");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GCheckedStore> checkedStores = new ArrayList<GCheckedStore>();
		try {
			checkedStores = checkedStoreService.queryListByYear(year);
		} catch (Exception e) {
			e.printStackTrace();
		}
		returnMap.put("checkedStoreList", checkedStores);
		return returnMap;
	}

	/**
	 * 获取单个详细
	 * 
	 * @param checkedStoreId
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/zyzjcmdsl/detail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDetail(@RequestParam("id") Long checkedStoreId) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GCheckedStore checkedStore = checkedStoreService.find(checkedStoreId);
		returnMap.put("entity", checkedStore);
		return returnMap;
	}

	/**
	 * 保存
	 * 
	 * @param checkedStore
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/zyzjcmdsl/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GCheckedStore checkedStore, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<>();
		String status = "error";

		try {
			if (checkedStore.getId() != null && checkedStore.getId() > 0) {
				GCheckedStore temp = checkedStoreService.find(checkedStore.getId());
				temp.setField_01(checkedStore.getField_01());
				temp.setField_02(checkedStore.getField_02());
				temp.setField_03(checkedStore.getField_03());
				temp.setField_04(checkedStore.getField_04());
				temp.setField_05(checkedStore.getField_05());
				temp.setField_06(checkedStore.getField_06());
				temp.setField_07(checkedStore.getField_07());
				temp.setField_08(checkedStore.getField_08());
				temp.setField_09(checkedStore.getField_09());
				temp.setUpdateTime(new Date());
				checkedStoreService.update(temp);
				status = "success";
			} else {
				if (checkedStoreService.isExisted(checkedStore.getYear(), checkedStore.getMonth())) {
					status = "fail";
				} else {
					checkedStore.setCreatedUserId((Long) session.getAttribute("curUserId"));
					checkedStore.setInsertTime(new Date());
					checkedStore.setUpdateTime(new Date());
					checkedStoreService.save(checkedStore);
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
	 * @param GCheckedStore
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "zyzjcmdsl/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			checkedStoreService.deleteById(id);
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
	@RequestMapping(value = "zyzjcmdsl/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近实名志愿者监督检查12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GCheckedStore> checkedStoreList = checkedStoreService.queryListByYear(year);
		/*
		 * if(checkedStoreList!=null) { Collections.reverse(checkedStoreList); }
		 */
		returnMap.put("checkedStoreList", checkedStoreList);
		return returnMap;
	}

}
