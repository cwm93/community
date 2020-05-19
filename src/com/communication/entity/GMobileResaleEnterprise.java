package com.communication.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 移动通信转售企业业务统计表																			
 **/
public class GMobileResaleEnterprise implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	// 移动电话用户数量（户）
	private Float field_11;
	// 单位用户数量（户）
	private Float field_12;
	// 行业应用卡数量（户）
	private Float field_13;
	// 一证多户号码数
	private Float field_14;
	// 一证多卡用户数
	private Float field_15;
	// 转售业务收入（万元）
	private Float field_16;
	// 实体代理店数 
	private Float field_17;
	//网络代理店数
	private Float field_23;
	// 社会渠道统一配发授权牌数量（张）
	private Float field_18;
	// 统计月检查次数
	private Float field_19;
	// 本年度累计检查次数
	private Float field_20;
	// 本年度累计处罚和取消代理网点数
	private Float field_21;
	// 本年度累计处罚人员数
	private Float field_22;

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

	public Float getField_17() {
		return field_17;
	}

	public void setField_17(Float field_17) {
		this.field_17 = field_17;
	}

	public Float getField_18() {
		return field_18;
	}

	public void setField_18(Float field_18) {
		this.field_18 = field_18;
	}

	public Float getField_19() {
		return field_19;
	}

	public void setField_19(Float field_19) {
		this.field_19 = field_19;
	}

	public Float getField_20() {
		return field_20;
	}

	public void setField_20(Float field_20) {
		this.field_20 = field_20;
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
