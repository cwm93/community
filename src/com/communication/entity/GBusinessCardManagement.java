package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 行业卡管理
 */
public class GBusinessCardManagement implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	// 电信
	private Integer field_11; // 存量物联网卡用户数（个）
	private Integer field_12;// 累计采取技术限定号码数量
	private Float field_13;// 技术限定百分率

	// 移动
	private Integer field_21; // 存量物联网卡用户数（个）
	private Integer field_22;// 累计采取技术限定号码数量
	private Float field_23;// 技术限定百分率

	// 联通
	private Integer field_31; // 存量物联网卡用户数（个）
	private Integer field_32;// 累计采取技术限定号码数量
	private Float field_33;// 技术限定百分率

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

	public Integer getField_11() {
		return field_11;
	}

	public void setField_11(Integer field_11) {
		this.field_11 = field_11;
	}

	public Integer getField_12() {
		return field_12;
	}

	public void setField_12(Integer field_12) {
		this.field_12 = field_12;
	}

	public Float getField_13() {
		return field_13;
	}

	public void setField_13(Float field_13) {
		this.field_13 = field_13;
	}

	public Integer getField_21() {
		return field_21;
	}

	public void setField_21(Integer field_21) {
		this.field_21 = field_21;
	}

	public Integer getField_22() {
		return field_22;
	}

	public void setField_22(Integer field_22) {
		this.field_22 = field_22;
	}

	public Float getField_23() {
		return field_23;
	}

	public void setField_23(Float field_23) {
		this.field_23 = field_23;
	}

	public Integer getField_31() {
		return field_31;
	}

	public void setField_31(Integer field_31) {
		this.field_31 = field_31;
	}

	public Integer getField_32() {
		return field_32;
	}

	public void setField_32(Integer field_32) {
		this.field_32 = field_32;
	}

	public Float getField_33() {
		return field_33;
	}

	public void setField_33(Float field_33) {
		this.field_33 = field_33;
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
