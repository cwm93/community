package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @基础电信运营商电话用户真实身份信息登记数据统计表
 */
public class FPhoneUserRealIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID

	// 总用户数
	// 移动电话用户（万）（含无线上网卡用户）
	private String field_01;// 截至本月末
	private String field_02;// 本月新增
	// 固定电话用户（万）（含无线市话用户）
	private String field_03;// 截至本月末
	private String field_04;// 本月新增
	// 所有电话用户（万）
	private String field_05;// 截至本月末
	private String field_06;// 本月新增
	// 已登记实名制用户数
	private String field_07;
	private String field_08;
	private String field_09;
	private String field_10;
	private String field_11;
	private String field_12;
	// 实名率
	private String field_13;
	private String field_14;
	private String field_15;
	private String field_16;
	private String field_17;
	private String field_18;
	// 补登记实名制用户数
	private String field_19;
	private String field_20;
	private String field_21;
	private String field_22;
	private String field_23;
	private String field_24;
	// 环比增加率
	private String field_25;
	private String field_26;
	private String field_27;
	// 后付费用户数
	private String field_28;
	private String field_29;
	private String field_30;
	private String field_31;
	private String field_32;
	private String field_33;
	// 预付费用户数
	private String field_34;
	private String field_35;
	private String field_36;
	private String field_37;
	private String field_38;
	private String field_39;
	// 自营厅
	private String field_40;// 总数
	private String field_41;// 本月发展新用户占比
	// 合作厅/专营店
	private String field_42;// 总数
	// 代理点
	private String field_43;// 总数
	private String field_44;// 用户真实身份信息登记代理点数
	// 电商平台
	private String field_45;// 授权数
	private String field_46;// 清理未授权数

	private String field_47;// 实名登记APP终端数
	private String field_48;// 已禁止实名登记人工录入终端数
	private String field_49;// 实名登记自动录入终端数
	private String field_50;// 二代身份证识别仪数
	private String field_51;// 二代身份证识别设备网点数
	// 行业应用无线上网卡
	private String field_52;// 单位数
	private String field_53;// 已登记数
	private String field_54;// 卡数
	private String field_55;// 未登记数
	// 集团用户电话卡（含无线上网卡）
	private String field_56;// 单位数
	private String field_57;// 已登记数
	private String field_58;// 卡数
	private String field_59;// 未登记数
	// 同一身份证件登记5张以上移动电话卡
	private String field_60;// 卡数
	private String field_61;// 用户数
	private String field_62;// 已核查
	private String field_63;// 已完成补登记数
	// 漫游至新疆和西藏超过2个月的用户
	private String field_64;// 卡数
	private String field_65;// 用户数
	private String field_66;// 已核查
	private String field_67;// 已完成补登记数
	private String field_68;// 社会渠道授权牌应配发总数
	private String field_69;// 本月新增
	private String field_70;// 社会渠道授权牌未配发总数
	private String field_71;// 本月终止违规代理商数
	private String field_72;// 上报黑名单数

	// 新增字段
	private String field_73;// 代理点售卡数
	private String field_74;// 照片稽核合规率

	private String field_75;// 售卡数小计
	private String field_76;// 售卡拍照核验数小计
	private String field_77;// 售卡拍照核验通过数小计
	private String field_78;// 售卡拍照核验合规率（%）

	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date createTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	public FPhoneUserRealIdentity() {
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

	public String getField_73() {
		return field_73;
	}

	public void setField_73(String field_73) {
		this.field_73 = field_73;
	}

	public String getField_74() {
		return field_74;
	}

	public void setField_74(String field_74) {
		this.field_74 = field_74;
	}

	public String getField_75() {
		return field_75;
	}

	public void setField_75(String field_75) {
		this.field_75 = field_75;
	}

	public String getField_76() {
		return field_76;
	}

	public void setField_76(String field_76) {
		this.field_76 = field_76;
	}

	public String getField_77() {
		return field_77;
	}

	public void setField_77(String field_77) {
		this.field_77 = field_77;
	}

	public String getField_78() {
		return field_78;
	}

	public void setField_78(String field_78) {
		this.field_78 = field_78;
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
		return "FPhoneUserRealIdentity [id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
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
				+ ", field_73=" + field_73 + ", field_74=" + field_74 + ", field_75=" + field_75 + ", field_76="
				+ field_76 + ", field_77=" + field_77 + ", field_78=" + field_78 + ", userName=" + userName
				+ ", company=" + company + ", mobile=" + mobile + ", email=" + email + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}
