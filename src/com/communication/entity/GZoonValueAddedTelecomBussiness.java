package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

public class GZoonValueAddedTelecomBussiness implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	// 总计
	private Float field_11;// 营业收入（亿）
	private Float field_12;// 同比
	private Float field_13;// 电信业务收入（亿）
	private Float field_14;// 同比

	private Integer year;// 年份
	private Integer month;// 月份

	private Long createUserId;
	private Date insertTime;
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getField_11() {
		return field_11;
	}

	public void setField_11(Float field_11) {
		this.field_11 = field_11;
	}

	public Float getField_12() {
		return field_12;
	}

	public void setField_12(Float field_12) {
		this.field_12 = field_12;
	}

	public Float getField_13() {
		return field_13;
	}

	public void setField_13(Float field_13) {
		this.field_13 = field_13;
	}

	public Float getField_14() {
		return field_14;
	}

	public void setField_14(Float field_14) {
		this.field_14 = field_14;
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

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
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
