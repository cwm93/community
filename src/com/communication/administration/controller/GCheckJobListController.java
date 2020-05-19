package com.communication.administration.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.GCheckJobList;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.GCheckJobListService;
import com.communication.util.Constants;
import com.communication.util.R;

@Controller
@RequestMapping(value = "/gj")
public class GCheckJobListController {
	
	private static final Logger logger = LoggerFactory.getLogger(GCheckJobListController.class);
	
	@Autowired
	private GCheckJobListService checkJobListService;
	
	/**
	 * 获取列表信息
	 * @param year
	 * @return R
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/checkjob/list", method = RequestMethod.GET)
	@ResponseBody
	public R list(@RequestParam("year") Integer year) {
		logger.info("获取"+year+"年的核查工单及时率及准确率情况");
		List<GCheckJobList> checkJobList = checkJobListService.queryByYear(year);
		return R.ok().put("checkJobList", checkJobList);
	}
	
	/**
	 * 获取详细信息
	 * @param id
	 * @return R
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping("/checkjob/detail")
	@ResponseBody
	public R detail(@RequestParam("id") Long id) {
		GCheckJobList checkJobList = checkJobListService.find(id);
		return R.ok().put("entity", checkJobList);
	}
	
	/**
	 * 保存信息
	 * @param GCutFees
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/checkjob/save", method = RequestMethod.POST)
	@ResponseBody
	public R save(GCheckJobList checkJobList, HttpSession session) {
		try {
			if (checkJobList.getId() != null && checkJobList.getId() > 0) {
				GCheckJobList temp = checkJobListService.find(checkJobList.getId());
				checkJobList.setCreateUserId(temp.getCreateUserId());
				checkJobList.setInsertTime(temp.getInsertTime());
				checkJobList.setUpdateTime(temp.getUpdateTime());
				checkJobList.setYear(temp.getYear());
				checkJobList.setMonth(temp.getMonth());
				BeanUtils.copyProperties(temp, checkJobList);  
				temp.setUpdateTime(new Date());
				checkJobListService.update(temp);
				return R.ok("更新成功");
			}else{
				if (checkJobListService.isExisted(checkJobList.getYear(), checkJobList.getMonth())) {
					return R.error("该月份数据已存在");
				} else {
					checkJobList.setInsertTime(new Date());
					checkJobList.setUpdateTime(new Date());
					checkJobList.setCreateUserId((Long) session.getAttribute("curUserId"));
					checkJobListService.save(checkJobList);
					return R.ok("添加成功");
				}
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return R.error("系统错误，稍后重试");
	}
	
	/**
	 * 删除操作
	 * @param GCutFees
	 * @return map
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/checkjob/delete", method = RequestMethod.POST)
	@ResponseBody
	public R delete(@RequestParam("id") Long id) {
		checkJobListService.deleteById(id);
		return R.ok("删除成功");
	}
	
}
