/**
 * 
 */
package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator 理垃圾短信息情况月报表
 */
public class FSpamMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID

	private String field_01;// 收到垃圾短信息投诉量（起）
	private String field_02;// 处理完毕（起）
	private String field_03;// 用户满意率（%）
	private String field_04;// 拦截垃圾短信息总量（万条）
	private String field_05;// 拦截外省市号码发送总量（万条）
	private String field_06;// 拦截本市点对点号码发送总量（万条）MO
	private String field_07;// 拦截本市点对点号码发送总量（万条）MT 拦截电信发送量
	private String field_08;// 拦截本市点对点号码发送总量（万条）MT 拦截移动发送量
	private String field_09;// 拦截本市点对点号码发送总量（万条）MT 拦截联通发送量
	private String field_10;// 拦截本企业企信通类MO短信数量（万条）
	private String field_11;// 拦截外省市企信通类MT短信数量（万条）
	private String field_12;// 屏蔽手机号码总数 MO（万个）
	private String field_13;// 屏蔽手机号码总数 MT（个）屏蔽电信号码量
	private String field_14;// 屏蔽手机号码总数 MT（个）屏蔽移动号码量
	private String field_15;// 屏蔽手机号码总数 MT（个）屏蔽联通号码量
	private String field_16;// 封堵违规企信通端口数（个）
	private String field_17;// 严重违规通报 合作企业
	private String field_18;// 严重违规通报 端口号码
	private String field_19;// 严重违规通报 关键词（组）
	private String field_20;// 重点垃圾短信拦截量（条） 房产类 企信通MO
	private String field_21;// 重点垃圾短信拦截量（条） 房产类 企信通MT
	private String field_22;// 重点垃圾短信拦截量（条） 房产类 点对点MO
	private String field_23;// 重点垃圾短信拦截量（条） 房产类 点对点MT
	private String field_24;// 重点垃圾短信拦截量（条） 房产类 数量合计
	private String field_25;// 重点垃圾短信拦截量（条） 房产类 样本
	private String field_26;// 重点垃圾短信拦截量（条）教育类 企信通MO
	private String field_27;// 重点垃圾短信拦截量（条）教育类 企信通MT
	private String field_28;// 重点垃圾短信拦截量（条）教育类 点对点MO
	private String field_29;// 重点垃圾短信拦截量（条）教育类 点对点MT
	private String field_30;// 重点垃圾短信拦截量（条）教育类 数量合计
	private String field_31;// 重点垃圾短信拦截量（条）教育类 样本
	private String field_32;// 重点垃圾短信拦截量（条）金融类 企信通MO
	private String field_33;// 重点垃圾短信拦截量（条）金融类 企信通MT
	private String field_34;// 重点垃圾短信拦截量（条）金融类 点对点MO
	private String field_35;// 重点垃圾短信拦截量（条）金融类 点对点MT
	private String field_36;// 重点垃圾短信拦截量（条）金融类 数量合计
	private String field_37;// 重点垃圾短信拦截量（条）金融类 样本
	private String field_38;// 重点垃圾短信拦截量（条）诈骗 企信通MO
	private String field_39;// 重点垃圾短信拦截量（条）诈骗 企信通MT
	private String field_40;// 重点垃圾短信拦截量（条）诈骗 点对点MO
	private String field_41;// 重点垃圾短信拦截量（条）诈骗 点对点MT
	private String field_42;// 重点垃圾短信拦截量（条）诈骗 数量合计
	private String field_43;// 重点垃圾短信拦截量（条）诈骗 样本
	private String field_44;// 处置策略建议
	private String field_45;// 运营商网间短信结算量（点对点）移动→（出）亿条
	private String field_46;// 运营商网间短信结算量（点对点） 移动→（出）亿条
	private String field_47;// 运营商网间短信结算量（点对点）联通←（入）亿条
	private String field_48;// 运营商网间短信结算量（点对点）联通←（入）亿条
	private String field_49;// 本月通过“0000”退订端口短信数量（条）
	private String field_50;// 其他需要特别说明事项

	/******* 填表人相关信息 ********/
	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date createTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

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

	public String getField_44() {
		return field_44;
	}

	public void setField_44(String field_44) {
		this.field_44 = field_44;
	}

	public String getField_45() {
		return field_45;
	}

	public void setField_45(String field_45) {
		this.field_45 = field_45;
	}

	public String getField_46() {
		return field_46;
	}

	public void setField_46(String field_46) {
		this.field_46 = field_46;
	}

	public String getField_47() {
		return field_47;
	}

	public void setField_47(String field_47) {
		this.field_47 = field_47;
	}

	public String getField_48() {
		return field_48;
	}

	public void setField_48(String field_48) {
		this.field_48 = field_48;
	}

	public String getField_49() {
		return field_49;
	}

	public void setField_49(String field_49) {
		this.field_49 = field_49;
	}

	public String getField_50() {
		return field_50;
	}

	public void setField_50(String field_50) {
		this.field_50 = field_50;
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
		return "FSpamMessage {id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
				+ ", telecomOperatorId=" + telecomOperatorId + ", field_01=" + field_01 + ", field_02=" + field_02
				+ ", field_03=" + field_03 + ", field_04=" + field_04 + ", field_05=" + field_05 + ", field_06="
				+ field_06 + ", field_07=" + field_07 + ", field_08=" + field_08 + ", field_09=" + field_09
				+ ", field_10=" + field_10 + ", field_11=" + field_11 + ", field_12=" + field_12 + ", field_13="
				+ field_13 + ", field_14=" + field_14 + ", field_15=" + field_15 + ", field_16=" + field_16
				+ ", field_17=" + field_17 + ", field_18=" + field_18 + ", field_19=" + field_19 + ", field_20="
				+ field_20 + ", field_21=" + field_21 + ", field_22=" + field_22 + ", field_23=" + field_23
				+ ", field_24=" + field_24 + ", field_25=" + field_25 + ", field_26=" + field_26 + ", field_27="
				+ field_27 + ", field_28=" + field_28 + ", field_29=" + field_29 + ", field_30=" + field_30
				+ ", field_31=" + field_31 + ", field_32=" + field_32 + ", field_33=" + field_33 + ", field_34="
				+ field_34 + ", field_35=" + field_35 + ", field_36=" + field_36 + ", field_37=" + field_37
				+ ", field_38=" + field_38 + ", field_39=" + field_39 + ", field_40=" + field_40 + ", field_41="
				+ field_41 + ", field_42=" + field_42 + ", field_43=" + field_43 + ", field_44=" + field_44
				+ ", field_45=" + field_45 + ", field_46=" + field_46 + ", field_47=" + field_47 + ", field_48="
				+ field_48 + ", field_49=" + field_49 + ", field_50=" + field_50 + ", userName=" + userName
				+ ", company=" + company + ", mobile=" + mobile + ", email=" + email + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "}";
	}

}
