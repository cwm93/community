package com.communication.administration.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.Data;
import com.communication.entity.GRealNameRegistrationChannel;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GRealNameRegistrationChannelService;
import com.communication.util.Constants;

/**
 * @author liliang 通信管理局--实名制渠道
 */
@Controller
@RequestMapping(value = "/gj/")
public class GRealNameRegistrationChannelController {

	private static final Logger logger = LoggerFactory.getLogger(GRealNameRegistrationChannelController.class);
	@Resource
	private GRealNameRegistrationChannelService realNameRegistrationChannelService;

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "smzqd/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response) {
		logger.info("获取实名制渠道数据列表");
		Map<String, Object> returnMap = new HashMap<>();
		Data data = Data.failure("获取数据失败！");

		int year = Integer.valueOf(request.getParameter("year"));
		List<GRealNameRegistrationChannel> realNameRegistrationChannelList = new ArrayList<GRealNameRegistrationChannel>();
		try {
			realNameRegistrationChannelList = realNameRegistrationChannelService.queryListByYear(year);
			data = Data.success("获取数据成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		returnMap.put("realNameRegistrationChannelList", realNameRegistrationChannelList);
		returnMap.put("data", data);
		return returnMap;
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "smzqd/edit", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> edit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<>();
		Data data = Data.failure("获取数据失败！");

		long id = request.getParameter("id") == null ? 0L : Long.valueOf(request.getParameter("id"));
		GRealNameRegistrationChannel realNameRegistrationChannel = new GRealNameRegistrationChannel();
		try {
			realNameRegistrationChannel = realNameRegistrationChannelService.find(id);
			data = Data.success("获取数据成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}

		returnMap.put("realNameRegistrationChannel", realNameRegistrationChannel);
		returnMap.put("data", data);
		return returnMap;
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "smzqd/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GRealNameRegistrationChannel realNameRegistrationChannel,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<>();
		Data data = Data.failure("操作失败");
		HttpSession session = request.getSession();

		try {
			if (realNameRegistrationChannel.getId() > 0) {
				GRealNameRegistrationChannel temp = realNameRegistrationChannelService.find(realNameRegistrationChannel.getId());
				temp.setFiled_01(realNameRegistrationChannel.getFiled_01());
				temp.setFiled_02(realNameRegistrationChannel.getFiled_02());
				temp.setFiled_03(realNameRegistrationChannel.getFiled_03());
				temp.setFiled_04(realNameRegistrationChannel.getFiled_04());
				temp.setFiled_05(realNameRegistrationChannel.getFiled_05());
				temp.setFiled_06(realNameRegistrationChannel.getFiled_06());
				temp.setUpdateTime(new Date());
				realNameRegistrationChannelService.update(temp);
				data = Data.success("操作成功");
			} else {
				if (realNameRegistrationChannelService.isExisted(realNameRegistrationChannel.getYear(),realNameRegistrationChannel.getMonth())) {
					data = Data.failure("该月份数据已经存在");
				} else {
					realNameRegistrationChannel.setInsertTime(new Date());
					realNameRegistrationChannel.setUpdateTime(new Date());
					realNameRegistrationChannel.setCreatedUserId((Long) session.getAttribute("curUserId"));
					realNameRegistrationChannelService.save(realNameRegistrationChannel);
					data = Data.success("操作成功");
				}
			}

		} catch (Exception e) {
			data = Data.failure("系统异常");
		}

		returnMap.put("data", data);
		return returnMap;
	}

	/**
	 * 删除操作
	 * 
	 * @param GRealNameRegistrationChannel
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "smzqd/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			realNameRegistrationChannelService.deleteById(id);
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
	@RequestMapping(value = "smzqd/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近实名制渠道12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GRealNameRegistrationChannel> realNameRegistrationChannelList = realNameRegistrationChannelService.queryListByYear(year);
		/*
		 * if(realNameRegistrationChannelList!=null) {
		 * Collections.reverse(realNameRegistrationChannelList); }
		 */	
		returnMap.put("realNameRegistrationChannelList", realNameRegistrationChannelList);
		return returnMap;
	}

}