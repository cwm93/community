package com.communication.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.SmsEntity;
import com.communication.entity.SmsLogEntity;
import com.communication.service.SmsLogService;
import com.communication.service.SmsService;
import com.communication.util.R;
import com.communication.util.SMSUtil;

@Controller
@RequestMapping(value = "/sys/sms")
public class SysSmsController {

	private static final Logger logger = LoggerFactory.getLogger(SysSmsController.class);

	@Autowired
	private SmsService smsService;
	@Autowired
	private SmsLogService smsLogService;

	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String settingForm(Model model) {
		logger.info("短信设置");
		List<SmsEntity> list = smsService.findAll();
		model.addAttribute("smsList", list);
		return "/admin/sms/setting";
	}
	
	@RequestMapping(value = "/pieces", method = RequestMethod.GET)
	public @ResponseBody R getSmsPieces() {
		int smsPieces = SMSUtil.getSmsNumber();
		if(smsPieces<0) {
			return R.error("网络延迟");
		}
		return R.ok().put("pieces", smsPieces);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody R settingAction(HttpServletRequest request) {
		String smsLoginType = request.getParameter("sms_1");
		String smsAuditType = request.getParameter("sms_2");
		String smsSendType = request.getParameter("sms_3");
		try {
			SmsEntity sms = smsService.find(1);
			sms.setClosed(smsLoginType);
			smsService.update(sms);
			SmsEntity sms2 = smsService.find(2);
			sms2.setClosed(smsAuditType);
			smsService.update(sms2);
			SmsEntity sms3 = smsService.find(3);
			sms3.setClosed(smsSendType);
			smsService.update(sms3);
			sms = null;
			sms2 = null;
			sms3 = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.ok();
	}
	
	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	public @ResponseBody R smsLogs() {
		List<SmsLogEntity> list = smsLogService.queryAll();
		return R.ok().put("smsLogs", list);
	}
}
