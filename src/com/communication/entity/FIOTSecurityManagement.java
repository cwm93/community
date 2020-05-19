package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IOT Security Management 物联网行业卡安全管理
 */
@Entity
@Table(name = "zf_iot_security_management")
public class FIOTSecurityManagement implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID
	// 实名登记情况
	private Integer field_11;// 本月新增物联网行业卡
	private Integer field_12;// 累计发展物联网行业卡
	private Integer field_13;// 登记到责任单位和责任人
	private Integer field_14;// 登记到实际使用人
	private String field_15;// 物联网行业卡用户实名登记率
	// 按功能限制分类统计
	private Integer field_21;// 执行“功能最小化”业务限制
	private Integer field_22;// 短信和语音均默认关闭
	private Integer field_23;// 机卡关联绑定
	private Integer field_24;// 开通非定向语音-客户数
	private Integer field_242;// 开通非定向语音-号卡数
	private Integer field_25;// 开通非定向短信-客户数
	private Integer field_252;// 开通非定向短信-号卡数
	private Integer field_26;// 开通非定向上网流量-客户数
	private Integer field_262;// 开通非定向上网流量-号卡数
	// 按业务场景分类统计
	private Integer field_31;// 公共事业-客户数
	private Integer field_312;// 公共事业-号卡数
	private Integer field_32;// 零售服-客户数
	private Integer field_322;// 零售服-号卡数
	private Integer field_33;// 车联网-客户数
	private Integer field_332;// 车联网-号卡数
	private Integer field_34;// 能源管理-客户数
	private Integer field_342;// 能源管理-号卡数
	private Integer field_35;// 工业物联网-客户数
	private Integer field_352;// 工业物联网-号卡数
	private Integer field_36;// 其他场景-客户数
	private Integer field_362;// 其他场景-号卡数
	// 监测与管控
	private Integer field_41;// 合同回头看终止客户数
	private Integer field_42;// 本月使用流量大于100MB号卡数
	private Integer field_43;// 本月监测异常号卡数
	private Integer field_44;// 本月关停号卡数
	private Integer field_45;// 本年累计关停号卡数
	private Integer field_46;// 本年累计被通报违规号卡数
	private Integer field_47;// 本年累计处罚人员

	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "report_log_id")
	public long getReportLogId() {
		return reportLogId;
	}

	public void setReportLogId(long reportLogId) {
		this.reportLogId = reportLogId;
	}

	@Column(name = "insert_user_id")
	public long getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(long insertUserId) {
		this.insertUserId = insertUserId;
	}

	@Column(name = "telecom_operator_id")
	public long getTelecomOperatorId() {
		return telecomOperatorId;
	}

	public void setTelecomOperatorId(long telecomOperatorId) {
		this.telecomOperatorId = telecomOperatorId;
	}

	public Integer getField_11() {
		return field_11;
	}

	public void setField_11(Integer field_11) {
		this.field_11 = field_11;
	}

	public Integer getField_12() {
		return field_12;
	}

	public void setField_12(Integer field_12) {
		this.field_12 = field_12;
	}

	public Integer getField_13() {
		return field_13;
	}

	public void setField_13(Integer field_13) {
		this.field_13 = field_13;
	}

	public Integer getField_14() {
		return field_14;
	}

	public void setField_14(Integer field_14) {
		this.field_14 = field_14;
	}

	public String getField_15() {
		return field_15;
	}

	public void setField_15(String field_15) {
		this.field_15 = field_15;
	}

	public Integer getField_21() {
		return field_21;
	}

	public void setField_21(Integer field_21) {
		this.field_21 = field_21;
	}

	public Integer getField_22() {
		return field_22;
	}

	public void setField_22(Integer field_22) {
		this.field_22 = field_22;
	}

	public Integer getField_23() {
		return field_23;
	}

	public void setField_23(Integer field_23) {
		this.field_23 = field_23;
	}

	public Integer getField_24() {
		return field_24;
	}

	public void setField_24(Integer field_24) {
		this.field_24 = field_24;
	}

	public Integer getField_25() {
		return field_25;
	}

	public void setField_25(Integer field_25) {
		this.field_25 = field_25;
	}

	public Integer getField_26() {
		return field_26;
	}

	public void setField_26(Integer field_26) {
		this.field_26 = field_26;
	}

	public Integer getField_31() {
		return field_31;
	}

	public void setField_31(Integer field_31) {
		this.field_31 = field_31;
	}

	public Integer getField_32() {
		return field_32;
	}

	public void setField_32(Integer field_32) {
		this.field_32 = field_32;
	}

	public Integer getField_33() {
		return field_33;
	}

	public void setField_33(Integer field_33) {
		this.field_33 = field_33;
	}

	public Integer getField_34() {
		return field_34;
	}

	public void setField_34(Integer field_34) {
		this.field_34 = field_34;
	}

	public Integer getField_35() {
		return field_35;
	}

	public void setField_35(Integer field_35) {
		this.field_35 = field_35;
	}

	public Integer getField_36() {
		return field_36;
	}

	public void setField_36(Integer field_36) {
		this.field_36 = field_36;
	}

	public Integer getField_41() {
		return field_41;
	}

	public void setField_41(Integer field_41) {
		this.field_41 = field_41;
	}

	public Integer getField_42() {
		return field_42;
	}

	public void setField_42(Integer field_42) {
		this.field_42 = field_42;
	}

	public Integer getField_43() {
		return field_43;
	}

	public void setField_43(Integer field_43) {
		this.field_43 = field_43;
	}

	public Integer getField_44() {
		return field_44;
	}

	public void setField_44(Integer field_44) {
		this.field_44 = field_44;
	}

	public Integer getField_45() {
		return field_45;
	}

	public void setField_45(Integer field_45) {
		this.field_45 = field_45;
	}

	public Integer getField_46() {
		return field_46;
	}

	public void setField_46(Integer field_46) {
		this.field_46 = field_46;
	}

	public Integer getField_47() {
		return field_47;
	}

	public void setField_47(Integer field_47) {
		this.field_47 = field_47;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "insert_time")
	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	@Column(name = "update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getField_242() {
		return field_242;
	}

	public void setField_242(Integer field_242) {
		this.field_242 = field_242;
	}

	public Integer getField_252() {
		return field_252;
	}

	public void setField_252(Integer field_252) {
		this.field_252 = field_252;
	}

	public Integer getField_262() {
		return field_262;
	}

	public void setField_262(Integer field_262) {
		this.field_262 = field_262;
	}

	public Integer getField_312() {
		return field_312;
	}

	public void setField_312(Integer field_312) {
		this.field_312 = field_312;
	}

	public Integer getField_322() {
		return field_322;
	}

	public void setField_322(Integer field_322) {
		this.field_322 = field_322;
	}

	public Integer getField_332() {
		return field_332;
	}

	public void setField_332(Integer field_332) {
		this.field_332 = field_332;
	}

	public Integer getField_342() {
		return field_342;
	}

	public void setField_342(Integer field_342) {
		this.field_342 = field_342;
	}

	public Integer getField_352() {
		return field_352;
	}

	public void setField_352(Integer field_352) {
		this.field_352 = field_352;
	}

	public Integer getField_362() {
		return field_362;
	}

	public void setField_362(Integer field_362) {
		this.field_362 = field_362;
	}

	@Override
	public String toString() {
		return "FIOTSecurityManagement [id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
				+ ", telecomOperatorId=" + telecomOperatorId + ", field_11=" + field_11 + ", field_12=" + field_12
				+ ", field_13=" + field_13 + ", field_14=" + field_14 + ", field_15=" + field_15 + ", field_21="
				+ field_21 + ", field_22=" + field_22 + ", field_23=" + field_23 + ", field_24=" + field_24
				+ ", field_242=" + field_242 + ", field_25=" + field_25 + ", field_252=" + field_252 + ", field_26="
				+ field_26 + ", field_262=" + field_262 + ", field_31=" + field_31 + ", field_312=" + field_312
				+ ", field_32=" + field_32 + ", field_322=" + field_322 + ", field_33=" + field_33 + ", field_332="
				+ field_332 + ", field_34=" + field_34 + ", field_342=" + field_342 + ", field_35=" + field_35
				+ ", field_352=" + field_352 + ", field_36=" + field_36 + ", field_362=" + field_362 + ", field_41="
				+ field_41 + ", field_42=" + field_42 + ", field_43=" + field_43 + ", field_44=" + field_44
				+ ", field_45=" + field_45 + ", field_46=" + field_46 + ", field_47=" + field_47 + ", userName="
				+ userName + ", company=" + company + ", mobile=" + mobile + ", email=" + email + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + "]";
	}

}
