package com.communication.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliang 码号分类批次管理
 */
public class GCodeClassificationBatch implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer year;
	private Integer month;
	private Set<GCodeClassification> codeClassificationList = new HashSet<GCodeClassification>();
	private Long userId;
	private Date insertTime;
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@JsonIgnore
	public Set<GCodeClassification> getCodeClassificationList() {
		return codeClassificationList;
	}

	public void setCodeClassificationList(Set<GCodeClassification> codeClassificationList) {
		this.codeClassificationList = codeClassificationList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
