package com.communication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.Data;
import com.communication.entity.ReportLog;
import com.communication.entity.Role;
import com.communication.entity.SmsLogEntity;
import com.communication.entity.User;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.AutoDataService;
import com.communication.service.ReportLogService;
import com.communication.service.ReportService;
import com.communication.service.SmsLogService;
import com.communication.service.SmsService;
import com.communication.service.UserService;
import com.communication.util.Constants;
import com.communication.util.HttpClientUtil;
import com.communication.util.Pager;
import com.communication.util.SMSUtil;

@Controller
public class ReportLogController {

	private static Logger logger = LoggerFactory.getLogger(ReportLogController.class);

	@Resource
	private ReportLogService reportLogService;
	@Resource
	private UserService userService;
	@Resource
	private ReportService reportService;
	
	@Autowired
	private AutoDataService autoDataService;
	@Autowired
	private SmsLogService smsLogService;
	@Autowired
	private SmsService smsService;
	
	private int returnCode = 0;
	private SmsLogEntity smsLogEntity = null;
	private StringBuffer smsContent = null;

	/**
	 * 未填写的报表
	 **/
	@RequestMapping(value = { "/report/under" }, method = RequestMethod.GET)
	public String under(Model model, HttpServletRequest request, HttpSession session) {
		logger.info("访问未填写的报表");
		User curUser = (User) session.getAttribute("curUser");
		if (curUser == null) {
			return "redirect:/login";
		}
		/******** 1、分页设置 ***********/
		Pager pager = new Pager();
		int currentPage = (request.getParameter("p") == null || request.getParameter("p") == "") ? 1
				: Integer.valueOf(request.getParameter("p"));
		int totalPage = 0;
		long totalSize = 0;
		int pageSize = 15;

		Role role = curUser.getRole();

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		if (role.getCode().equals("ADMIN")) {
			totalSize = reportLogService.ncount("1", "0");
		} else if (role.getCode().equals("SUBADMIN")) {
			totalSize = reportLogService.ncountByFromUser(curUser, "1", "0");
		} else {
			totalSize = reportLogService.ncountByToUser(curUser, "1", "0");
		}
		int mod = (int) (totalSize % pageSize);
		if (mod == 0) {
			totalPage = (int) (totalSize / pageSize);
		} else {
			totalPage = (int) (totalSize / pageSize + 1);
		}
		pager.setCurrentPage(String.valueOf(currentPage));
		pager.setPageSize(String.valueOf(pageSize));
		pager.setTotalSize(totalSize);

		if (role.getCode().equals("ADMIN")) {
			reportLogList = reportLogService.nquery("1", pager, "0");
		} else if (role.getCode().equals("SUBADMIN")) {
			reportLogList = reportLogService.nqueryByFromUser(curUser, "1", pager, "0");
		} else {
			reportLogList = reportLogService.nqueryByToUser(curUser, "1", pager, "0");
		}
		model.addAttribute("pager", pager);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("p", currentPage);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("reportLogList", reportLogList);
		return "/report/list";
	}

	/**
	 * 历史报表
	 **/
	@RequestMapping("/report/history")
	public String history(Model model, HttpServletRequest request, HttpSession session) {
		logger.info("访问历史报表");
		User curUser = (User) session.getAttribute("curUser");
		if (curUser == null) {
			return "redirect:/login";
		}
		/******** 1、分页设置 ***********/
		Pager pager = new Pager();
		int currentPage = (request.getParameter("p") == null || request.getParameter("p") == "") ? 1
				: Integer.valueOf(request.getParameter("p"));
		int totalPage = 0;
		long totalSize = 0;
		int pageSize = 15;
		String auditStatus = request.getParameter("audit") == null ? "" : request.getParameter("audit");
		Role role = curUser.getRole();

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();
		if (auditStatus.equals("")) {
			if (role.getCode().equals("ADMIN")) {
				totalSize = reportLogService.count("1", "0");
			} else if (role.getCode().equals("SUBADMIN")) {
				totalSize = reportLogService.countByFromUser(curUser, "1", "0");
			} else {
				totalSize = reportLogService.countByToUser(curUser, "1", "0");
			}
			int mod = (int) (totalSize % pageSize);
			if (mod == 0) {
				totalPage = (int) (totalSize / pageSize);
			} else {
				totalPage = (int) (totalSize / pageSize + 1);
			}
			pager.setCurrentPage(String.valueOf(currentPage));
			pager.setPageSize(String.valueOf(pageSize));
			pager.setTotalSize(totalSize);

			if (role.getCode().equals("ADMIN")) {
				reportLogList = reportLogService.query("1", pager, "0");
			} else if (role.getCode().equals("SUBADMIN")) {
				reportLogList = reportLogService.queryByFromUser(curUser, "1", pager, "0");
			} else {
				reportLogList = reportLogService.queryByToUser(curUser, "1", pager, "0");
			}
		} else {
			if (role.getCode().equals("ADMIN")) {
				totalSize = reportLogService.count("1", "0",auditStatus);
			} else if (role.getCode().equals("SUBADMIN")) {
				totalSize = reportLogService.countByFromUser(curUser, "1", "0",auditStatus);
			} else {
				totalSize = reportLogService.countByToUser(curUser, "1", "0",auditStatus);
			}
			int mod = (int) (totalSize % pageSize);
			if (mod == 0) {
				totalPage = (int) (totalSize / pageSize);
			} else {
				totalPage = (int) (totalSize / pageSize + 1);
			}
			pager.setCurrentPage(String.valueOf(currentPage));
			pager.setPageSize(String.valueOf(pageSize));
			pager.setTotalSize(totalSize);

			if (role.getCode().equals("ADMIN")) {
				reportLogList = reportLogService.query("1", pager, "0",auditStatus);
			} else if (role.getCode().equals("SUBADMIN")) {
				reportLogList = reportLogService.queryByFromUser(curUser, "1", pager, "0",auditStatus);
			} else {
				reportLogList = reportLogService.queryByToUser(curUser, "1", pager, "0",auditStatus);
			}
		}

		model.addAttribute("pager", pager);
		model.addAttribute("p", currentPage);
		model.addAttribute("audit", auditStatus);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("reportLogList", reportLogList);
		return "/report/list_history";
	}

	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/report/audit", method = RequestMethod.POST)
	@ResponseBody
	public Data postAudit(HttpServletRequest request, HttpSession session) {
		Data data = Data.failure("操作失败");
		logger.info("审核报表");
		User curUser = (User) session.getAttribute("curUser");

		String status = request.getParameter("status");
		String auditReason = request.getParameter("auditReason");
		Long reportLogId = Long.valueOf(request.getParameter("reportLogId"));
		ReportLog reportLog = reportLogService.find(reportLogId);
		try {
			reportLog.setAuditStatus(status);
			reportLog.setAuditUserId(curUser.getId());
			reportLog.setAuditTime(new Date());
			reportLog.setAuditReason(auditReason);
			reportLogService.update(reportLog);
			
			//管理处获取表单数据
			if("1".equals(status)) {
				autoDataService.saveAuto(reportLog.getReport().getId(), reportLog.getWriteYear(), reportLog.getWriteMonth());
			}
			
			//发送短消息
			if("2".equals(status) && smsService.isOpen(2)) {
				smsContent = new StringBuffer();
				smsContent.append("您填写的报表【");
				smsContent.append(reportLog.getTitle());
				smsContent.append("】已被退回，退回理由：");
				smsContent.append(auditReason);
				returnCode = SMSUtil.sendSms(reportLog.getToUser().getMobile(), smsContent.toString());
				smsLogEntity  = new SmsLogEntity();
				if(returnCode>0) {
					smsLogEntity.setStatus("1");
					smsLogEntity.setPieces(returnCode);
					smsLogEntity.setContent(reportLog.getToUser().getRealname()+"的表格【"+reportLog.getTitle()+"】审核退回通知发送成功!");
				}else {
					HttpClientUtil httpClient = HttpClientUtil.getInstance();
					smsLogEntity.setStatus("-1");
					smsLogEntity.setPieces(0);
					smsLogEntity.setContent(reportLog.getToUser().getRealname()+"的表格【"+reportLog.getTitle()+"】审核退回通知发送失败!失败原因:"+httpClient.getErrorMsg(returnCode));
				}
				smsLogEntity.setInsertTime(new Date());
				smsLogService.save(smsLogEntity);
				smsContent = null;
				smsLogEntity = null;
			}
			data = Data.success("操作成功");
		} catch(Exception e) {
			e.printStackTrace();
			data = Data.failure("操作失败");
		}
		return data;

	}

	/**
	 * 回收报表
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/reportlog/delete", method = RequestMethod.POST)
	@ResponseBody
	public Data deleteReportLog(HttpServletRequest request, HttpServletResponse response) {
		Data data = Data.failure("操作失败");
		logger.info("删除报表");
		HttpSession session = request.getSession();
		User curUser = (User) session.getAttribute("curUser");

		Long reportLogId = Long.valueOf(request.getParameter("reportLogId"));

		ReportLog reportLog = reportLogService.find(reportLogId);
		try {
			reportLog.setIsDeleted("1");
			reportLog.setDeletedUserId(curUser.getId());
			reportLog.setDeletedTime(new Date());
			reportLogService.update(reportLog);
			data = Data.success("删除操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("删除操作失败");
		}
		return data;
	}

	/**
	 * 恢复报表
	 **/
	@RequiresPermission(values = { Constants.ROLE_ADMIN, Constants.ROLE_SUBADMIN })
	@RequestMapping(value = "/reportlog/restore", method = RequestMethod.POST)
	@ResponseBody
	public Data restoreReportLog(HttpServletRequest request, HttpServletResponse response) {
		Data data = Data.failure("操作异常");
		logger.info("恢复报表");

		Long reportLogId = Long.valueOf(request.getParameter("reportLogId"));

		ReportLog reportLog = reportLogService.find(reportLogId);
		try {
			reportLog.setIsDeleted("0");
			reportLogService.update(reportLog);
			data = Data.success("恢复操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			data = Data.failure("恢复操作失败");
		}
		return data;
	}

	/**
	 * 回收的报表
	 **/
	@RequestMapping("/report/deleted")
	public String deletedList(Model model, HttpServletRequest request, HttpSession session) {
		logger.info("访问回收的报表");
		User curUser = (User) session.getAttribute("curUser");
		if (curUser == null) {
			return "redirect:/login";
		}
		/******** 1、分页设置 ***********/
		Pager pager = new Pager();
		int currentPage = (request.getParameter("p") == null || request.getParameter("p") == "") ? 1
				: Integer.valueOf(request.getParameter("p"));
		int totalPage = 0;
		long totalSize = 0;
		int pageSize = 15;

		Role role = curUser.getRole();

		List<ReportLog> reportLogList = new ArrayList<ReportLog>();

		if (role.getCode().equals("ADMIN")) {
			totalSize = reportLogService.count("0", "1");
		} else if (role.getCode().equals("SUBADMIN")) {
			totalSize = reportLogService.countByFromUser(curUser, "0", "1");
		} else {
			totalSize = reportLogService.countByToUser(curUser, "0", "1");
		}
		int mod = (int) (totalSize % pageSize);
		if (mod == 0) {
			totalPage = (int) (totalSize / pageSize);
		} else {
			totalPage = (int) (totalSize / pageSize + 1);
		}
		pager.setCurrentPage(String.valueOf(currentPage));
		pager.setPageSize(String.valueOf(pageSize));
		pager.setTotalSize(totalSize);

		if (role.getCode().equals("ADMIN")) {
			reportLogList = reportLogService.query("0", pager, "1");

		} else if (role.getCode().equals("SUBADMIN")) {
			reportLogList = reportLogService.queryByFromUser(curUser, "0", pager, "1");
		} else {
			reportLogList = reportLogService.queryByToUser(curUser, "0", pager, "1");
		}

		model.addAttribute("pager", pager);
		model.addAttribute("p", currentPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("reportLogList", reportLogList);
		return "/report/list_deleted";
	}
}
