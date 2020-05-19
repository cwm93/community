package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author liliang
 *  修改时间：2017-8-17上午；新增字段
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ReportLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private long jobTimeStamp;// 任务的时间戳
	private User fromUser;// 发表的用户
	private User toUser;// 收到表的用户
	private String title;// 报表标题
	private Report report;// 对应的报表模板信息
	private Integer writeYear;// 年
	private Integer writeMonth;// 月
	private Integer writeWeek;// 周
	private String status;// 状态：0:未填写；1：已提交;2:暂存状态
	private Date temporarySaveDate;//暂存时间---2017.8.17新增
	private String auditStatus;// 审核状态；0:未审核；1:审核通过；2:审核未通过
	private String auditReason;//审核理由---2017.8.17新增
	private Long auditUserId;// 审核人UID
	private Date auditTime;// 审核时间
	private String isDeleted;//是否被删除；0:未删除；1:已删除；
	private Date deletedTime;//删除时间
	private Long deletedUserId;//删除者ID
	private Date createTime;// 创建日期
	private Date submitTime;// 提交时间

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonIgnore
	public long getJobTimeStamp() {
		return jobTimeStamp;
	}

	public void setJobTimeStamp(long jobTimeStamp) {
		this.jobTimeStamp = jobTimeStamp;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@JsonIgnore
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Integer getWriteYear() {
		return writeYear;
	}

	public void setWriteYear(Integer writeYear) {
		this.writeYear = writeYear;
	}

	public Integer getWriteMonth() {
		return writeMonth;
	}

	public void setWriteMonth(Integer writeMonth) {
		this.writeMonth = writeMonth;
	}

	public Integer getWriteWeek() {
		return writeWeek;
	}

	public void setWriteWeek(Integer writeWeek) {
		this.writeWeek = writeWeek;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@JsonIgnore
	public Date getCreateTime() {
		return createTime;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Long getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(Long auditUserId) {
		this.auditUserId = auditUserId;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getDeletedTime() {
		return deletedTime;
	}

	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
	}

	public Long getDeletedUserId() {
		return deletedUserId;
	}

	public void setDeletedUserId(Long deletedUserId) {
		this.deletedUserId = deletedUserId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
    //新增
	public Date getTemporarySaveDate() {
		return temporarySaveDate;
	}

	public void setTemporarySaveDate(Date temporarySaveDate) {
		this.temporarySaveDate = temporarySaveDate;
	}

	public String getAuditReason() {
		return auditReason;
	}

	public void setAuditReason(String auditReason) {
		this.auditReason = auditReason;
	}

	@Override
	public String toString() {
		return "ReportLog [id=" + id + ", jobTimeStamp=" + jobTimeStamp + ", fromUser=" + fromUser + ", toUser="
				+ toUser + ", title=" + title + ", report=" + report + ", writeYear=" + writeYear + ", writeMonth="
				+ writeMonth + ", writeWeek=" + writeWeek + ", status=" + status + ", auditStatus=" + auditStatus
				+ ", auditUserId=" + auditUserId + ", auditTime=" + auditTime + ", createTime=" + createTime
				+ ", submitTime=" + submitTime + "]";
	}

}
