package com.communication.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class GTelecomValueAddedBatch implements Serializable {

	private static final long serialVersionUID = 8103077654237323139L;

	private Integer id;
	
	private Integer year;
	private Integer month;
	private Set<GTelecomValueAdded> telecomValueAddedList = new HashSet<GTelecomValueAdded>(0);
	private Long uid;
	private Date insertTime;

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
	
	public Set<GTelecomValueAdded> getTelecomValueAddedList() {
		return telecomValueAddedList;
	}

	public void setTelecomValueAddedList(Set<GTelecomValueAdded> telecomValueAddedList) {
		this.telecomValueAddedList = telecomValueAddedList;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	@Override
	public String toString() {
		return "GTelecomValueAddedBatch [id=" + id + ", year=" + year + ", month=" + month + ", telecomValueAddedList="
				+ telecomValueAddedList + ", uid=" + uid + ", insertTime=" + insertTime + "]";
	}

}
