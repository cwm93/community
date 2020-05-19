package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliang
 * 码号系统数据相关
 */
public class GCodeClassification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;//id
	private GCodeClassificationBatch batch;//批次
	private String codeNumber;//短号码
	private String classification;//码号分类
	private String startTime;//启用时间
	private String usedCompany;//批准使用单位
	private String auditedTime;//批准使用日期
	private String endTime;//码号截止日期
	private String type;//分类
	private Date insertTime;//插入时间
	private Date updateTime;//更新时间

	public GCodeClassification() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonIgnore
	public GCodeClassificationBatch getBatch() {
		return batch;
	}

	public void setBatch(GCodeClassificationBatch batch) {
		this.batch = batch;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getUsedCompany() {
		return usedCompany;
	}

	public void setUsedCompany(String usedCompany) {
		this.usedCompany = usedCompany;
	}

	public String getAuditedTime() {
		return auditedTime;
	}

	public void setAuditedTime(String auditedTime) {
		this.auditedTime = auditedTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
}
