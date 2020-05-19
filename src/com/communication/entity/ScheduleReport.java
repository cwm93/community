/**
 * 
 */
package com.communication.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liliang
 *
 */
public class ScheduleReport implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;//计划名称（）
	private String code;//计划编码
	private Report report;//对应的报表
	
	private Set<User> sendedUsers = new HashSet<User>(0);//被分配到的人员
	
	private long createdUserId;//创建者
	
	private String type;//按日发（一次性）；按月；按周；
	private Date sendDate;//哪日发送
	private String sendWeek;//周几发送
	private String sendDay;//每月几号发送
	private String sendTime;//发送时间
	
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	
	private String cronExpression;//执行时间表达式
	
	private String description;//计划描述
	
	private String status;//任务状态：0：未开始；1：进行中；2：已完成
	
	private Date updateTime;//最后一次更新时间
	private Date createdTime;//创建时间
	
	public ScheduleReport() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Set<User> getSendedUsers() {
		return sendedUsers;
	}

	public void setSendedUsers(Set<User> sendedUsers) {
		this.sendedUsers = sendedUsers;
	}

	public long getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(long createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendWeek() {
		return sendWeek;
	}

	public void setSendWeek(String sendWeek) {
		this.sendWeek = sendWeek;
	}

	public String getSendDay() {
		return sendDay;
	}

	public void setSendDay(String sendDay) {
		this.sendDay = sendDay;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "ScheduleReport [id=" + id + ", name=" + name + ", report=" + report 
				+ ", sendedUsers=" + sendedUsers
				+ ", createdUserId=" + createdUserId + ", type=" + type + ", sendDate=" + sendDate + ", sendWeek="
				+ sendWeek + ", sendDay=" + sendDay + ", sendTime=" + sendTime + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", cronExpression=" + cronExpression + ", description=" + description
				+ ", status=" + status + ", updateTime=" + updateTime + ", createdTime=" + createdTime + "]";
	}
	
}
