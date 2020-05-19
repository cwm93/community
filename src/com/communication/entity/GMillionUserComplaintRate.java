package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 百万用户申诉率
 */
public class GMillionUserComplaintRate implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 电信
	 **/
	// 百万用户申诉率
	private Float field_11;// 总受理量(件)
	private Float field_12;// 用户总数（万）
	private Float field_13;// 百万用户申诉率（人次/百万用户）
	// 不明扣费申诉率
	private Float field_14;// 总受理量(件)
	private Float field_15;// 用户总数（万）
	private Float field_16;// 百万用户申诉率（人次/百万用户）

	/**
	 * 移动
	 **/
	// 百万用户申诉率
	private Float field_21;// 总受理量(件)
	private Float field_22;// 用户总数（万）
	private Float field_23;// 百万用户申诉率（人次/百万用户）
	// 不明扣费申诉率
	private Float field_24;// 总受理量(件)
	private Float field_25;// 用户总数（万）
	private Float field_26;// 百万用户申诉率（人次/百万用户）

	/**
	 * 联通
	 **/
	// 百万用户申诉率
	private Float field_31;// 总受理量(件)
	private Float field_32;// 用户总数（万）
	private Float field_33;// 百万用户申诉率（人次/百万用户）
	// 不明扣费申诉率
	private Float field_34;// 总受理量(件)
	private Float field_35;// 用户总数（万）
	private Float field_36;// 百万用户申诉率（人次/百万用户）

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

	public Float getField_15() {
		return field_15;
	}

	public void setField_15(Float field_15) {
		this.field_15 = field_15;
	}

	public Float getField_16() {
		return field_16;
	}

	public void setField_16(Float field_16) {
		this.field_16 = field_16;
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

	public Float getField_25() {
		return field_25;
	}

	public void setField_25(Float field_25) {
		this.field_25 = field_25;
	}

	public Float getField_26() {
		return field_26;
	}

	public void setField_26(Float field_26) {
		this.field_26 = field_26;
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

	public Float getField_35() {
		return field_35;
	}

	public void setField_35(Float field_35) {
		this.field_35 = field_35;
	}

	public Float getField_36() {
		return field_36;
	}

	public void setField_36(Float field_36) {
		this.field_36 = field_36;
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
