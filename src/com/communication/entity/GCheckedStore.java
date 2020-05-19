package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实名志愿者监督检查-志愿者检查门店数量form_03
 **/
public class GCheckedStore implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer field_01;// 基础电信企业门店数
	private Integer field_04;// 基础电信企业门店检查数（合规数）
	private Float field_05;// 基础电信企业门店合规率（%）

	private Integer field_06;// 转售企业门店数检查数
	private Integer field_02;// 转售企业门店数（合规数）
	private Float field_07;// 转售企业代理网点合规率（%）

	private Integer field_08;// 志愿者检查门店总数
	private Integer field_03;// 检查人次
	private Float field_09;// 志愿者检查门店合规率（%）

	private Integer year;// 年份
	private Integer month;// 月份
	private Long createdUserId;// 插入者
	private Date insertTime;
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getField_01() {
		return field_01;
	}

	public void setField_01(Integer field_01) {
		this.field_01 = field_01;
	}

	public Integer getField_02() {
		return field_02;
	}

	public void setField_02(Integer field_02) {
		this.field_02 = field_02;
	}

	public Integer getField_03() {
		return field_03;
	}

	public void setField_03(Integer field_03) {
		this.field_03 = field_03;
	}

	public Integer getField_04() {
		return field_04;
	}

	public void setField_04(Integer field_04) {
		this.field_04 = field_04;
	}

	public Float getField_05() {
		return field_05;
	}

	public void setField_05(Float field_05) {
		this.field_05 = field_05;
	}

	public Integer getField_06() {
		return field_06;
	}

	public void setField_06(Integer field_06) {
		this.field_06 = field_06;
	}

	public Float getField_07() {
		return field_07;
	}

	public void setField_07(Float field_07) {
		this.field_07 = field_07;
	}

	public Integer getField_08() {
		return field_08;
	}

	public void setField_08(Integer field_08) {
		this.field_08 = field_08;
	}

	public Float getField_09() {
		return field_09;
	}

	public void setField_09(Float field_09) {
		this.field_09 = field_09;
	}

	public Long getCreatedUserId() {
		return createdUserId;
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

	public void setCreatedUserId(Long createdUserId) {
		this.createdUserId = createdUserId;
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
