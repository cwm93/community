package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliang
 * @description 报表备注
 */
public class ReportRemark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private Report report;// 报表ID
	private String year;// 年
	private String month;// 月
	private String week;// 周
	private String remarkContent;// 备注内容

	private long userId;// 提交人id
	private String userName;// 提交人姓名
	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更新时间

	public ReportRemark() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonIgnore
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getRemarkContent() {
		return remarkContent;
	}

	public void setRemarkContent(String remarkContent) {
		this.remarkContent = remarkContent;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "ReportRemark [id=" + id + ", report=" + report + ", year=" + year + ", month=" + month + ", week="
				+ week + ", remarkContent=" + remarkContent + ", userId=" + userId + ", userName=" + userName
				+ ", insertTime=" + insertTime + ", updateTime=" + updateTime + "]";
	}


}
