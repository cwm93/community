package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private String title;
	private String formCode;
	private ReportKind reportKind;
	private ReportType reportType;
	private String comment;
	private Date createTime;
	private Date updateTime;

	public Report() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public ReportKind getReportKind() {
		return reportKind;
	}

	public void setReportKind(ReportKind reportKind) {
		this.reportKind = reportKind;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", title=" + title + ", formCode=" + formCode + ", reportKind=" + reportKind
				+ ", reportType=" + reportType + ", comment=" + comment + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

}
