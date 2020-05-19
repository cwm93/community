/**
 * 
 */
package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator 打击通讯信息诈骗相关业务数据周报
 */
public class FXxzp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID

	/***** 语音专线出租业务 ***/
	private String field_1;// 总用户数（家）
	private String field_2;// 实名率（%）
	private String field_3;// 老用户核查率（%）
	private String field_4;// 关停企业（家）
	private String field_5;// 关停号码（个）
	/****** “400”业务 *******/
	private String field_6;// 总用户数（家）
	private String field_7;// 实名率（%）
	private String field_8;// 老用户核查率（%）
	private String field_9;// 关停企业（家）
	private String field_10;// 关停号码（个）
	/******** 一号通业务 **************/
	private String field_11;// 总用户数（家）
	private String field_12;// 实名率（%）
	private String field_13;// 老用户核查率（%）
	private String field_14;// 关停企业（家）
	private String field_15;// 关停号码（个）
	/********* 商务总机业务 **********/
	private String field_16;// 总用户数（家）
	private String field_17;// 实名率（%）
	private String field_18;// 老用户核查率（%）
	private String field_19;// 关停企业（家）
	private String field_20;// 关停号码（个）
	/******** 代理行为监管 ******/
	private String field_21;// 代理商总数（家）
	private String field_22;// 代理商清理数（家）
	/********* 封堵境外非法透传 *********/
	private String field_23;// 拦截数量（万次）
	/********* 语音专线主叫鉴权 ********/
	private String field_24;// 总电路数（条）
	private String field_25;// 未完成主叫鉴权电路数（条）
	private String field_26;// 关停电路数（条）
	private String field_27;// 主叫鉴权率（%）
	/*** 虚假改号呼叫拦截 ***/
	private String field_28;// 拦截数量（次）
	/**** 非法诈骗链接处置 ****/
	private String field_29;// 处置数量（次）
	/******** 防骚扰提醒服务 ********/
	private String field_30;// 总用户数（人）
	/******** 骚扰电话整顿 *********/
	private String field_31;// 配置白名单中继线（条）
	private String field_32;// 关停中继线（条）
	private String field_33;// 关停号码（个）
	/******** 配合打击伪基站 *********/
	private String field_34;// 缴获设备（台）
	private String field_35;// 抓获嫌疑人（人）
	/******** 不良信息举报 **********/
	private String field_36;// 受理举报总数（起）
	private String field_37;// 平台处置举报（起）
	private String field_38;// 处置端口（个）
	/******** 一键退订 ********/
	private String field_39;// 退订数量（万起）
	/******* 涉诈骗号码提示服务 *******/
	private String field_40;// 发送提醒短信 （条）
	private String field_41;// 客服回访 （次）
	private String field_42;// 回访成功 （次）
	private String field_43;// 推送公安介入 （次）
	/******* 填表人相关信息 ********/
	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	public FXxzp() {
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

	public String getField_1() {
		return field_1;
	}

	public void setField_1(String field_1) {
		this.field_1 = field_1;
	}

	public String getField_2() {
		return field_2;
	}

	public void setField_2(String field_2) {
		this.field_2 = field_2;
	}

	public String getField_3() {
		return field_3;
	}

	public void setField_3(String field_3) {
		this.field_3 = field_3;
	}

	public String getField_4() {
		return field_4;
	}

	public void setField_4(String field_4) {
		this.field_4 = field_4;
	}

	public String getField_5() {
		return field_5;
	}

	public void setField_5(String field_5) {
		this.field_5 = field_5;
	}

	public String getField_6() {
		return field_6;
	}

	public void setField_6(String field_6) {
		this.field_6 = field_6;
	}

	public String getField_7() {
		return field_7;
	}

	public void setField_7(String field_7) {
		this.field_7 = field_7;
	}

	public String getField_8() {
		return field_8;
	}

	public void setField_8(String field_8) {
		this.field_8 = field_8;
	}

	public String getField_9() {
		return field_9;
	}

	public void setField_9(String field_9) {
		this.field_9 = field_9;
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

	public String getField_16() {
		return field_16;
	}

	public void setField_16(String field_16) {
		this.field_16 = field_16;
	}

	public String getField_17() {
		return field_17;
	}

	public void setField_17(String field_17) {
		this.field_17 = field_17;
	}

	public String getField_18() {
		return field_18;
	}

	public void setField_18(String field_18) {
		this.field_18 = field_18;
	}

	public String getField_19() {
		return field_19;
	}

	public void setField_19(String field_19) {
		this.field_19 = field_19;
	}

	public String getField_20() {
		return field_20;
	}

	public void setField_20(String field_20) {
		this.field_20 = field_20;
	}

	public String getField_21() {
		return field_21;
	}

	public void setField_21(String field_21) {
		this.field_21 = field_21;
	}

	public String getField_22() {
		return field_22;
	}

	public void setField_22(String field_22) {
		this.field_22 = field_22;
	}

	public String getField_23() {
		return field_23;
	}

	public void setField_23(String field_23) {
		this.field_23 = field_23;
	}

	public String getField_24() {
		return field_24;
	}

	public void setField_24(String field_24) {
		this.field_24 = field_24;
	}

	public String getField_25() {
		return field_25;
	}

	public void setField_25(String field_25) {
		this.field_25 = field_25;
	}

	public String getField_26() {
		return field_26;
	}

	public void setField_26(String field_26) {
		this.field_26 = field_26;
	}

	public String getField_27() {
		return field_27;
	}

	public void setField_27(String field_27) {
		this.field_27 = field_27;
	}

	public String getField_28() {
		return field_28;
	}

	public void setField_28(String field_28) {
		this.field_28 = field_28;
	}

	public String getField_29() {
		return field_29;
	}

	public void setField_29(String field_29) {
		this.field_29 = field_29;
	}

	public String getField_30() {
		return field_30;
	}

	public void setField_30(String field_30) {
		this.field_30 = field_30;
	}

	public String getField_31() {
		return field_31;
	}

	public void setField_31(String field_31) {
		this.field_31 = field_31;
	}

	public String getField_32() {
		return field_32;
	}

	public void setField_32(String field_32) {
		this.field_32 = field_32;
	}

	public String getField_33() {
		return field_33;
	}

	public void setField_33(String field_33) {
		this.field_33 = field_33;
	}

	public String getField_34() {
		return field_34;
	}

	public void setField_34(String field_34) {
		this.field_34 = field_34;
	}

	public String getField_35() {
		return field_35;
	}

	public void setField_35(String field_35) {
		this.field_35 = field_35;
	}

	public String getField_36() {
		return field_36;
	}

	public void setField_36(String field_36) {
		this.field_36 = field_36;
	}

	public String getField_37() {
		return field_37;
	}

	public void setField_37(String field_37) {
		this.field_37 = field_37;
	}

	public String getField_38() {
		return field_38;
	}

	public void setField_38(String field_38) {
		this.field_38 = field_38;
	}

	public String getField_39() {
		return field_39;
	}

	public void setField_39(String field_39) {
		this.field_39 = field_39;
	}

	public String getField_40() {
		return field_40;
	}

	public void setField_40(String field_40) {
		this.field_40 = field_40;
	}

	public String getField_41() {
		return field_41;
	}

	public void setField_41(String field_41) {
		this.field_41 = field_41;
	}

	public String getField_42() {
		return field_42;
	}

	public void setField_42(String field_42) {
		this.field_42 = field_42;
	}

	public String getField_43() {
		return field_43;
	}

	public void setField_43(String field_43) {
		this.field_43 = field_43;
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

	@Override
	public String toString() {
		return "FXxzp {id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
				+ ", telecomOperatorId=" + telecomOperatorId + ", field_1=" + field_1 + ", field_2=" + field_2
				+ ", field_3=" + field_3 + ", field_4=" + field_4 + ", field_5=" + field_5 + ", field_6=" + field_6
				+ ", field_7=" + field_7 + ", field_8=" + field_8 + ", field_9=" + field_9 + ", field_10=" + field_10
				+ ", field_11=" + field_11 + ", field_12=" + field_12 + ", field_13=" + field_13 + ", field_14="
				+ field_14 + ", field_15=" + field_15 + ", field_16=" + field_16 + ", field_17=" + field_17
				+ ", field_18=" + field_18 + ", field_19=" + field_19 + ", field_20=" + field_20 + ", field_21="
				+ field_21 + ", field_22=" + field_22 + ", field_23=" + field_23 + ", field_24=" + field_24
				+ ", field_25=" + field_25 + ", field_26=" + field_26 + ", field_27=" + field_27 + ", field_28="
				+ field_28 + ", field_29=" + field_29 + ", field_30=" + field_30 + ", field_31=" + field_31
				+ ", field_32=" + field_32 + ", field_33=" + field_33 + ", field_34=" + field_34 + ", field_35="
				+ field_35 + ", field_36=" + field_36 + ", field_37=" + field_37 + ", field_38=" + field_38
				+ ", field_39=" + field_39 + ", field_40=" + field_40 + ", field_41=" + field_41 + ", field_42="
				+ field_42 + ", field_43=" + field_43 + ", userName=" + userName + ", company=" + company + ", mobile="
				+ mobile + ", email=" + email + ", insertTime=" + insertTime + ", updateTime=" + updateTime + "}";
	}

}
