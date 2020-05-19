package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.ScheduleReportDao;
import com.communication.entity.ScheduleReport;
import com.communication.quartz.QuartzManager;
import com.communication.quartz.ScheduleReportJob;
import com.communication.util.Constants;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class ScheduleReportService extends BaseService<ScheduleReport> {

	@Resource
	private void setDao(ScheduleReportDao dao) {
		super.setDao(dao);
	}

	public List<ScheduleReport> findByCreateUserId(long id) {
		List<ScheduleReport> scheduleReports = getDao().findAll(Order.desc("id"), Property.eq("createdUserId", id));
		if (scheduleReports != null && scheduleReports.size() > 0) {
			return scheduleReports;
		}
		return null;
	}

	public List<ScheduleReport> findByStatus(String status) {
		List<ScheduleReport> scheduleReports = getDao().findAll(Order.desc("id"), Property.eq("status", status));
		if (scheduleReports != null && scheduleReports.size() > 0) {
			return scheduleReports;
		}
		return null;
	}
	
	public List<ScheduleReport> findByStatus(long id,String status) {
		List<ScheduleReport> scheduleReports = getDao().findAll(Order.desc("id"), Property.eq("createdUserId", id), Property.eq("status", status));
		if (scheduleReports != null && scheduleReports.size() > 0) {
			return scheduleReports;
		}
		return null;
	}
	/**
	 * @Description: 统计计划数
	 * @param id 插入者UID
	 * @param status  计划的状态
	 */	
	public long count(long id,String status){
		long count =0L;
		if(id == 0){
			if(status!=""&&status!=null){
				count = getDao().countByProperty("id",Property.eq("status", status));
			}else{
				count = getDao().countByProperty("id");
			}
		}else{
			if(status!=""&&status!=null){
				count =  getDao().countByProperty("id",Property.eq("createdUserId", id),Property.eq("status", status));
			}else{
				count =  getDao().countByProperty("id",Property.eq("createdUserId", id));
			}
		}
		return count;
	}
	
	
	
	/**
	 * 启动一个发布报表的任务
	 *
	 **/
	public void startSchedulerReportById(long id) {

		ScheduleReport scheduleReport = getDao().find(id);

		if (scheduleReport.getType().equals("1")) {
			QuartzManager.addJob(scheduleReport.getCode(), Constants.DAY_PLAN, scheduleReport.getCode(),
					Constants.DAY_PLAN, ScheduleReportJob.class, scheduleReport.getCronExpression(), scheduleReport);
		} else if (scheduleReport.getType().equals("2")) {
			QuartzManager.addJob(scheduleReport.getCode(), Constants.WEEK_PLAN, scheduleReport.getCode(),
					Constants.WEEK_PLAN, ScheduleReportJob.class, scheduleReport.getCronExpression(), scheduleReport);
		} else {
			QuartzManager.addJob(scheduleReport.getCode(), Constants.MONTH_PLAN, scheduleReport.getCode(),
					Constants.MONTH_PLAN, ScheduleReportJob.class, scheduleReport.getCronExpression(), scheduleReport);
		}
	}

	/**
	 * 修改一个发布报表的任务的相关信息
	 *
	 **/
	public void modifyschedulerReportTimeById(long id) {
		ScheduleReport scheduleReport = getDao().find(id);
		if (scheduleReport.getType().equals("1")) {
			QuartzManager.modifyJobTime(scheduleReport.getCode(), Constants.DAY_PLAN, scheduleReport.getCode(),
					Constants.DAY_PLAN, scheduleReport.getCronExpression(), scheduleReport);
		} else if (scheduleReport.getType().equals("2")) {
			QuartzManager.modifyJobTime(scheduleReport.getCode(), Constants.WEEK_PLAN, scheduleReport.getCode(),
					Constants.WEEK_PLAN, scheduleReport.getCronExpression(), scheduleReport);
		} else {
			QuartzManager.modifyJobTime(scheduleReport.getCode(), Constants.MONTH_PLAN, scheduleReport.getCode(),
					Constants.MONTH_PLAN, scheduleReport.getCronExpression(), scheduleReport);
		}

	}
	/**
	 * 移除一个发布报表的任务的相关信息
	 * @param id
	 **/
	public void removeschedulerReport(long id) {
		ScheduleReport scheduleReport = getDao().find(id);
		if (scheduleReport.getType().equals("3")) {
			QuartzManager.removeJob(scheduleReport.getCode(), Constants.MONTH_PLAN, scheduleReport.getCode(),Constants.MONTH_PLAN);
		}else if(scheduleReport.getType().equals("2")){
			QuartzManager.removeJob(scheduleReport.getCode(), Constants.WEEK_PLAN, scheduleReport.getCode(),Constants.WEEK_PLAN);
		}else{
			QuartzManager.removeJob(scheduleReport.getCode(), Constants.DAY_PLAN, scheduleReport.getCode(),Constants.DAY_PLAN);
		}

	}
	
	/**
	 * 移除一个发布报表的任务的相关信息
	 * @param scheduleReport
	 **/
	public void removeschedulerReport(ScheduleReport scheduleReport) {
		
		if(scheduleReport ==null){
			return;
		}
		
		if (scheduleReport.getType().equals("3")) {
			QuartzManager.removeJob(scheduleReport.getCode(), Constants.MONTH_PLAN, scheduleReport.getCode(),Constants.MONTH_PLAN);
		}else if(scheduleReport.getType().equals("2")){
			QuartzManager.removeJob(scheduleReport.getCode(), Constants.WEEK_PLAN, scheduleReport.getCode(),Constants.WEEK_PLAN);
		}else{
			QuartzManager.removeJob(scheduleReport.getCode(), Constants.DAY_PLAN, scheduleReport.getCode(),Constants.DAY_PLAN);
		}

	}

	public List<ScheduleReport> queryNotCompleted() {
		List<ScheduleReport> scheduleReports = getDao().findAll(Order.desc("id"), Property.ne("status", "2"));
		if (scheduleReports != null && scheduleReports.size() > 0) {
			return scheduleReports;
		}
		return null;
	}

}
