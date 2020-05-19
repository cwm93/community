package com.communication.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.communication.entity.AdministrationReport;
import com.communication.entity.Data;
import com.communication.entity.Report;
import com.communication.entity.User;
import com.communication.interceptor.RequiresPermission;
import com.communication.service.AdministrationReportService;
import com.communication.service.ReportService;
import com.communication.service.UserService;
import com.communication.util.Constants;


@Controller 
@RequestMapping("/settings")
public class SettingController {
	
	private static final Logger logger = LoggerFactory.getLogger(SettingController.class);
	
	@Resource 
	private UserService userService;
	@Resource
	private ReportService reportService;
	@Autowired
	private AdministrationReportService administrationReportService;
	
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/selectUsers",method = RequestMethod.POST)
	@ResponseBody  
	public Data selectUsers(@RequestParam(value="user_id", required = false) Long id,@RequestParam(value="select_user_id", required = false) Long[] select_user_id){
		logger.info("分配用户");
		Data data = Data.failure("分配用户失败");
		try{
			User user = userService.find(id);
			Set<User> assignedUsers = new HashSet<User>(0);
			if(select_user_id!=null&&select_user_id.length>0) {
				for(long selected_user_id:select_user_id){
					User selectedUser = userService.find(selected_user_id);
					assignedUsers.add(selectedUser);
				}
			}
			user.setAssignedUsers(assignedUsers);
		    userService.save(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			data = Data.success("分配用户成功");
		}
	
		return data;
	}

	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/selectReportForm",method = RequestMethod.POST)
	@ResponseBody  
	public Data selectReportForm(@RequestParam(value="user_id", required = false) Long id,@RequestParam(value="select_report_id", required = false) Long[] select_report_id){
		Data data = Data.failure("分配报表模板失败");
		try{
			User user = userService.find(id);
			Set<Report> assignedReports = new HashSet<Report>(0);
			if(select_report_id!=null&&select_report_id.length>0) {
				for(long selected_report_id:select_report_id){
					Report report = reportService.find(selected_report_id);
					assignedReports.add(report);
				}
			}
			user.setAssignedReports(assignedReports);
		    userService.save(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			data = Data.success("分配报表模板成功");
		}
	
		return data;
	}
	
	
	@RequiresPermission(values={Constants.ROLE_ADMIN})
	@RequestMapping(value="/selectAdministrationReport",method = RequestMethod.POST)
	@ResponseBody  
	public Data selectAdministrationReport(@RequestParam(value="user_id", required = false) Long id,@RequestParam(value="select_administration_report_id", required = false) Long[] select_administration_report_ids){
		Data data = Data.failure("分配管理处报表失败");
		try{
			User user = userService.find(id);
			Set<AdministrationReport> assignedAdministrationReports = new HashSet<AdministrationReport>(0);
			if(select_administration_report_ids!=null&&select_administration_report_ids.length>0) {
				for(long select_administration_report_id:select_administration_report_ids){
					AdministrationReport administrationReport = administrationReportService.find(select_administration_report_id);
					assignedAdministrationReports.add(administrationReport);
				}
			}
			user.setAssignedAdministrationReports(assignedAdministrationReports);
		    userService.save(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			data = Data.success("分配管理处报表成功");
		}
	
		return data;
	}
}
