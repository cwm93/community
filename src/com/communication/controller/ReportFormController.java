package com.communication.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.GInternetPlatformSpamMessage;
import com.communication.entity.GLandlineFraudReport;
import com.communication.entity.GMillionUserComplaintRate;
import com.communication.entity.GMobileFraudReport;
import com.communication.entity.GRealNameRegistration;
import com.communication.entity.GValueAddedTelecomBussiness;
import com.communication.entity.GVirtualOperator;
import com.communication.entity.GZoonValueAddedTelecomBussiness;
import com.communication.service.GInternetPlatformSpamMessageService;
import com.communication.service.GLandlineFraudReportService;
import com.communication.service.GMillionUserComplaintRateService;
import com.communication.service.GMobileFraudReportService;
import com.communication.service.GRealNameRegistrationService;
import com.communication.service.GValueAddedTelecomBussinessService;
import com.communication.service.GVirtualOperatorService;
import com.communication.service.GZoonValueAddedTelecomBussinessService;
import com.communication.service.ReportService;
import com.communication.util.R;

@Controller
@RequestMapping("/form")
public class ReportFormController {
	private static final Logger logger = LoggerFactory.getLogger(ReportFormController.class);

	@Resource
	private ReportService reportService;
	
	@Autowired
	private GRealNameRegistrationService realNameRegistrationService;
	
	@Autowired
	GMobileFraudReportService mobileFraudReportService;
	
	@Autowired
	private GLandlineFraudReportService landlineFraudReportService;
	
	@Autowired
	private GValueAddedTelecomBussinessService valueAddedTelecomBussinessService;
	
	@Autowired
	private GInternetPlatformSpamMessageService internetPlatformSpamMessageService;
	
	@Autowired
	private GZoonValueAddedTelecomBussinessService zoonValueAddedTelecomBussinessService;
	
	@Autowired
	private GMillionUserComplaintRateService millionUserComplaintRateService;
	
	@Autowired
	private GVirtualOperatorService virtualOperatorService;

	/**
	 * 预览模版报表模版
	 * 
	 **/
	@RequestMapping(value = "/{form_code}")
	public String preview(@PathVariable("form_code") String formCode) {
		logger.info("form tamplate view:formCode:" + formCode);
		return "formTamplate/form_" + formCode;
	}
	
	/**
	 *管理局统计表（总表）
	 **/
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	private String summary() {
		logger.info("summary loading...");
		return "/admin/summary_zpdf";
	}
	
	/**
	 *管理局统计表（总表）
	 **/
	@RequestMapping(value = "/summaryJson", method = RequestMethod.GET)
	private @ResponseBody R summaryJson(@RequestParam("loadingYear") Integer year,@RequestParam("loadingMonth") Integer month) {
		logger.info("summary loading...");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		/***1、实名制用户***/
		GRealNameRegistration realNameRegistration = realNameRegistrationService.queryOneByYearAndMonth(year,month);
		returnMap.put("realNameRegistration",realNameRegistration);
		
		/***2、通讯信息诈骗举报（手机号）***/
		GMobileFraudReport mobileFraudReport = mobileFraudReportService.queryOneByYearAndMonth(year,month);
		returnMap.put("mobileFraudReport",mobileFraudReport);
		
		/***3、通讯信息诈骗举报（固定号码）***/
		GLandlineFraudReport landlineFraudReport = landlineFraudReportService.queryOneByYearAndMonth(year,month);
		returnMap.put("landlineFraudReport",landlineFraudReport);
		
		/***4、网间平台垃圾短信举报***/
		GInternetPlatformSpamMessage internetPlatformSpamMessage = internetPlatformSpamMessageService.queryOneByYearAndMonth(year,month);
		returnMap.put("internetPlatformSpamMessage",internetPlatformSpamMessage);
		
		/***5、增值电信业务（总计家）***/
		GValueAddedTelecomBussiness valueAddedTelecomBussiness = valueAddedTelecomBussinessService.queryOneByYearAndMonth(year,month);
		returnMap.put("valueAddedTelecomBussiness",valueAddedTelecomBussiness);
		
		/***6、自贸区增值电信业务（总计家）***/
		GZoonValueAddedTelecomBussiness zoonValueAddedTelecomBussiness = zoonValueAddedTelecomBussinessService.queryOneByYearAndMonth(year,month);
		returnMap.put("zoonValueAddedTelecomBussiness",zoonValueAddedTelecomBussiness);
		
		/***7、百万用户申诉率、不明扣费申诉率***/
		GMillionUserComplaintRate millionUserComplaintRate = millionUserComplaintRateService.queryOneByYearAndMonth(year,month);
		returnMap.put("millionUserComplaintRate",millionUserComplaintRate);
		
		/***9、虚拟运营商***/
		GVirtualOperator virtualOperator = virtualOperatorService.queryOneByYearAndMonth(year,month);
		returnMap.put("virtualOperator",virtualOperator);
		
		return R.ok(returnMap);
	}
}
