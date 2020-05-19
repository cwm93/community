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

import com.communication.entity.GMobileResaleEnterprise;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GMobileResaleEnterpriseService;
import com.communication.util.Constants;

/**
 * 移动通信转售企业业务统计表																			
 **/
@Controller
@RequestMapping("/gj/")
public class GMobileResaleEnterpriseController {
	private static Logger logger = LoggerFactory.getLogger(GMobileResaleEnterpriseController.class);

	@Autowired
	private GMobileResaleEnterpriseService mobileResaleEnterpriseService;

	/**
	 * 获取列表信息
	 * 
	 * @param year
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("ydzsyw/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam("year") Integer year) {
		logger.info("获取虚拟运营商数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GMobileResaleEnterprise> mobileResaleEnterpriseList = mobileResaleEnterpriseService.queryListByYear(year);
		returnMap.put("mobileResaleEnterpriseList", mobileResaleEnterpriseList);
		return returnMap;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param id
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("ydzsyw/detail")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		GMobileResaleEnterprise virtualOperator = mobileResaleEnterpriseService.find(id);
		returnMap.put("entity", virtualOperator);
		return returnMap;

	}

	/**
	 * 保存信息
	 * 
	 * @param GMobileResaleEnterprise
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "ydzsyw/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(GMobileResaleEnterprise mobileResaleEnterprise, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";

		try {
			if (mobileResaleEnterprise.getId() != null && mobileResaleEnterprise.getId() > 0) {
				GMobileResaleEnterprise temp = mobileResaleEnterpriseService.find(mobileResaleEnterprise.getId());
				mobileResaleEnterprise.setYear(temp.getYear());
				mobileResaleEnterprise.setMonth(temp.getMonth());
				mobileResaleEnterprise.setInsertTime(temp.getInsertTime());
				mobileResaleEnterprise.setUpdateTime(new Date());
				mobileResaleEnterprise.setCreateUserId((Long) session.getAttribute("curUserId"));
				temp = mobileResaleEnterprise;
				mobileResaleEnterpriseService.update(temp);
				status = "success";
			} else {
				if (mobileResaleEnterpriseService.isExisted(mobileResaleEnterprise.getYear(), mobileResaleEnterprise.getMonth())) {
					status = "fail";
				} else {
					mobileResaleEnterprise.setInsertTime(new Date());
					mobileResaleEnterprise.setUpdateTime(new Date());
					mobileResaleEnterprise.setCreateUserId((Long) session.getAttribute("curUserId"));
					mobileResaleEnterpriseService.save(mobileResaleEnterprise);
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
	 * @param GMobileResaleEnterprise
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "ydzsyw/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String status = "error";
		try {
			mobileResaleEnterpriseService.deleteById(id);
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
	@RequestMapping(value = "ydzsyw/data_to_charts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getJsonData(@RequestParam("year") Integer year) {
		logger.info("获取最近移动通信转售企业业务统计表12个月的图表数据");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<GMobileResaleEnterprise> mobileResaleEnterpriseList = mobileResaleEnterpriseService.queryListByYear(year);
		/*
		 * if(mobileResaleEnterpriseList!=null) {
		 * Collections.reverse(mobileResaleEnterpriseList); }
		 */
		returnMap.put("mobileResaleEnterpriseList", mobileResaleEnterpriseList);
		return returnMap;
	}

}
