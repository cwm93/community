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

import com.communication.entity.GZoonValueAddedTelecomBussiness;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GZoonValueAddedTelecomBussinessService;
import com.communication.util.Constants;

/**
 * 自贸区增值电信业务收入
 **/
@Controller
@RequestMapping("/gj/")
public class GZoonValueAddedTelecomBussinessController {

	private static Logger logger = LoggerFactory.getLogger(GZoonValueAddedTelecomBussinessController.class);

	@Autowired
	private GZoonValueAddedTelecomBussinessService zoonValueAddedTelecomBussinessService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("zmqdxywsr/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取自贸区增值电信业务收入列表");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GZoonValueAddedTelecomBussiness> list = zoonValueAddedTelecomBussinessService.queryByYear(year);
		returnMap.put("zoonValueAddedTelecomBussinessList", list);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("zmqdxywsr/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GZoonValueAddedTelecomBussiness zoonValueAddedTelecomBussiness = zoonValueAddedTelecomBussinessService.find(id);
		returnMap.put("entity", zoonValueAddedTelecomBussiness);
		return returnMap;
	}

	/**
	 * 保存信息
	 * 
	 * @param GVirtualOperator
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "zmqdxywsr/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GZoonValueAddedTelecomBussiness zoonValueAddedTelecomBussiness,
			HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (zoonValueAddedTelecomBussiness.getId() != null && zoonValueAddedTelecomBussiness.getId() > 0) {
				GZoonValueAddedTelecomBussiness temp = zoonValueAddedTelecomBussinessService.find(zoonValueAddedTelecomBussiness.getId());
				zoonValueAddedTelecomBussiness.setYear(temp.getYear());
				zoonValueAddedTelecomBussiness.setMonth(temp.getMonth());
				zoonValueAddedTelecomBussiness.setInsertTime(temp.getInsertTime());
				zoonValueAddedTelecomBussiness.setUpdateTime(new Date());
				zoonValueAddedTelecomBussiness.setCreateUserId((Long) session.getAttribute("curUserId"));
				temp = zoonValueAddedTelecomBussiness;
				zoonValueAddedTelecomBussinessService.update(temp);
				status = "success";
			} else {
				if (zoonValueAddedTelecomBussinessService.isExisted(zoonValueAddedTelecomBussiness.getYear(),
						zoonValueAddedTelecomBussiness.getMonth())) {
					status = "fail";
				} else {
					zoonValueAddedTelecomBussiness.setInsertTime(new Date());
					zoonValueAddedTelecomBussiness.setUpdateTime(new Date());
					zoonValueAddedTelecomBussiness.setCreateUserId((Long) session.getAttribute("curUserId"));
					zoonValueAddedTelecomBussinessService.save(zoonValueAddedTelecomBussiness);
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
	 * @param zoonValueAddedTelecomBussinessId
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "zmqdxywsr/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			zoonValueAddedTelecomBussinessService.deleteById(id);
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
	@RequestMapping(value = "zmqdxywsr/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近自贸区增值电信业务收入12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GZoonValueAddedTelecomBussiness> zoonValueAddedTelecomBussinessList = zoonValueAddedTelecomBussinessService.queryByYear(year);
		/*
		 * if(zoonValueAddedTelecomBussinessList!=null) {
		 * Collections.reverse(zoonValueAddedTelecomBussinessList); }
		 */
		returnMap.put("zoonValueAddedTelecomBussinessList", zoonValueAddedTelecomBussinessList);
		return returnMap;
	}
}
