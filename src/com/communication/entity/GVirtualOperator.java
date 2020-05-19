package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 虚拟运营商
 */
public class GVirtualOperator implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	// 全国
	private Float field_11;// 用户总数（万）
	private Float field_12;// 本月新增数（万）
	private Float field_13;// 转售收入总数（万）
	private Float field_14;// 本月转售收（万）
	// 本地
	private Float field_21;// 用户总数（万）
	private Float field_22;// 本月新增数（万）
	private Float field_23;// 转售收入总数（万）
	private Float field_24;// 本月转售收（万）

	private Integer year;// 年份
	private Integer month;// 月份

	//
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

	public Float getField_21() {
		return field_21;
	}

	public void setField_21(Float field_21) {
		this.field_21 = field_21;
	}

	public Float getField_22() {
		return field_22;
	}

	public void setField_22(Float field_22) {
		this.field_22 = field_22;
	}

	public Float getField_23() {
		return field_23;
	}

	public void setField_23(Float field_23) {
		this.field_23 = field_23;
	}

	public Float getField_24() {
		return field_24;
	}

	public void setField_24(Float field_24) {
		this.field_24 = field_24;
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
