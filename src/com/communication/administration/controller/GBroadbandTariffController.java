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

import com.communication.entity.GBroadbandTariff;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GBroadbandTariffService;
import com.communication.util.Constants;

/**
 * 宽带资费
 **/
@Controller
@RequestMapping("/gj/")
public class GBroadbandTariffController {

	private static Logger logger = LoggerFactory.getLogger(GBroadbandTariffController.class);

	@Autowired
	private GBroadbandTariffService broadbandTariffService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("kdzf/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取宽带资费列表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GBroadbandTariff> broadbandTariffList = broadbandTariffService.queryByYear(year);
		returnMap.put("broadbandTariffList", broadbandTariffList);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("kdzf/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GBroadbandTariff broadbandTariff = broadbandTariffService.find(id);
		returnMap.put("entity", broadbandTariff);
		return returnMap;

	}

	/**
	 * 保存信息
	 * 
	 * @param GBroadbandTariff
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "kdzf/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GBroadbandTariff broadbandTariff, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (broadbandTariff.getId() != null && broadbandTariff.getId() > 0) {
				GBroadbandTariff temp = broadbandTariffService.find(broadbandTariff.getId());
				temp.setField_11(broadbandTariff.getField_11());
				temp.setField_12(broadbandTariff.getField_12());
				temp.setField_13(broadbandTariff.getField_13());
				temp.setField_21(broadbandTariff.getField_21());
				temp.setField_22(broadbandTariff.getField_22());
				temp.setField_23(broadbandTariff.getField_23());
				temp.setField_31(broadbandTariff.getField_31());
				temp.setField_32(broadbandTariff.getField_32());
				temp.setField_33(broadbandTariff.getField_33());
				temp.setField_41(broadbandTariff.getField_41());
				temp.setField_42(broadbandTariff.getField_42());
				temp.setField_43(broadbandTariff.getField_43());
				temp.setField_51(broadbandTariff.getField_51());
				temp.setField_52(broadbandTariff.getField_52());
				temp.setField_53(broadbandTariff.getField_53());
				broadbandTariffService.update(temp);
				status = "success";
			} else {
				if (broadbandTariffService.isExisted(broadbandTariff.getYear(), broadbandTariff.getMonth())) {
					status = "fail";
				} else {
					broadbandTariff.setInsertTime(new Date());
					broadbandTariff.setUpdateTime(new Date());
					broadbandTariff.setCreateUserId((Long) session.getAttribute("curUserId"));
					broadbandTariffService.save(broadbandTariff);
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
	 * @param GBroadbandTariff
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "kdzf/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			broadbandTariffService.deleteById(id);
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
	@RequestMapping(value = "kdzf/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近实名制12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
        List<GBroadbandTariff> broadbandTariffList = broadbandTariffService.queryByYear(year);
		
		/*
		 * if(broadbandTariffList!=null) { Collections.reverse(broadbandTariffList); }
		 */
		returnMap.put("broadbandTariffList", broadbandTariffList);
		return returnMap;
	}

}
