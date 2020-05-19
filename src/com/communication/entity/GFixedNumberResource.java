package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 固网号码资源
 **/
public class GFixedNumberResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	//电信
	private Integer field_11;// 局号数（万）
	private Float field_12;// 号码使用率
	//移动（铁通）
	private Integer field_21;// 局号数（万）
	private Float field_22;// 号码使用率
	//联通
	private Integer field_31;// 局号数（万）
	private Float field_32;// 号码使用率
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

	public Float getField_12() {
		return field_12;
	}

	public void setField_12(Float field_12) {
		this.field_12 = field_12;
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
