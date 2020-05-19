/**
 * 
 */
package com.communication.executor.processor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.communication.entity.ScheduleReport;
import com.communication.service.ScheduleReportService;

/**
 * @author Administrator
 *
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger logger = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);
	@Resource
	private ScheduleReportService scheduleReportService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (event.getApplicationContext().getParent() == null) {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

			List<ScheduleReport> scheduleReports = scheduleReportService.queryNotCompleted();
			if (scheduleReports != null) {
				for (ScheduleReport scheduleReport : scheduleReports) {
					try {
						
						if (scheduleReport.getType().equals("1")) {
							/********单次发送的，为防止异常，判断是否满足启动条件************/
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							String date = scheduleReport.getSendDate().toString().substring(0, 11);
							String tempTime = date + scheduleReport.getSendTime();
							Date dateDetail = sdf.parse(tempTime);

							Date now = new Date();
							if (now.after(dateDetail)) {
								/*****是否通知管理员查看？*******/
								logger.info(scheduleReport.getCode()+": job was losted");
								continue;//单次发送日期失效，跳过
							}
						}
					    scheduleReport.getSendedUsers();
						scheduleReportService.modifyschedulerReportTimeById(scheduleReport.getId());
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("scheduleReportJobCode:" + scheduleReport.getCode() + ";Error:it seems the this job was inited failed");
					}
				}
			} else {
				logger.info("system seems no jobs needed to start");
			}

		}

	}
}
