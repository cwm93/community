/**
 * 
 */
package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator 上海地区电信运营商企业提速降价工作情况
 */
public class FPriceSpeed implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID

	private Integer lastYear;// 上一年
	private Integer thisYear;// 本年
	private Integer thisMonth;// 本月
	// 固定宽带单位带宽平均资费（元/MB）
	private String field_01; // 上一年年底
	private String field_02; // 本月底
	private String field_03; // 本年年底
	private String field_04; // 集团年度目标
	private String field_05; // 已完成目标
	private String field_06; // 预计完成目标
	// 手机流量平均资费（元/MB）
	private String field_07; // 上一年年底
	private String field_08; // 本月底
	private String field_09; // 本年年底
	private String field_10; // 集团年度目标
	private String field_11; // 已完成目标
	private String field_12; // 预计完成目标
	// 降费举措
	private String field_13; // 固定宽带方面
	private String field_14; // 手机流量方面
	private String field_15; // 宣传方面
	// 填表人相关信息
	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date createTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	public FPriceSpeed() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getReportLogId() {
		return reportLogId;
	}

	public void setReportLogId(long reportLogId) {
		this.reportLogId = reportLogId;
	}

	public long getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(long insertUserId) {
		this.insertUserId = insertUserId;
	}

	public long getTelecomOperatorId() {
		return telecomOperatorId;
	}

	public void setTelecomOperatorId(long telecomOperatorId) {
		this.telecomOperatorId = telecomOperatorId;
	}

	public Integer getLastYear() {
		return lastYear;
	}

	public void setLastYear(Integer lastYear) {
		this.lastYear = lastYear;
	}

	public Integer getThisYear() {
		return thisYear;
	}

	public void setThisYear(Integer thisYear) {
		this.thisYear = thisYear;
	}

	public Integer getThisMonth() {
		return thisMonth;
	}

	public void setThisMonth(Integer thisMonth) {
		this.thisMonth = thisMonth;
	}

	public String getField_01() {
		return field_01;
	}

	public void setField_01(String field_01) {
		this.field_01 = field_01;
	}

	public String getField_02() {
		return field_02;
	}

	public void setField_02(String field_02) {
		this.field_02 = field_02;
	}

	public String getField_03() {
		return field_03;
	}

	public void setField_03(String field_03) {
		this.field_03 = field_03;
	}

	public String getField_04() {
		return field_04;
	}

	public void setField_04(String field_04) {
		this.field_04 = field_04;
	}

	public String getField_05() {
		return field_05;
	}

	public void setField_05(String field_05) {
		this.field_05 = field_05;
	}

	public String getField_06() {
		return field_06;
	}

	public void setField_06(String field_06) {
		this.field_06 = field_06;
	}

	public String getField_07() {
		return field_07;
	}

	public void setField_07(String field_07) {
		this.field_07 = field_07;
	}

	public String getField_08() {
		return field_08;
	}

	public void setField_08(String field_08) {
		this.field_08 = field_08;
	}

	public String getField_09() {
		return field_09;
	}

	public void setField_09(String field_09) {
		this.field_09 = field_09;
	}

	public String getField_10() {
		return field_10;
	}

	public void setField_10(String field_10) {
		this.field_10 = field_10;
	}

	public String getField_11() {
		return field_11;
	}

	public void setField_11(String field_11) {
		this.field_11 = field_11;
	}

	public String getField_12() {
		return field_12;
	}

	public void setField_12(String field_12) {
		this.field_12 = field_12;
	}

	public String getField_13() {
		return field_13;
	}

	public void setField_13(String field_13) {
		this.field_13 = field_13;
	}

	public String getField_14() {
		return field_14;
	}

	public void setField_14(String field_14) {
		this.field_14 = field_14;
	}

	public String getField_15() {
		return field_15;
	}

	public void setField_15(String field_15) {
		this.field_15 = field_15;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "FPriceSpeed {id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
				+ ", telecomOperatorId=" + telecomOperatorId + ", lastYear=" + lastYear + ", thisYear=" + thisYear
				+ ", thisMonth=" + thisMonth + ", field_01=" + field_01 + ", field_02=" + field_02 + ", field_03="
				+ field_03 + ", field_04=" + field_04 + ", field_05=" + field_05 + ", field_06=" + field_06
				+ ", field_07=" + field_07 + ", field_08=" + field_08 + ", field_09=" + field_09 + ", field_10="
				+ field_10 + ", field_11=" + field_11 + ", field_12=" + field_12 + ", field_13=" + field_13
				+ ", field_14=" + field_14 + ", field_15=" + field_15 + ", userName=" + userName + ", company="
				+ company + ", mobile=" + mobile + ", email=" + email + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "}";
	}

}
