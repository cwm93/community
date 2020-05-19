package com.communication.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.FIOTSecurityManagement;
import com.communication.entity.FIOTSecurityManagementSegment;
import com.communication.entity.ReportLog;
import com.communication.service.FIOTSecurityManagementSegmentService;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.util.R;

@Controller
@RequestMapping("/iot_management_segment/")
public class FormIOTSecurityManagementSegmentController {
	
	private static Logger logger = LoggerFactory.getLogger(FormIOTSecurityManagementSegmentController.class);

	@Resource
	private ScheduleReportService scheduleReportService;
	@Resource
	private ReportLogService reportLogService;
	@Resource
	private FIOTSecurityManagementSegmentService fIOTSecurityManagementSegmentService;
	
	
	/**
	 * save action
	 **/
	@PostMapping("/save")
	public @ResponseBody R save(FIOTSecurityManagementSegment fIOTSecurityManagementSegment) {
		try {
			if (fIOTSecurityManagementSegment != null && fIOTSecurityManagementSegment.getId() > 0) {
				fIOTSecurityManagementSegment.setUpdateTime(new Date());
				fIOTSecurityManagementSegmentService.update(fIOTSecurityManagementSegment);
			} else {
				fIOTSecurityManagementSegment.setInsertTime(new Date());
				fIOTSecurityManagementSegment.setUpdateTime(new Date());
				fIOTSecurityManagementSegmentService.save(fIOTSecurityManagementSegment);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("保存数据失败");
			return R.error("操作失败");
		}
		return R.ok("操作成功");
	}
	
	/**
	 * delete action
	 **/
	@PostMapping("/delete")
	public @ResponseBody R delete(@RequestParam("id") Long id) {
		try {
			fIOTSecurityManagementSegmentService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("保存数据失败");
			return R.error("操作失败");
		}
		return R.ok("操作成功");
	}
	
	/**
	 * get list action
	 **/
	@GetMapping("/list")
	public @ResponseBody R list(@RequestParam("reportLogId") Long reportLogId) {
		List<FIOTSecurityManagementSegment> list = null;
		try {
			list = fIOTSecurityManagementSegmentService.queryListByReportLogId(reportLogId);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("获取数据失败");
		}
		return R.ok("获取数据成功").put("list", list);
	}
}
