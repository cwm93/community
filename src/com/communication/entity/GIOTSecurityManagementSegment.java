package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

public class GIOTSecurityManagementSegment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	// 电信
	private Integer amount_11;//11位总数
	private Integer usedAmount_11;//11位已使用
	private Integer amount_13;
	private Integer usedAmount_13;
	// 移动
	private Integer amount_21;
	private Integer usedAmount_21;
	private Integer amount_23;
	private Integer usedAmount_23;
	// 联通
	private Integer amount_31;
	private Integer usedAmount_31;
	private Integer amount_33;
	private Integer usedAmount_33;

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

	public Integer getAmount_11() {
		return amount_11;
	}

	public void setAmount_11(Integer amount_11) {
		this.amount_11 = amount_11;
	}

	public Integer getUsedAmount_11() {
		return usedAmount_11;
	}

	public void setUsedAmount_11(Integer usedAmount_11) {
		this.usedAmount_11 = usedAmount_11;
	}

	public Integer getAmount_13() {
		return amount_13;
	}

	public void setAmount_13(Integer amount_13) {
		this.amount_13 = amount_13;
	}

	public Integer getUsedAmount_13() {
		return usedAmount_13;
	}

	public void setUsedAmount_13(Integer usedAmount_13) {
		this.usedAmount_13 = usedAmount_13;
	}

	public Integer getAmount_21() {
		return amount_21;
	}

	public void setAmount_21(Integer amount_21) {
		this.amount_21 = amount_21;
	}

	public Integer getUsedAmount_21() {
		return usedAmount_21;
	}

	public void setUsedAmount_21(Integer usedAmount_21) {
		this.usedAmount_21 = usedAmount_21;
	}

	public Integer getAmount_23() {
		return amount_23;
	}

	public void setAmount_23(Integer amount_23) {
		this.amount_23 = amount_23;
	}

	public Integer getUsedAmount_23() {
		return usedAmount_23;
	}

	public void setUsedAmount_23(Integer usedAmount_23) {
		this.usedAmount_23 = usedAmount_23;
	}

	public Integer getAmount_31() {
		return amount_31;
	}

	public void setAmount_31(Integer amount_31) {
		this.amount_31 = amount_31;
	}

	public Integer getUsedAmount_31() {
		return usedAmount_31;
	}

	public void setUsedAmount_31(Integer usedAmount_31) {
		this.usedAmount_31 = usedAmount_31;
	}

	public Integer getAmount_33() {
		return amount_33;
	}

	public void setAmount_33(Integer amount_33) {
		this.amount_33 = amount_33;
	}

	public Integer getUsedAmount_33() {
		return usedAmount_33;
	}

	public void setUsedAmount_33(Integer usedAmount_33) {
		this.usedAmount_33 = usedAmount_33;
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
