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

import com.communication.entity.GInternetPlatformSpamMessage;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GInternetPlatformSpamMessageService;
import com.communication.util.Constants;

/**
 * 网间平台垃圾短信举报
 **/
@Controller
@RequestMapping(value = "/gj/")
public class GInternetPlatformSpamMessageController {

	private static final Logger logger = Logger.getLogger(GInternetPlatformSpamMessageController.class);
	@Resource
	private GInternetPlatformSpamMessageService internetPlatformSpamMessageService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("ljdxjb/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取网间平台垃圾短信举报数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GInternetPlatformSpamMessage> gInternetPlatformSpamMessageList = internetPlatformSpamMessageService
				.queryByYear(year);
		returnMap.put("gInternetPlatformSpamMessageList", gInternetPlatformSpamMessageList);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("ljdxjb/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GInternetPlatformSpamMessage gInternetPlatformSpamMessage = internetPlatformSpamMessageService.find(id);
		returnMap.put("entity", gInternetPlatformSpamMessage);
		return returnMap;
	}

	/**
	 * 保存信息
	 * 
	 * @param GInternetPlatformSpamMessage
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "ljdxjb/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GInternetPlatformSpamMessage gInternetPlatformSpamMessage, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			if (gInternetPlatformSpamMessage.getId() != null && gInternetPlatformSpamMessage.getId() > 0) {
				GInternetPlatformSpamMessage temp = internetPlatformSpamMessageService
						.find(gInternetPlatformSpamMessage.getId());
				temp.setField_11(gInternetPlatformSpamMessage.getField_11());
				temp.setField_12(gInternetPlatformSpamMessage.getField_12());
				temp.setField_13(gInternetPlatformSpamMessage.getField_13());
				temp.setField_14(gInternetPlatformSpamMessage.getField_14());
				temp.setField_15(gInternetPlatformSpamMessage.getField_15());
				temp.setField_16(gInternetPlatformSpamMessage.getField_16());
				temp.setField_17(gInternetPlatformSpamMessage.getField_17());
				temp.setField_21(gInternetPlatformSpamMessage.getField_21());
				temp.setField_22(gInternetPlatformSpamMessage.getField_22());
				temp.setField_23(gInternetPlatformSpamMessage.getField_23());
				temp.setField_24(gInternetPlatformSpamMessage.getField_24());
				temp.setField_25(gInternetPlatformSpamMessage.getField_25());
				temp.setField_26(gInternetPlatformSpamMessage.getField_26());
				temp.setField_27(gInternetPlatformSpamMessage.getField_27());
				temp.setField_31(gInternetPlatformSpamMessage.getField_31());
				temp.setField_32(gInternetPlatformSpamMessage.getField_32());
				temp.setField_33(gInternetPlatformSpamMessage.getField_33());
				temp.setField_34(gInternetPlatformSpamMessage.getField_34());
				temp.setField_35(gInternetPlatformSpamMessage.getField_35());
				temp.setField_36(gInternetPlatformSpamMessage.getField_36());
				temp.setField_37(gInternetPlatformSpamMessage.getField_37());
				temp.setUpdateTime(new Date());
				internetPlatformSpamMessageService.update(temp);
				status = "success";
			} else {
				if (internetPlatformSpamMessageService.isExisted(gInternetPlatformSpamMessage.getYear(),gInternetPlatformSpamMessage.getMonth())) {
					status = "fail";
				} else {
					gInternetPlatformSpamMessage.setCreateUserId((Long) session.getAttribute("curUserId"));
					gInternetPlatformSpamMessage.setInsertTime(new Date());
					gInternetPlatformSpamMessage.setUpdateTime(new Date());
					internetPlatformSpamMessageService.save(gInternetPlatformSpamMessage);
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
	 * @param GInternetPlatformSpamMessage
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "ljdxjb/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			internetPlatformSpamMessageService.deleteById(id);
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
	@RequestMapping(value = "ljdxjb/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近实名制12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GInternetPlatformSpamMessage> internetPlatformSpamMessageList = internetPlatformSpamMessageService.queryByYear(year);
		/*
		 * if(internetPlatformSpamMessageList!=null) {
		 * Collections.reverse(internetPlatformSpamMessageList); }
		 */
		returnMap.put("internetPlatformSpamMessageList", internetPlatformSpamMessageList);
		return returnMap;
	}

}
