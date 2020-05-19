package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @基础电信企业家庭用户宽带资费汇总
 */
public class FHouseholdBroadbandTariff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID

	// 其中：融合套餐包含的国内分钟数（分钟/月）
	private String field_01;
	private String field_02;
	private String field_03;
	private String field_2001;// 200M
	private String field_5001;
	private String field_10241;// 1G类目
	// 单宽带套餐资费（优惠价格）（元/一年）
	private String field_04;
	private String field_05;
	private String field_06;
	private String field_2002;// 200M
	private String field_5002;
	private String field_10242;// 1G类目
	// 融合套餐价格（元/月）
	private String field_07;// 200M 07 10 13
	private String field_08;
	private String field_09;
	private String field_2003;
	private String field_5003;
	private String field_10243;// 1G类目

	// 其中：融合套餐包含的国内分钟数（分钟/月）
	private String field_10;
	private String field_11;
	private String field_12;
	private String field_2004;
	private String field_5004;
	private String field_10244;// 1G类目
	// 其中：融合套餐包含的国内流量（M/月）
	private String field_13;
	private String field_14;
	private String field_15;
	private String field_2005;
	private String field_5005;
	private String field_10245;// 1G类目
	// 其中：融合套餐包含的优惠
	private String field_16;
	// 用户数（万户）
	private String field_17;
	private String field_18;
	private String field_19;
	private String field_2006;
	private String field_5006;
	private String field_10246;// 1G类目
	// 用户占比（%）（用户数/总家庭用户数）
	private String field_20;
	private String field_21;
	private String field_22;
	private String field_2007;
	private String field_5007;
	private String field_10247;// 1G类目
	// 总家庭用户数（万户）
	private String field_23;
	// 总用户数（万户）（包含家庭用户、集客用户）
	private String field_24;
	// 当月开账收入（万元）
	private String field_25;
	private String field_26;
	private String field_27;
	private String field_2008;
	private String field_5008;
	private String field_10248;// 1G类目
	// 销售收入占比（%）
	private String field_28;
	private String field_29;
	private String field_30;
	private String field_2009;
	private String field_5009;
	private String field_10249;// 1G类目
	// 平均带宽
	private String field_31;
	// 千兆用户数
	private String field_32;
	// 降价计划
	private String field_33;
	// 降价后对收入的影响（预期）
	private String field_34;
	// 单宽带套餐资费（北京地区标准资费）（元/一年）
	private String field_35;
	private String field_36;
	private String field_37;
	private String field_20010;
	private String field_50010;
	private String field_102410;// 1G类目
	// 单宽带套餐资费（北京地区优惠价格）（元/一年）
	private String field_38;
	private String field_39;
	private String field_40;
	private String field_20011;
	private String field_50011;
	private String field_102411;// 1G类目
	// 百兆以上用户占比（%）（注：19年百兆以上用户占比达80%）
	private String field_41;// 2018年12月底占比（%）
	private String field_42;// 目前占比（%）

	// 填表人相关信息
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

	public String getField_2001() {
		return field_2001;
	}

	public void setField_2001(String field_2001) {
		this.field_2001 = field_2001;
	}

	public String getField_5001() {
		return field_5001;
	}

	public void setField_5001(String field_5001) {
		this.field_5001 = field_5001;
	}

	public String getField_10241() {
		return field_10241;
	}

	public void setField_10241(String field_10241) {
		this.field_10241 = field_10241;
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

	public String getField_2002() {
		return field_2002;
	}

	public void setField_2002(String field_2002) {
		this.field_2002 = field_2002;
	}

	public String getField_5002() {
		return field_5002;
	}

	public void setField_5002(String field_5002) {
		this.field_5002 = field_5002;
	}

	public String getField_10242() {
		return field_10242;
	}

	public void setField_10242(String field_10242) {
		this.field_10242 = field_10242;
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

	public String getField_2003() {
		return field_2003;
	}

	public void setField_2003(String field_2003) {
		this.field_2003 = field_2003;
	}

	public String getField_5003() {
		return field_5003;
	}

	public void setField_5003(String field_5003) {
		this.field_5003 = field_5003;
	}

	public String getField_10243() {
		return field_10243;
	}

	public void setField_10243(String field_10243) {
		this.field_10243 = field_10243;
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

	public String getField_2004() {
		return field_2004;
	}

	public void setField_2004(String field_2004) {
		this.field_2004 = field_2004;
	}

	public String getField_5004() {
		return field_5004;
	}

	public void setField_5004(String field_5004) {
		this.field_5004 = field_5004;
	}

	public String getField_10244() {
		return field_10244;
	}

	public void setField_10244(String field_10244) {
		this.field_10244 = field_10244;
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

	public String getField_2005() {
		return field_2005;
	}

	public void setField_2005(String field_2005) {
		this.field_2005 = field_2005;
	}

	public String getField_5005() {
		return field_5005;
	}

	public void setField_5005(String field_5005) {
		this.field_5005 = field_5005;
	}

	public String getField_10245() {
		return field_10245;
	}

	public void setField_10245(String field_10245) {
		this.field_10245 = field_10245;
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

	public String getField_2006() {
		return field_2006;
	}

	public void setField_2006(String field_2006) {
		this.field_2006 = field_2006;
	}

	public String getField_5006() {
		return field_5006;
	}

	public void setField_5006(String field_5006) {
		this.field_5006 = field_5006;
	}

	public String getField_10246() {
		return field_10246;
	}

	public void setField_10246(String field_10246) {
		this.field_10246 = field_10246;
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

	public String getField_2007() {
		return field_2007;
	}

	public void setField_2007(String field_2007) {
		this.field_2007 = field_2007;
	}

	public String getField_5007() {
		return field_5007;
	}

	public void setField_5007(String field_5007) {
		this.field_5007 = field_5007;
	}

	public String getField_10247() {
		return field_10247;
	}

	public void setField_10247(String field_10247) {
		this.field_10247 = field_10247;
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

	public String getField_2008() {
		return field_2008;
	}

	public void setField_2008(String field_2008) {
		this.field_2008 = field_2008;
	}

	public String getField_5008() {
		return field_5008;
	}

	public void setField_5008(String field_5008) {
		this.field_5008 = field_5008;
	}

	public String getField_10248() {
		return field_10248;
	}

	public void setField_10248(String field_10248) {
		this.field_10248 = field_10248;
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

	public String getField_2009() {
		return field_2009;
	}

	public void setField_2009(String field_2009) {
		this.field_2009 = field_2009;
	}

	public String getField_5009() {
		return field_5009;
	}

	public void setField_5009(String field_5009) {
		this.field_5009 = field_5009;
	}

	public String getField_10249() {
		return field_10249;
	}

	public void setField_10249(String field_10249) {
		this.field_10249 = field_10249;
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

	public String getField_20010() {
		return field_20010;
	}

	public void setField_20010(String field_20010) {
		this.field_20010 = field_20010;
	}

	public String getField_50010() {
		return field_50010;
	}

	public void setField_50010(String field_50010) {
		this.field_50010 = field_50010;
	}

	public String getField_102410() {
		return field_102410;
	}

	public void setField_102410(String field_102410) {
		this.field_102410 = field_102410;
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

	public String getField_20011() {
		return field_20011;
	}

	public void setField_20011(String field_20011) {
		this.field_20011 = field_20011;
	}

	public String getField_50011() {
		return field_50011;
	}

	public void setField_50011(String field_50011) {
		this.field_50011 = field_50011;
	}

	public String getField_102411() {
		return field_102411;
	}

	public void setField_102411(String field_102411) {
		this.field_102411 = field_102411;
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

}
