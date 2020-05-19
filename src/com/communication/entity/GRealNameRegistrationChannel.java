package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

public class GRealNameRegistrationChannel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer filed_01;// 自营厅总数
	private Integer filed_02;// 代理点总数
	private Integer filed_03;// 电商平台授权数
	private Integer filed_04;// 二代身份证识别设备网点数
	private Integer filed_05;// 社会渠道授权牌数
	private Integer filed_06;// 本月终止违规代理商数
	private Integer filed_07;//代理渠道售卡数
	private Integer filed_08;//代理渠道售卡拍照核验不合规数
	private int year;// 年份
	private int month;// 月份
	private Long createdUserId;// 添加者
	private Date insertTime;
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFiled_01() {
		return filed_01;
	}

	public void setFiled_01(Integer filed_01) {
		this.filed_01 = filed_01;
	}

	public Integer getFiled_02() {
		return filed_02;
	}

	public void setFiled_02(Integer filed_02) {
		this.filed_02 = filed_02;
	}

	public Integer getFiled_03() {
		return filed_03;
	}

	public void setFiled_03(Integer filed_03) {
		this.filed_03 = filed_03;
	}

	public Integer getFiled_04() {
		return filed_04;
	}

	public void setFiled_04(Integer filed_04) {
		this.filed_04 = filed_04;
	}

	public Integer getFiled_05() {
		return filed_05;
	}

	public void setFiled_05(Integer filed_05) {
		this.filed_05 = filed_05;
	}

	public Integer getFiled_06() {
		return filed_06;
	}

	public void setFiled_06(Integer filed_06) {
		this.filed_06 = filed_06;
	}

	public Integer getFiled_07() {
		return filed_07;
	}

	public void setFiled_07(Integer filed_07) {
		this.filed_07 = filed_07;
	}

	public Integer getFiled_08() {
		return filed_08;
	}

	public void setFiled_08(Integer filed_08) {
		this.filed_08 = filed_08;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Long getCreatedUserId() {
		return createdUserId;
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
