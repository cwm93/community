package com.communication.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.communication.entity.Data;
import com.communication.entity.Report;
import com.communication.entity.ReportFormRemark;
import com.communication.entity.ReportKind;
import com.communication.entity.ReportType;
import com.communication.entity.Role;
import com.communication.entity.TelecomOperator;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.ReportFormRemarkService;
import com.communication.service.ReportKindService;
import com.communication.service.ReportService;
import com.communication.service.ReportTypeService;
import com.communication.service.RoleService;
import com.communication.service.TelecomOperatorService;
import com.communication.util.Constants;
import com.communication.util.R;

@Controller
@RequestMapping("/system")
public class SystemController {
	private static final Logger logger = LoggerFactory.getLogger(SystemController.class);
	
	@Resource
	private RoleService roleService;
	@Resource
	private TelecomOperatorService telecomOperatorService;
	@Resource
	private ReportService reportService;
	@Resource
	private ReportKindService reportKindService;
	@Resource
	private ReportTypeService reportTypeService;
	@Resource
	private ReportFormRemarkService reportFormRemarkService;

	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/roles", method = RequestMethod.GET)
	public String roles(Model model){
		logger.info("获取角色列表");
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "/system/roles";
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/operators", method = RequestMethod.GET)
	public String operators(Model model){
		logger.info("获取运营商列表");
		List<TelecomOperator> telecomOperators = telecomOperatorService.findAll();
		model.addAttribute("telecomOperators", telecomOperators);
		return "/system/operators";
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/reports", method = RequestMethod.GET)
	public String reports(Model model){
		logger.info("获取报表模板列表");
		List<Report> reports = reportService.findAll("reportType");
		model.addAttribute("reports", reports);
		return "/system/reports";
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/addReportModel", method = RequestMethod.GET)
	public String addReport(Model model){
		logger.info("新增报表页面");
		List<ReportKind> reportKinds = reportKindService.findAll();
		List<ReportType> reportTypes = reportTypeService.findAll();
		
		model.addAttribute("reportKinds", reportKinds);
		model.addAttribute("reportTypes", reportTypes);
		model.addAttribute("report", new Report());
		return "/system/add_report_model";
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/saveReportModel", method = RequestMethod.POST)
	public String saveReport(@ModelAttribute Report report,RedirectAttributes redirectAttributes){
		
		ReportKind reportKind = reportKindService.find(report.getReportKind().getId());
		ReportType reportType = reportTypeService.find(report.getReportType().getId());
		
		if(report.getId()!=null){
			Data data = Data.success("修改成功");
			Report updateReport = reportService.find(report.getId());
			updateReport.setTitle(report.getTitle());
			updateReport.setReportKind(reportKind);
			updateReport.setReportType(reportType);
			updateReport.setComment(report.getComment());
			updateReport.setUpdateTime(new Date());
			reportService.save(updateReport);
			redirectAttributes.addFlashAttribute("data", data);
			return "redirect:/system//editReportModel/"+report.getId();
		}else{
			report.setReportKind(reportKind);
			report.setReportType(reportType);
			report.setCreateTime(new Date());
			report.setUpdateTime(new Date());
			reportService.save(report);
			return "redirect:/system/reports";
		}
		
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/editReportModel/{id}", method = RequestMethod.GET)
	public String editReport(@PathVariable("id") Long id,Model model){
		logger.info("修改报表页面");
		List<ReportKind> reportKinds = reportKindService.findAll();
		List<ReportType> reportTypes = reportTypeService.findAll();
		Report report = reportService.find(id);
		model.addAttribute("reportKinds", reportKinds);
		model.addAttribute("reportTypes", reportTypes);
		model.addAttribute("report", report);
		return "/system/add_report_model";
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/reportFormRemark/{id}", method = RequestMethod.GET)
	public String reportFormRemark(@PathVariable("id") Long reportId,Model model){
		List<ReportFormRemark> reportFormRemarkList = reportFormRemarkService.list(reportId);
		Report report = reportService.find(reportId);
		model.addAttribute("report", report);
		model.addAttribute("reportFormRemarkList", reportFormRemarkList);
		return "/system/report_form_remark";
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/reportFormRemark/save", method = RequestMethod.POST)
	public @ResponseBody R saverReportFormRemark(ReportFormRemark reportFormRemark){
		if(reportFormRemark.getId()!=null&&reportFormRemark.getId()>0) {
			reportFormRemark.setUpdateTime(new Date());
			reportFormRemarkService.update(reportFormRemark);
		}else {
			reportFormRemark.setUpdateTime(new Date());
			reportFormRemark.setInsertTime(new Date());
			reportFormRemarkService.save(reportFormRemark);
		}
		return R.ok("编辑成功");
	}
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/reportFormRemark/detail", method = RequestMethod.GET)
	public @ResponseBody R reportFormRemarkDetail(@RequestParam("id") Long id){
		ReportFormRemark reportFormRemark = reportFormRemarkService.find(id);
		return R.ok("获取数据成功").put("reportFormRemark", reportFormRemark);
	}
}
