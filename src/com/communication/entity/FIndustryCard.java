package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @关于强化行业卡实名登记管理工作要求自查月报表
 */
public class FIndustryCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private Long reportLogId;
	private Long insertUserId;// 插入者id
	private Long telecomOperatorId;// 运营商ID
	// 存量物联网卡用户数（个）<br/>存量物联网卡用户数=专用号段物联网卡+公众号段物联网卡
	private String field_01; // 自查数据
	private String field_02;// 未完成原因
	private String field_03;// 计划完成时间
	// 其中：2017年累计已补登记的物联网卡用户数（个）
	private String field_04;// 自查数据
	private String field_05;// 未完成原因
	private String field_06;// 计划完成时间
	// 存量物联网卡用户中，累计实名制登记到单位和责任人的物联网用户数（个）
	private String field_07;// 自查数据
	private String field_08;// 未完成原因
	private String field_09;// 计划完成时间
	// 存量物联网卡用户中，累计实名制登记到单位和使用人的物联网用户数（个）
	private String field_10;// 自查数据
	private String field_11;// 未完成原因
	private String field_12;// 计划完成时间
	// 物联网卡用户实名补登记完成进度（%）
	private String field_13;// 自查数据
	private String field_14;// 未完成原因
	private String field_15;// 计划完成时间
	// 存量物联网卡用户中，使用专用号段的物联网卡用户数（个）（专用号段包含13位专用号段和11位专用号段）
	private String field_16;// 自查数据
	private String field_17;// 未完成原因
	private String field_18;// 计划完成时间
	//存量物联网卡用户中，使用公众号段的物联网卡用户数（个）
	private String field_19;// 自查数据
	private String field_20;// 未完成原因
	private String field_21;// 计划完成时间
	//存量物联网卡用户中，开通语音功能的物联网卡用户数（个）
	private String field_22;// 自查数据
	private String field_23;// 未完成原因
	private String field_24;// 计划完成时间
	//其中：开通无限制语音功能的物联网卡用户数（个）
	private String field_25;// 自查数据
	private String field_26;// 未完成原因
	private String field_27;// 计划完成时间
	//开通无限制语音功能的物联网卡，已实名补登记到使用人的用户数（个）
	private String field_28;// 自查数据
	private String field_29;// 未完成原因
	private String field_30;// 计划完成时间
	//开通无限制语音功能的物联网卡，已实名补登记到使用人的完成进度（%） （2017年底前须完成100%）
	private String field_31;// 自查数据
	private String field_32;// 未完成原因
	private String field_33;// 计划完成时间
	//通信功能限制：按照最小限度开通业务功能，短信和语音均默认关闭
	private String field_34;// 自查数据
	private String field_35;// 未完成原因
	private String field_36;// 计划完成时间
	//专用网络限制：例如，采用“专用APN+专用电路”或者“VPDN隧道+专线”的方式建立VPDN定向网络实现仅访问企业内网功能
	private String field_37;// 自查数据
	private String field_38;// 未完成原因
	private String field_39;// 计划完成时间
	//定向IP/URL访问控制：例如，采用专用APN并在M-GGSN上设置或者通过网络侧设置IP访问策略的方式，实现对物联网终端可访问/不可访问特定IP地址/URL的限制功能
	private String field_40;// 自查数据
	private String field_41;// 未完成原因
	private String field_42;// 计划完成时间
	//使用区域限制：在HLR上设置漫游区域，限制仅可在上海使用
	private String field_43;// 自查数据
	private String field_44;// 未完成原因
	private String field_45;// 计划完成时间
	//语音功能限制：例如，针对某个客户账户下SIM卡设置群组，为每个群组提供语音接听/拨打定向号码能力
	private String field_46;// 自查数据
	private String field_47;// 未完成原因
	private String field_48;// 计划完成时间
	//机卡关联绑定：当物联网卡换到其他终端后，后台一旦检测到绑定信息变化，立即停用物联网卡的功能。
	private String field_49;// 自查数据
	private String field_50;// 未完成原因
	private String field_51;// 计划完成时间
	//其中：通过机卡绑定检测到异常使用的物联网用户数（个）
	private String field_52;// 自查数据
	private String field_53;// 未完成原因
	private String field_54;// 计划完成时间
	//合同回头看：因合同不规范，缺少主要合同约定内容，包括业务类型、号卡开通功能、销售数量异常、未明确不得进行二次销售等问题，终止合约的存量集团客户数（家）
	private String field_55;// 自查数据
	private String field_56;// 未完成原因
	private String field_57;// 计划完成时间
	//本月关停物联网卡用户数（个）
	private String field_58;// 自查数据
	private String field_59;// 未完成原因
	private String field_60;// 计划完成时间
	//2017年累计关停物联网卡用户数（个）
	private String field_61;// 自查数据
	private String field_62;// 未完成原因
	private String field_63;// 计划完成时间
	//2017年累计被工信部/集团通报的物联网卡用户违规数量（个）
	private String field_64;// 自查数据
	private String field_65;// 未完成原因
	private String field_66;// 计划完成时间
	//2017年处罚人员数量（人）
	private String field_67;// 自查数据
	private String field_68;// 未完成原因
	private String field_69;// 计划完成时间
	
	//新增
	//已采用业务限制及机卡绑定技术手段的号码小计（需剔重）
	private String field_70;// 自查数据
	private String field_71;// 未完成原因
	private String field_72;// 计划完成时间
	//
	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date createTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	public FIndustryCard() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReportLogId() {
		return reportLogId;
	}

	public void setReportLogId(Long reportLogId) {
		this.reportLogId = reportLogId;
	}

	public Long getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(Long insertUserId) {
		this.insertUserId = insertUserId;
	}

	public Long getTelecomOperatorId() {
		return telecomOperatorId;
	}

	public void setTelecomOperatorId(Long telecomOperatorId) {
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

	public String getField_51() {
		return field_51;
	}

	public void setField_51(String field_51) {
		this.field_51 = field_51;
	}

	public String getField_52() {
		return field_52;
	}

	public void setField_52(String field_52) {
		this.field_52 = field_52;
	}

	public String getField_53() {
		return field_53;
	}

	public void setField_53(String field_53) {
		this.field_53 = field_53;
	}

	public String getField_54() {
		return field_54;
	}

	public void setField_54(String field_54) {
		this.field_54 = field_54;
	}

	public String getField_55() {
		return field_55;
	}

	public void setField_55(String field_55) {
		this.field_55 = field_55;
	}

	public String getField_56() {
		return field_56;
	}

	public void setField_56(String field_56) {
		this.field_56 = field_56;
	}

	public String getField_57() {
		return field_57;
	}

	public void setField_57(String field_57) {
		this.field_57 = field_57;
	}

	public String getField_58() {
		return field_58;
	}

	public void setField_58(String field_58) {
		this.field_58 = field_58;
	}

	public String getField_59() {
		return field_59;
	}

	public void setField_59(String field_59) {
		this.field_59 = field_59;
	}

	public String getField_60() {
		return field_60;
	}

	public void setField_60(String field_60) {
		this.field_60 = field_60;
	}

	public String getField_61() {
		return field_61;
	}

	public void setField_61(String field_61) {
		this.field_61 = field_61;
	}

	public String getField_62() {
		return field_62;
	}

	public void setField_62(String field_62) {
		this.field_62 = field_62;
	}

	public String getField_63() {
		return field_63;
	}

	public void setField_63(String field_63) {
		this.field_63 = field_63;
	}

	public String getField_64() {
		return field_64;
	}

	public void setField_64(String field_64) {
		this.field_64 = field_64;
	}

	public String getField_65() {
		return field_65;
	}

	public void setField_65(String field_65) {
		this.field_65 = field_65;
	}

	public String getField_66() {
		return field_66;
	}

	public void setField_66(String field_66) {
		this.field_66 = field_66;
	}

	public String getField_67() {
		return field_67;
	}

	public void setField_67(String field_67) {
		this.field_67 = field_67;
	}

	public String getField_68() {
		return field_68;
	}

	public void setField_68(String field_68) {
		this.field_68 = field_68;
	}

	public String getField_69() {
		return field_69;
	}

	public void setField_69(String field_69) {
		this.field_69 = field_69;
	}

	public String getField_70() {
		return field_70;
	}

	public void setField_70(String field_70) {
		this.field_70 = field_70;
	}

	public String getField_71() {
		return field_71;
	}

	public void setField_71(String field_71) {
		this.field_71 = field_71;
	}

	public String getField_72() {
		return field_72;
	}

	public void setField_72(String field_72) {
		this.field_72 = field_72;
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
		return "FIndustryCard [id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
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
				+ field_48 + ", field_49=" + field_49 + ", field_50=" + field_50 + ", field_51=" + field_51
				+ ", field_52=" + field_52 + ", field_53=" + field_53 + ", field_54=" + field_54 + ", field_55="
				+ field_55 + ", field_56=" + field_56 + ", field_57=" + field_57 + ", field_58=" + field_58
				+ ", field_59=" + field_59 + ", field_60=" + field_60 + ", field_61=" + field_61 + ", field_62="
				+ field_62 + ", field_63=" + field_63 + ", field_64=" + field_64 + ", field_65=" + field_65
				+ ", field_66=" + field_66 + ", field_67=" + field_67 + ", field_68=" + field_68 + ", field_69="
				+ field_69 + ", field_70=" + field_70 + ", field_71=" + field_71 + ", field_72=" + field_72
				+ ", userName=" + userName + ", company=" + company + ", mobile=" + mobile + ", email=" + email
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
