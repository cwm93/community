package com.communication.quartz;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.communication.entity.Report;
import com.communication.entity.ReportLog;
import com.communication.entity.ScheduleReport;
import com.communication.entity.SmsLogEntity;
import com.communication.entity.User;
import com.communication.service.ReportLogService;
import com.communication.service.ScheduleReportService;
import com.communication.service.SmsLogService;
import com.communication.service.SmsService;
import com.communication.service.UserService;
import com.communication.util.Tool;
import com.communication.util.Base;
import com.communication.util.HttpClientUtil;
import com.communication.util.SMSUtil;

public class ScheduleReportJob extends Base implements Job {

	private static final Logger logger = Logger.getLogger(ScheduleReportJob.class);

	@Autowired
	private UserService userService;
	@Autowired
	private ScheduleReportService scheduleReportService;
	@Autowired
	private ReportLogService reportLogService;
	@Autowired
	private SmsLogService smsLogService;
	@Autowired
	private SmsService smsService;
	
	private int returnCode = 0;
	private SmsLogEntity smsLogEntity = null;
	

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		boolean flag = false;

		ScheduleReport scheduleReport = (ScheduleReport) context.getMergedJobDataMap().get("scheduleReport");
		if (empty(scheduleReport)) {
			JobDetail jobDetail = context.getJobDetail();
			logger.info(jobDetail.getKey() + " losted");
			return;
		}

		Date date = new Date();
		Calendar calender = Calendar.getInstance();
		long jobTimeStamp = calender.getTimeInMillis();

		if (scheduleReport.getType().equals("2") || scheduleReport.getType().equals("3")) {
			if (date.before(scheduleReport.getStartTime())) {
				/**** 置任务为未开始 ****/
				scheduleReport.setStatus("0");
				scheduleReportService.update(scheduleReport);
				logger.info("置任务为未开始");
				flag = false;
			}else if (date.after(scheduleReport.getStartTime()) && date.before(Tool.delayDay(scheduleReport.getEndTime(), 1))) {
				/**** 置任务为进行中 ****/
				scheduleReport.setStatus("1");
				scheduleReportService.update(scheduleReport);
				logger.info("置任务为进行中");
				flag = true;
			}else if(date.after(Tool.delayDay(scheduleReport.getEndTime(), 1))){
				scheduleReport.setStatus("2");
				//更新执行状态
				scheduleReportService.update(scheduleReport);
				logger.info("置任务为结束");
				flag = false;
			}
		} else {
			    //单次发送的
				scheduleReport.setStatus("2");
				scheduleReportService.update(scheduleReport);
				logger.info("置任务为结束");
				flag = true;
		}
		
		
		if (flag) {
			try {
				User fromUser = userService.find(scheduleReport.getCreatedUserId());

				Set<User> sendedUsers = scheduleReport.getSendedUsers();
				
				Report report = scheduleReport.getReport();
				StringBuffer sb = new StringBuffer();
				if (scheduleReport.getType().equals("2")) {
					//周报表 本周发上一周的内容
					calender.add(3, -1);
					sb.append(report.getTitle() + "_" + calender.get(Calendar.YEAR) + "年第" + calender.get(Calendar.WEEK_OF_YEAR) + "周");
				} else{
					// 月报表 本月发上一月的内容
					if (report.getId() == 4 || report.getId() == 5) {
						calender.add(2, -2);
					} else {
						calender.add(2, -1);
					}
					sb.append(report.getTitle() + "_" + calender.get(Calendar.YEAR) + "年" + (calender.get(Calendar.MONTH) + 1) + "月");
				}
				if (sendedUsers != null && sendedUsers.size() > 0) {
					StringBuffer sbMobilis = new StringBuffer();
					for (User toUser : sendedUsers) {
						/***1、记录发送报表的信息*******/
						ReportLog reportLog = new ReportLog();
						reportLog.setJobTimeStamp(jobTimeStamp);
						reportLog.setFromUser(fromUser);
						reportLog.setToUser(toUser);
						reportLog.setTitle(sb.toString());
						reportLog.setWriteYear(calender.get(Calendar.YEAR));
						reportLog.setWriteMonth((calender.get(Calendar.MONTH) + 1));
						reportLog.setWriteWeek(calender.get(Calendar.WEEK_OF_YEAR));
						reportLog.setReport(report);
						reportLog.setIsDeleted("0");//bug 修改于2017-04-20
						reportLog.setStatus("0");
						reportLog.setAuditStatus("0");
						reportLog.setCreateTime(new Date());
						reportLogService.save(reportLog);
						
						sbMobilis.append(toUser.getMobile());
						sbMobilis.append(",");
					}
					//发送短信通知用户
					if(smsService.isOpen(3)) {
						sbMobilis.append("13585511438");
						String mobiles = sbMobilis.toString();
						String content = "您有一份新的表格-【"+sb.toString()+"】需要填写，请登录业务系统查看详情。【上海市通信管理局】";
						returnCode = SMSUtil.sendSms(mobiles.substring(0,mobiles.length() - 1), content);
						smsLogEntity  = new SmsLogEntity();
						if(returnCode>0) {
							smsLogEntity.setStatus("1");
							smsLogEntity.setPieces(returnCode);
							smsLogEntity.setContent(sb.toString()+"发送成功!");
						}else {
							HttpClientUtil httpClient = HttpClientUtil.getInstance();
							smsLogEntity.setStatus("-1");
							smsLogEntity.setPieces(0);
							smsLogEntity.setContent(sb.toString()+"发送失败!失败原因:"+httpClient.getErrorMsg(returnCode));
						}
						smsLogEntity.setInsertTime(new Date());
						smsLogService.save(smsLogEntity);
					}
					//释放资源
					sb = null;
					smsLogEntity = null;
				}
				logger.info(new Date() + "执行了一次计划发表");
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(new Date() + "执行任务失败");
			}
			
		}
		
		//是否移除该任务
		if(scheduleReport.getType().equals("2")){
			//执行完毕，移除该任务
			scheduleReportService.removeschedulerReport(scheduleReport);
		}

	}
	
}
