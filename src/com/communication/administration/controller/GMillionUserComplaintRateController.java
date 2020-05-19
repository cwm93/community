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

import com.communication.entity.GMillionUserComplaintRate;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GMillionUserComplaintRateService;
import com.communication.util.Constants;

/**
 * 百万用户申诉率
 **/
@Controller
@RequestMapping("/gj/")
public class GMillionUserComplaintRateController {
	private static Logger logger = LoggerFactory.getLogger(GBroadbandTariffController.class);

	@Autowired
	private GMillionUserComplaintRateService millionUserComplaintRateService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("bwyhss/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取宽带资费列表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GMillionUserComplaintRate> millionUserComplaintRateList = millionUserComplaintRateService
				.queryByYear(year);
		returnMap.put("millionUserComplaintRateList", millionUserComplaintRateList);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("bwyhss/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GMillionUserComplaintRate millionUserComplaintRate = millionUserComplaintRateService.find(id);
		returnMap.put("entity", millionUserComplaintRate);
		return returnMap;

	}

	/**
	 * 保存信息
	 * 
	 * @param GMillionUserComplaintRate
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "bwyhss/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GMillionUserComplaintRate millionUserComplaintRate, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (millionUserComplaintRate.getId() != null && millionUserComplaintRate.getId() > 0) {
				GMillionUserComplaintRate temp = millionUserComplaintRateService.find(millionUserComplaintRate.getId());
				millionUserComplaintRate.setYear(temp.getYear());
				millionUserComplaintRate.setMonth(temp.getMonth());
				millionUserComplaintRate.setInsertTime(temp.getInsertTime());
				millionUserComplaintRate.setUpdateTime(new Date());
				millionUserComplaintRate.setCreateUserId((Long) session.getAttribute("curUserId"));
				temp = millionUserComplaintRate;
				millionUserComplaintRateService.update(temp);
				status = "success";
			} else {
				if (millionUserComplaintRateService.isExisted(millionUserComplaintRate.getYear(),millionUserComplaintRate.getMonth())) {
					status = "fail";
				} else {
					millionUserComplaintRate.setInsertTime(new Date());
					millionUserComplaintRate.setUpdateTime(new Date());
					millionUserComplaintRate.setCreateUserId((Long) session.getAttribute("curUserId"));
					millionUserComplaintRateService.save(millionUserComplaintRate);
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
	 * @param GMillionUserComplaintRate
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "bwyhss/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			millionUserComplaintRateService.deleteById(id);
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
	@RequestMapping(value = "bwyhss/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近百万用户申诉率12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GMillionUserComplaintRate> millionUserComplaintRateList = millionUserComplaintRateService.queryByYear(year);
		/*
		 * if(millionUserComplaintRateList!=null) {
		 * Collections.reverse(millionUserComplaintRateList); }
		 */
		returnMap.put("millionUserComplaintRateList", millionUserComplaintRateList);
		return returnMap;
	}

}
