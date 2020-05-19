package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 增值电信业务
 */
public class GValueAddedTelecomBussiness implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	// 总计
	private Float field_11;// 营业收入（亿）
	private Float field_12;// 同比
	private Float field_13;// 电信业务收入（亿）
	private Float field_14;// 同比
	// 信息服务
	private Float field_21;// 营业收入（亿）
	private Float field_22;// 同比
	private Float field_23;// 电信业务收入（亿）
	private Float field_24;// 同比
	// 接入服务
	private Float field_31;// 营业收入（亿）
	private Float field_32;// 同比
	private Float field_33;// 电信业务收入（亿）
	private Float field_34;// 同比
	// 呼叫中心
	private Float field_41;// 营业收入（亿）
	private Float field_42;// 同比
	private Float field_43;// 电信业务收入（亿）
	private Float field_44;// 同比

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

	public Float getField_31() {
		return field_31;
	}

	public void setField_31(Float field_31) {
		this.field_31 = field_31;
	}

	public Float getField_32() {
		return field_32;
	}

	public void setField_32(Float field_32) {
		this.field_32 = field_32;
	}

	public Float getField_33() {
		return field_33;
	}

	public void setField_33(Float field_33) {
		this.field_33 = field_33;
	}

	public Float getField_34() {
		return field_34;
	}

	public void setField_34(Float field_34) {
		this.field_34 = field_34;
	}

	public Float getField_41() {
		return field_41;
	}

	public void setField_41(Float field_41) {
		this.field_41 = field_41;
	}

	public Float getField_42() {
		return field_42;
	}

	public void setField_42(Float field_42) {
		this.field_42 = field_42;
	}

	public Float getField_43() {
		return field_43;
	}

	public void setField_43(Float field_43) {
		this.field_43 = field_43;
	}

	public Float getField_44() {
		return field_44;
	}

	public void setField_44(Float field_44) {
		this.field_44 = field_44;
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
