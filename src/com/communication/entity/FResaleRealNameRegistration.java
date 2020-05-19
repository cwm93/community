/**
 * 
 */
package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * 上海地区转售企业月度自查表
 *
 */
public class FResaleRealNameRegistration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID
	//
	private String field_01;
	private String field_02;
	//1.1上海地区公司负责人
	private String field_03;
	private String field_04;
	private String field_05;
	//1.2上海地区实名制负责人
	private String field_06;
	private String field_07;
	private String field_08;
	//1.3上海地区实名制违规行为举报渠道
	private String field_09;
	private String field_10;
	//2、上海地区转售业务经营和财务状况
	private String field_11;//2.1.1上海地区本年度累计上月月底仍在网的移动电话用户数量（户）
	private String field_12;//2.1.2上海地区本年度累计上月月底仍在网的单位用户数量（户）
	private String field_13;//2.1.3上海地区本年度累计上月月底仍在网的行业应用上网卡数量（户）
	private String field_14;//2.1.4上海地区上一月新增补登记数量（户）
	private String field_15;//2.1.5上海地区本年度累计上月月底补登记数量（户
	private String field_16;//2.2.1上海地区本年度累计上月月底移动转售业务收入（万元）
	//3、社会渠道网点信息和二代证识别设备配备情况（截止统计日）
	private String field_17;//3.1.1上海地区社会渠道签约数量（实体代理店数）
	private String field_18;//3.1.2上海地区社会渠道签约数量（网络代理店数）
	private String field_19;//3.1.3上海地区社会渠道统一配发授权牌数量（张）
	private String field_20;//3.1.4上海地区网络销售渠道售卡是否执行二次认证规范（是/否）
	private String field_21;//3.2.1二上海地区二代证识别设备铺设情况（已配备台数）
	private String field_22;//3.2.2其他身份核验手段（请文字说明）
	//4、实体渠道二代证识别设备配备情况
	private String field_23;//4.1.1仅受理居民身份证件（是/否）
	private String field_24;//4.1.2未配备二代证识别设备的社会营销网点不得违规办理（是/否）
	private String field_25;//4.1.3用户登记信息是否主动做好人证一致性核验（是/否）
	private String field_26;//4.1.4本年度累计上月月底网络售卡代理清理数量（家）
	private String field_27;//4.2.1上一月检查次数
	private String field_28;//4.2.2本年度累计上月月底自查次数
	private String field_29;//4.2.3本年度累计上月月底处罚和取消代理网点数
	private String field_30;//4.2.4本年度累计上月月底处罚人员数
	
	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date createTime;// 插入时间
	private Date updateTime;// 最后一次更改时间
	public FResaleRealNameRegistration() {
	
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
		return "FResaleRealNameRegistration {id=" + id + ", reportLogId=" + reportLogId + ", insertUserId="
				+ insertUserId + ", telecomOperatorId=" + telecomOperatorId + ", field_01=" + field_01 + ", field_02="
				+ field_02 + ", field_03=" + field_03 + ", field_04=" + field_04 + ", field_05=" + field_05
				+ ", field_06=" + field_06 + ", field_07=" + field_07 + ", field_08=" + field_08 + ", field_09="
				+ field_09 + ", field_10=" + field_10 + ", field_11=" + field_11 + ", field_12=" + field_12
				+ ", field_13=" + field_13 + ", field_14=" + field_14 + ", field_15=" + field_15 + ", field_16="
				+ field_16 + ", field_17=" + field_17 + ", field_18=" + field_18 + ", field_19=" + field_19
				+ ", field_20=" + field_20 + ", field_21=" + field_21 + ", field_22=" + field_22 + ", field_23="
				+ field_23 + ", field_24=" + field_24 + ", field_25=" + field_25 + ", field_26=" + field_26
				+ ", field_27=" + field_27 + ", field_28=" + field_28 + ", field_29=" + field_29 + ", field_30="
				+ field_30 + ", userName=" + userName + ", company=" + company + ", mobile=" + mobile + ", email="
				+ email + ", createTime=" + createTime + ", updateTime=" + updateTime + "}";
	}
	

}
