package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "g_check_job_list")
public class GCheckJobList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	// 电信
	private Integer field_11;// 核查工单及时率排名（倒数）
	private Float field_12;// 核查工单及时率
	private Integer field_13;// 核查工单准确率排名（倒数）
	private Float field_14;// 核查工单准确率
	// 移动
	private Integer field_21;// 核查工单及时率排名（倒数）
	private Float field_22;// 核查工单及时率
	private Integer field_23;// 核查工单准确率排名（倒数）
	private Float field_24;// 核查工单准确率
	// 联通
	private Integer field_31;// 核查工单及时率排名（倒数）
	private Float field_32;// 核查工单及时率
	private Integer field_33;// 核查工单准确率排名（倒数）
	private Float field_34;// 核查工单准确率

	private Integer year;// 年份
	private Integer month;// 月份

	//
	private Long createUserId;
	private Date insertTime;
	private Date updateTime;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "field_11")
	public Integer getField_11() {
		return field_11;
	}

	public void setField_11(Integer field_11) {
		this.field_11 = field_11;
	}

	@Column(name = "field_12")
	public Float getField_12() {
		return field_12;
	}

	public void setField_12(Float field_12) {
		this.field_12 = field_12;
	}

	@Column(name = "field_13")
	public Integer getField_13() {
		return field_13;
	}

	public void setField_13(Integer field_13) {
		this.field_13 = field_13;
	}

	@Column(name = "field_14")
	public Float getField_14() {
		return field_14;
	}

	public void setField_14(Float field_14) {
		this.field_14 = field_14;
	}

	@Column(name = "field_21")
	public Integer getField_21() {
		return field_21;
	}

	public void setField_21(Integer field_21) {
		this.field_21 = field_21;
	}

	@Column(name = "field_22")
	public Float getField_22() {
		return field_22;
	}

	public void setField_22(Float field_22) {
		this.field_22 = field_22;
	}

	@Column(name = "field_23")
	public Integer getField_23() {
		return field_23;
	}

	public void setField_23(Integer field_23) {
		this.field_23 = field_23;
	}

	@Column(name = "field_24")
	public Float getField_24() {
		return field_24;
	}

	public void setField_24(Float field_24) {
		this.field_24 = field_24;
	}

	@Column(name = "field_31")
	public Integer getField_31() {
		return field_31;
	}

	public void setField_31(Integer field_31) {
		this.field_31 = field_31;
	}

	@Column(name = "field_32")
	public Float getField_32() {
		return field_32;
	}

	public void setField_32(Float field_32) {
		this.field_32 = field_32;
	}

	@Column(name = "field_33")
	public Integer getField_33() {
		return field_33;
	}

	public void setField_33(Integer field_33) {
		this.field_33 = field_33;
	}

	@Column(name = "field_34")
	public Float getField_34() {
		return field_34;
	}

	public void setField_34(Float field_34) {
		this.field_34 = field_34;
	}

	@Column(name = "year")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(name = "month")
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@Column(name = "create_user_id")
	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "insert_time")
	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	@Column(name = "update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
