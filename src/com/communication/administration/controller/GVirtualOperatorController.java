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

import com.communication.entity.GVirtualOperator;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GVirtualOperatorService;
import com.communication.util.Constants;

/**
 * 虚拟运营商
 */
@Controller
@RequestMapping("/gj/")
public class GVirtualOperatorController {

	private static Logger logger = LoggerFactory.getLogger(GBroadbandTariffController.class);

	@Autowired
	private GVirtualOperatorService virtualOperatorService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("xnyys/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取虚拟运营商数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GVirtualOperator> virtualOperatorList = virtualOperatorService.queryByYear(year);
		returnMap.put("virtualOperatorList", virtualOperatorList);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("xnyys/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GVirtualOperator virtualOperator = virtualOperatorService.find(id);
		returnMap.put("entity", virtualOperator);
		return returnMap;

	}

	/**
	 * 保存信息
	 * 
	 * @param GVirtualOperator
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "xnyys/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GVirtualOperator virtualOperator, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (virtualOperator.getId() != null && virtualOperator.getId() > 0) {
				GVirtualOperator temp = virtualOperatorService.find(virtualOperator.getId());
				virtualOperator.setYear(temp.getYear());
				virtualOperator.setMonth(temp.getMonth());
				virtualOperator.setInsertTime(temp.getInsertTime());
				virtualOperator.setUpdateTime(new Date());
				virtualOperator.setCreateUserId((Long) session.getAttribute("curUserId"));
				temp = virtualOperator;
				virtualOperatorService.update(temp);
				status = "success";
			} else {
				if (virtualOperatorService.isExisted(virtualOperator.getYear(), virtualOperator.getMonth())) {
					status = "fail";
				} else {
					virtualOperator.setInsertTime(new Date());
					virtualOperator.setUpdateTime(new Date());
					virtualOperator.setCreateUserId((Long) session.getAttribute("curUserId"));
					virtualOperatorService.save(virtualOperator);
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
	 * @param GVirtualOperator
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "xnyys/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			virtualOperatorService.deleteById(id);
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
	@RequestMapping(value = "xnyys/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近虚拟运营商12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GVirtualOperator> virtualOperatorList = virtualOperatorService.queryByYear(year);
		/*
		 * if(virtualOperatorList!=null) { Collections.reverse(virtualOperatorList); }
		 */
		returnMap.put("virtualOperatorList", virtualOperatorList);
		return returnMap;
	}

}
