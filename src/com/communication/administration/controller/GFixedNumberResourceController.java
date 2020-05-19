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

import com.communication.entity.GFixedNumberResource;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GFixedNumberResourceService;
import com.communication.util.Constants;

/**
 * 固定号码资源
 **/
@Controller
@RequestMapping("/gj/")
public class GFixedNumberResourceController {

	private static final Logger logger = Logger.getLogger(GFixedNumberResourceController.class);

	@Resource
	private GFixedNumberResourceService fixedNumberResourceService;

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("/gdhmzy/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam Integer year) {
		logger.info("获取固定号码资源");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GFixedNumberResource> fixedNumberResourceList = fixedNumberResourceService.queryByYear(year);
		returnMap.put("resourceList", fixedNumberResourceList);
		return returnMap;
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("/gdhmzy/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam Long id) {
		logger.info("获取固定号码资源");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GFixedNumberResource fixedNumberResource = fixedNumberResourceService.find(id);
		returnMap.put("entity", fixedNumberResource);
		return returnMap;
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/gdhmzy/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GFixedNumberResource gFixedNumberResource, HttpSession session) {
		logger.info("获取固定号码资源");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (gFixedNumberResource.getId() != null && gFixedNumberResource.getId() > 0) {
				GFixedNumberResource temp = fixedNumberResourceService.find(gFixedNumberResource.getId());
				temp.setField_11(gFixedNumberResource.getField_11());
				temp.setField_12(gFixedNumberResource.getField_12());
				temp.setField_21(gFixedNumberResource.getField_21());
				temp.setField_22(gFixedNumberResource.getField_22());
				temp.setField_31(gFixedNumberResource.getField_31());
				temp.setField_32(gFixedNumberResource.getField_32());
				temp.setUpdateTime(new Date());
				fixedNumberResourceService.update(temp);
				status = "success";
			} else {
				if (fixedNumberResourceService.isExisted(gFixedNumberResource.getYear(),gFixedNumberResource.getMonth())) {
					status = "fail";
				} else {
					gFixedNumberResource.setCreateUserId((Long) session.getAttribute("curUserId"));
					gFixedNumberResource.setInsertTime(new Date());
					gFixedNumberResource.setUpdateTime(new Date());
					fixedNumberResourceService.save(gFixedNumberResource);
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
	 * @param GFixedNumberResource
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/gdhmzy/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			fixedNumberResourceService.deleteById(id);
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
	@RequestMapping(value = "/gdhmzy/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近固定号码资源12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GFixedNumberResource> fixedNumberResourceList = fixedNumberResourceService.queryByYear(year);
		/*
		 * if(fixedNumberResourceList!=null) {
		 * Collections.reverse(fixedNumberResourceList); }
		 */
		returnMap.put("fixedNumberResourceList", fixedNumberResourceList);
		return returnMap;
	}

}
