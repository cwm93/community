package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 打击通讯信息诈骗相关业务数据周报
 **/
public class GCombatFraudBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	// 语音专线出租业务
	private Integer field_11;// 总用户数（家）
	private Float field_12;// 实名率（%）
	private Integer field_13;// 关停号码（个）
	// “400”业务
	private Integer field_21;// 总用户数（家）
	private Float field_22;// 实名率（%）
	private Integer field_23;// 关停号码（个）
	// 一号通业务
	private Integer field_31;// 总用户数（家）
	private Float field_32;// 实名率（%）
	private Integer field_33;// 关停号码（个）
	// 商务总机业务
	private Integer field_41;// 总用户数（家）
	private Float field_42;// 实名率（%）
	private Integer field_43;// 关停号码（个）
	// 封堵境外非法透传
	private Float field_51;// 拦截数量（万次）
	// 语音专线主叫鉴权
	private Integer field_61;// 总电路数（条）
	private Float field_62;// 主叫鉴权率（%）
	// 虚假改号呼叫拦截
	private Integer field_71;// 拦截数量（次）
	// 一键退订
	private Float field_81;// 退订数量（万起）

	//
	private Integer year;// 年份
	private Integer month;// 月份
	private Integer day;//日期

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

	public Float getField_12() {
		return field_12;
	}

	public void setField_12(Float field_12) {
		this.field_12 = field_12;
	}

	public Integer getField_13() {
		return field_13;
	}

	public void setField_13(Integer field_13) {
		this.field_13 = field_13;
	}

	public Integer getField_21() {
		return field_21;
	}

	public void setField_21(Integer field_21) {
		this.field_21 = field_21;
	}

	public Float getField_22() {
		return field_22;
	}

	public void setField_22(Float field_22) {
		this.field_22 = field_22;
	}

	public Integer getField_23() {
		return field_23;
	}

	public void setField_23(Integer field_23) {
		this.field_23 = field_23;
	}

	public Integer getField_31() {
		return field_31;
	}

	public void setField_31(Integer field_31) {
		this.field_31 = field_31;
	}

	public Float getField_32() {
		return field_32;
	}

	public void setField_32(Float field_32) {
		this.field_32 = field_32;
	}

	public Integer getField_33() {
		return field_33;
	}

	public void setField_33(Integer field_33) {
		this.field_33 = field_33;
	}

	public Integer getField_41() {
		return field_41;
	}

	public void setField_41(Integer field_41) {
		this.field_41 = field_41;
	}

	public Float getField_42() {
		return field_42;
	}

	public void setField_42(Float field_42) {
		this.field_42 = field_42;
	}

	public Integer getField_43() {
		return field_43;
	}

	public void setField_43(Integer field_43) {
		this.field_43 = field_43;
	}

	public Float getField_51() {
		return field_51;
	}

	public void setField_51(Float field_51) {
		this.field_51 = field_51;
	}

	public Integer getField_61() {
		return field_61;
	}

	public void setField_61(Integer field_61) {
		this.field_61 = field_61;
	}

	public Float getField_62() {
		return field_62;
	}

	public void setField_62(Float field_62) {
		this.field_62 = field_62;
	}

	public Integer getField_71() {
		return field_71;
	}

	public void setField_71(Integer field_71) {
		this.field_71 = field_71;
	}

	public Float getField_81() {
		return field_81;
	}

	public void setField_81(Float field_81) {
		this.field_81 = field_81;
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

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
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
