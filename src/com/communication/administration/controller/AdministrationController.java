package com.communication.administration.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.communication.entity.AdministrationReport;
import com.communication.entity.GTelecomValueAdded;
import com.communication.entity.Role;
import com.communication.entity.User;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.AdministrationReportService;
import com.communication.service.GCodeClassificationService;
import com.communication.service.GTelecomValueAddedService;
import com.communication.service.UserService;
import com.communication.util.Constants;

@Controller
public class AdministrationController {
	private static final Logger logger = LoggerFactory.getLogger(AdministrationController.class);
	@Resource
	private AdministrationReportService administrationReportService;
	@Autowired
	private UserService userService;

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		long id = (long) session.getAttribute("curUserId");
		User currentUser = userService.find(id);
		Role role = currentUser.getRole();
		List<AdministrationReport> administrationReportList = new ArrayList<AdministrationReport>();
		if(role!=null) {
			if(role.getCode().equals(Constants.ROLE_ADMIN)) {
				administrationReportList = administrationReportService.findAll();
			}else {
				administrationReportList.addAll(currentUser.getAssignedAdministrationReports());
			}
		}
		model.addAttribute("administrationReportList", administrationReportList);
		return "/administration/index";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("adminstrationReport", new AdministrationReport());
		return "/administration/add";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("adminstrationReport") AdministrationReport entity) {
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		administrationReportService.save(entity);
		return "redirect:/administration/add";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_01", method = RequestMethod.GET)
	private String rpsmz() {
		logger.info("实名制数据页面");
		return "/administration/form_01";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_02", method = RequestMethod.GET)
	private String rpsmzqd() {
		logger.info("实名制渠道数据");
		return "/administration/form_02";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_03", method = RequestMethod.GET)
	private String rpsmzjyzjc() {
		logger.info("实名制志愿者检查");
		return "/administration/form_03";
	}
	
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_04", method = RequestMethod.GET)
	private String rptxxxzpjb() {
		logger.info("通讯信息诈骗举报（手机号）");
		return "/administration/form_04";
	}
	
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_05", method = RequestMethod.GET)
	private String rphzpjb() {
		logger.info("通讯行诈骗举报（固定电话）");
		return "/administration/form_05";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_06", method = RequestMethod.GET)
	private String rptxzpzb() {
		logger.info("打击通讯信息诈骗相关业务数据周报");
		return "/administration/form_06";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_07", method = RequestMethod.GET)
	private String rpljdxjb() {
		logger.info("网间平台垃圾短信举报");
		return "/administration/form_07";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_08", method = RequestMethod.GET)
	private String rpgwhmzy() {
		logger.info("固网号码资源");
		return "/administration/form_08";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_09", method = RequestMethod.GET)
	private String rpkdzf() {
		logger.info("宽带资费");
		return "/administration/form_09";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_10", method = RequestMethod.GET)
	private String rpjf() {
		logger.info("降费");
		return "/administration/form_10";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_11", method = RequestMethod.GET)
	private String rpzzdxyw() {
		logger.info("增值电信业务");
		return "/administration/form_11";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_12", method = RequestMethod.GET)
	private String rpzmqzzdxyw() {
		logger.info("自贸区增值电信业务");
		return "/administration/form_12";
	}

	@RequestMapping(value = "/administration/form_13", method = RequestMethod.GET)
	private String rpbwyhss() {
		logger.info("百万用户申诉率");
		return "/administration/form_13";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_14", method = RequestMethod.GET)
	private String rpxnyys() {
		logger.info("虚拟运营商");
		return "/administration/form_14";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_15", method = RequestMethod.GET)
	private String rphykgl() {
		logger.info("行业卡管理");
		return "/administration/form_15";
	}
	
	@Resource 
    private GCodeClassificationService codeClassificationService;
	
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_16", method = RequestMethod.GET)
	private String codeclass(Model model) {
		return "/administration/form_16";
	}
	
	/**
	 *各类增值电信业务统计数据（含自贸区） 
	 **/
	@Autowired
	private GTelecomValueAddedService telecomValueAddedService;
	
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_17", method = RequestMethod.GET)
	private String zzdxyw(Model model) {
		logger.info("form_17 loading...");
		List<GTelecomValueAdded> list = telecomValueAddedService.findAll();
		model.addAttribute("telecomValueAddedList", list);
		return "/administration/form_17";
	}
	
	/**
	 *本地移动通信转售企业业务统计表
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_18", method = RequestMethod.GET)
	private String zmqzzdxywsp() {
		logger.info("form_18 loading...");
		return "/administration/form_18";
	}

	
	/**
	 *全国核查工单及时率即准确率情况
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_19", method = RequestMethod.GET)
	private String jcgzjsl() {
		logger.info("form_19 loading...");
		return "/administration/form_19";
	}
	
	/**
	 * 物联网号段分配使用情况（管理处统计表）
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/administration/form_20", method = RequestMethod.GET)
	private String wlwhdfpqk() {
		logger.info("form_20 loading...");
		return "/administration/form_20";
	}
}

