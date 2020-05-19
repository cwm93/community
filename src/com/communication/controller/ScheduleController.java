package com.communication.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.communication.entity.Data;
import com.communication.entity.Report;
import com.communication.entity.Role;
import com.communication.entity.ScheduleReport;
import com.communication.entity.User;
import com.communication.service.ReportService;
import com.communication.service.ScheduleReportService;
import com.communication.service.UserService;
import com.communication.util.Tool;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);

	@Resource
	private ReportService reportService;
	@Resource
	private UserService userService;
	@Resource
	private ScheduleReportService scheduleReportService;

	@RequestMapping(value = { "/", "" })
	public String index(Model model, HttpSession session) {
		logger.info("计划列表");
		User currentUser = (User) session.getAttribute("curUser");

		Role role = currentUser.getRole();
		List<ScheduleReport> scheduleReportList = null;
		if (role.getCode().equals("ADMIN")) {
			scheduleReportList = scheduleReportService.findAll();
		} else {
			scheduleReportList = scheduleReportService.findByCreateUserId(currentUser.getId());
		}

		model.addAttribute("scheduleReportList", scheduleReportList);
		return "/admin/schedule_list";
	}

	@RequestMapping(value = "/completed")
	public String compeled(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		logger.info("计划列表");
		User currentUser = (User) session.getAttribute("curUser");

		Role role = currentUser.getRole();
		List<ScheduleReport> scheduleReportList = null;
		if (role.getCode().equals("ADMIN")) {
			scheduleReportList = scheduleReportService.findByStatus("2");
		} else if (role.getCode().equals("SUBADMIN")) {
			scheduleReportList = scheduleReportService.findByStatus(currentUser.getId(), "2");
		} else {
			Data data = Data.failure("您没有操作权限", "/index", "返回首页");
			redirectAttributes.addFlashAttribute("data", data);
			return "redirect:/message";
		}

		model.addAttribute("scheduleReportList", scheduleReportList);
		return "/admin/schedule_list";
	}

	@RequestMapping(value = "/unstart")
	public String unstart(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		logger.info("计划列表");
		User currentUser = (User) session.getAttribute("curUser");

		Role role = currentUser.getRole();
		List<ScheduleReport> scheduleReportList = null;
		if (role.getCode().equals("ADMIN")) {
			scheduleReportList = scheduleReportService.findByStatus("0");
		} else if (role.getCode().equals("SUBADMIN")) {
			scheduleReportList = scheduleReportService.findByStatus(currentUser.getId(), "0");
		} else {
			Data data = Data.failure("您没有操作权限", "/index", "返回首页");
			redirectAttributes.addFlashAttribute("data", data);
			return "redirect:/message";
		}

		model.addAttribute("scheduleReportList", scheduleReportList);
		return "/admin/schedule_list";
	}

	@RequestMapping(value = "/uncompleted")
	public String uncompleted(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		logger.info("计划列表");
		User currentUser = (User) session.getAttribute("curUser");

		Role role = currentUser.getRole();
		List<ScheduleReport> scheduleReportList = null;
		if (role.getCode().equals("ADMIN")) {
			scheduleReportList = scheduleReportService.findByStatus("1");
		} else if (role.getCode().equals("SUBADMIN")) {
			scheduleReportList = scheduleReportService.findByStatus(currentUser.getId(), "1");
		} else {
			Data data = Data.failure("您没有操作权限", "/index", "返回首页");
			redirectAttributes.addFlashAttribute("data", data);
			return "redirect:/message";
		}

		model.addAttribute("scheduleReportList", scheduleReportList);
		return "/admin/schedule_list";
	}

	@RequestMapping("/count")
	@ResponseBody
	public Map<String, Object> count(HttpServletRequest request, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		long countAll = 0L;
		long countCompleted = 0L;
		long countUncompleted = 0L;
		long countUnstarted = 0L;
		String isUserLogin = "0";

		User currentUser = (User) session.getAttribute("curUser");
		if (currentUser == null) {
			isUserLogin = "0";
		} else {
			isUserLogin = "1";
			Role role = currentUser.getRole();
			/***** 超级管理员 *******/
			if (role.getCode().equals("ADMIN")) {
				countAll = scheduleReportService.count(0, "");
				countCompleted = scheduleReportService.count(0, "2");
				countUncompleted = scheduleReportService.count(0, "1");
				countUnstarted = scheduleReportService.count(0, "0");
			}
			/***** 二级管理员 *******/
			if (role.getCode().equals("SUBADMIN")) {
				countAll = scheduleReportService.count(currentUser.getId(), "");
				countCompleted = scheduleReportService.count(currentUser.getId(), "2");
				countUncompleted = scheduleReportService.count(currentUser.getId(), "1");
				countUnstarted = scheduleReportService.count(currentUser.getId(), "0");
			}
			// long countAll = scheduleReportService.count(id, status);

		}
		/********** 要返回数据 ************/
		map.put("count_all", countAll);
		map.put("count_completed", countCompleted);
		map.put("count_uncompleted", countUncompleted);
		map.put("count_unstarted", countUnstarted);
		map.put("check_user_login", isUserLogin);
		return map;
	}

	@RequestMapping("/add")
	public String add(Model model, HttpServletRequest request) {
		logger.info("添加计划列表");

		Long curUid = (Long) request.getSession().getAttribute("curUserId");
		User user = userService.find(curUid);

		Set<Report> reports = user.getAssignedReports();
		Set<User> users = user.getAssignedUsers();

		model.addAttribute("reports", reports);
		model.addAttribute("users", users);
		return "/admin/schedule_form";
	}

	@RequestMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") long id, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		logger.info("修改计划列表");
		Long curUid = (Long) request.getSession().getAttribute("curUserId");
		ScheduleReport scheduleReport = scheduleReportService.find(id);
		/********* 1、判断是否执行完毕，若执行完毕，则不可更改 **********/
		if (scheduleReport.getStatus().equals("2")) {
			Data data = Data.failure("对不起，该计划已经执行完毕，不能被修改！", "/schedule", "返回计划列表");
			redirectAttributes.addFlashAttribute("data", data);
			return "redirect:/message";
		}
		/********* 2、判断用户是否有权限修改 **********/
		if (scheduleReport.getCreatedUserId() != curUid) {
			Data data = Data.failure("您没有操作权限", "/schedule", "返回计划列表");
			redirectAttributes.addFlashAttribute("data", data);
			return "redirect:/message";
		}
		
		/********* 3、进入修改页面 **********/

		User user = userService.find(curUid);

		Set<Report> reports = user.getAssignedReports();
		Set<User> users = user.getAssignedUsers();

		model.addAttribute("scheduleReport", scheduleReport);
		model.addAttribute("reports", reports);
		model.addAttribute("users", users);
		return "/admin/schedule_form_edit";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Data data = Data.failure("保存操作失败", "/schedule", "返回计划列表");

		Long createdUserId = (Long) request.getSession().getAttribute("curUserId");
		String name = request.getParameter("name");
		String reportId = request.getParameter("reportId");
		String sendedUserIds[] = request.getParameterValues("sendedUsers");
		String sendType = request.getParameter("type");
		String sendDate = request.getParameter("sendDate");
		String sendWeek = request.getParameter("sendWeek");
		String startDate2 = request.getParameter("startDate2");
		String endDate2 = request.getParameter("endDate2");
		String sendDay = request.getParameter("sendDay");
		String startDate3 = request.getParameter("startDate3");
		String endDate3 = request.getParameter("endDate3");
		String sendTime = request.getParameter("sendTime");
		String sendTimes[] = sendTime.split(":");
		String description = request.getParameter("description");
		String strscheduleReportId = request.getParameter("scheduleReportId");

		long scheduleReportId = 0L;
		if (strscheduleReportId != null && strscheduleReportId != "") {
			scheduleReportId = Long.valueOf(strscheduleReportId);
		}
		ScheduleReport scheduleReport = new ScheduleReport();
		if (scheduleReportId > 0) {
			scheduleReport = scheduleReportService.find(scheduleReportId);
		}
		String cronExpression = null;

		Report report = reportService.find(Long.valueOf(reportId));

		Set<User> sendedUsers = new HashSet<User>();
		if (sendedUserIds != null && sendedUserIds.length > 0) {
			for (String id : sendedUserIds) {
				User user = userService.find(Long.valueOf(id));
				sendedUsers.add(user);
			}
		}
		scheduleReport.setName(name);
		scheduleReport.setReport(report);
		scheduleReport.setSendedUsers(sendedUsers);
		scheduleReport.setType(sendType);
		scheduleReport.setCreatedUserId(createdUserId);

		Calendar calendar = Calendar.getInstance();
		if (sendType.equals("1")) {
			scheduleReport.setSendDate(Tool.strToDate(sendDate, "yyyy-MM-dd"));
			calendar.setTime(Tool.strToDate(sendDate, "yyyy-MM-dd"));
			cronExpression = "0 " + sendTimes[1] + " " + sendTimes[0] + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
					+ (calendar.get(Calendar.MONTH) + 1) + " ? " + calendar.get(Calendar.YEAR);
			logger.info(cronExpression);
		} else if (sendType.equals("2")) {
			scheduleReport.setSendWeek(sendWeek);
			scheduleReport.setStartTime(Tool.strToDate(startDate2, "yyyy-MM-dd"));
			scheduleReport.setEndTime(Tool.strToDate(endDate2, "yyyy-MM-dd"));
			cronExpression = "0 " + sendTimes[1] + " " + sendTimes[0] + " ? * " + Tool.getWeek(sendWeek);
			logger.info(cronExpression);
		} else if (sendType.equals("3")) {
			scheduleReport.setSendDay(sendDay);
			scheduleReport.setStartTime(Tool.strToDate(startDate3, "yyyy-MM-dd"));
			scheduleReport.setEndTime(Tool.strToDate(endDate3, "yyyy-MM-dd"));
			cronExpression = "0 " + sendTimes[1] + " " + sendTimes[0] + " " + sendDay + " * ?";
			logger.info(cronExpression);
		}

		scheduleReport.setCronExpression(cronExpression);
		scheduleReport.setSendTime(sendTime);
		scheduleReport.setDescription(description);
		scheduleReport.setStatus("0");
		scheduleReport.setUpdateTime(new Date());

		if (scheduleReportId > 0) {

			if (scheduleReport.getCreatedUserId() == createdUserId) {
				try {

					scheduleReportService.save(scheduleReport);
					scheduleReportService.modifyschedulerReportTimeById(scheduleReportId);
					data = Data.success("修改计划成功", "/schedule", "返回计划列表");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				data = Data.success("修改计划失败：你当前无此权限", "/schedule", "返回计划列表");
			}
		} else {
			/*** 生成任务编码 ***/
			scheduleReport.setCode(Tool.getUUID());
			scheduleReport.setCreatedTime(new Date());

			try {
				/*** 保存任务信息 ***/
				scheduleReportService.save(scheduleReport);
				/*** 启动任务 ***/
				scheduleReportService.startSchedulerReportById(scheduleReport.getId());

				data = Data.success("新建计划成功", "/schedule", "返回计划列表");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		redirectAttributes.addFlashAttribute("data", data);
		return "redirect:/message";

	}
}
