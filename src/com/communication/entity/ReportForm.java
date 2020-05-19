package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liliang
 *
 */
public class ReportForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String CHINA_TELECOM= "1";
    public static final String CHINA_UNICOM_ = "2";
    public static final String CHINA_MOBILE= "3";

    private long formId;
    private long reportId;
    private String version;
    private String formName;
    private String preDesc;
    private String endDesc;
    private String comment;
    private long userId;
    private Date createTime;
    private Date updateTime;
    
    
	public ReportForm() {
		
	}


	public long getFormId() {
		return formId;
	}


	public void setFormId(long formId) {
		this.formId = formId;
	}


	public long getReportId() {
		return reportId;
	}


	public void setReportId(long reportId) {
		this.reportId = reportId;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getFormName() {
		return formName;
	}


	public void setFormName(String formName) {
		this.formName = formName;
	}


	public String getPreDesc() {
		return preDesc;
	}


	public void setPreDesc(String preDesc) {
		this.preDesc = preDesc;
	}


	public String getEndDesc() {
		return endDesc;
	}


	public void setEndDesc(String endDesc) {
		this.endDesc = endDesc;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
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
		return "ReportForm [formId=" + formId + ", reportId=" + reportId + ", version=" + version + ", formName="
				+ formName + ", preDesc=" + preDesc + ", endDesc=" + endDesc + ", comment=" + comment + ", userId="
				+ userId + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
