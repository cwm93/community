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
 * 有效申诉量统计情况
 **/
@Entity
@Table(name = "zf_effective_appeal_amount")
public class FEffectiveAppealAmount implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID

	private Integer field_01;// 受理总量
	private Integer field_02;// 有效申诉量
	private Integer field_03;// 剔除总数
	/**
	 * 不符合工信部35号令第十条属于无效投诉的
	 **/
	private Integer field_04;// （一）申诉人是与申诉事项有直接利害关系的当事人
	private Integer field_05;// （二）有明确的被申诉人
	private Integer field_06;// （三）有具体的申诉请求和事实根据
	private Integer field_07;// （四）已经向被申诉人投诉且对其处理结果不满意或者其未在15日内答
	/**
	 * 属于工信部35号令第十一条情况不予受理的
	 **/
	private Integer field_08;// （一）属于收费争议的申诉，申诉事项发生时距提起申诉时超过五个月的，其他申诉，申诉事项发生时距提起申诉时超过二年的；
	private Integer field_09;// （二）申诉人与被申诉人已经达成和解协议并执行的；
	private Integer field_10;// （三）申诉受理机构已经受理或者处理的；
	private Integer field_11;// （四）人民法院、仲裁机构、消费者组织或者其他行政机关已经受理或者处理的；
	private Integer field_12;// （六）国家法律、行政法规及部门规章另有规定的。
	/**
	 * 不符合工信部35号令第十二条缺少以下内容的
	 **/
	private Integer field_13;// （一）申诉人姓名或名称、地址、电话号码、邮政编码；二）被申诉人名称、地址；（三）申诉要求、理由、事实根据；（四）申诉日期。
	
	private String comment;
	/**
	 * 填表人相关信息
	 **/
	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Column(name = "field_01")
	public Integer getField_01() {
		return field_01;
	}

	public void setField_01(Integer field_01) {
		this.field_01 = field_01;
	}

	@Column(name = "field_02")
	public Integer getField_02() {
		return field_02;
	}

	public void setField_02(Integer field_02) {
		this.field_02 = field_02;
	}

	@Column(name = "field_03")
	public Integer getField_03() {
		return field_03;
	}

	public void setField_03(Integer field_03) {
		this.field_03 = field_03;
	}

	@Column(name = "field_04")
	public Integer getField_04() {
		return field_04;
	}

	public void setField_04(Integer field_04) {
		this.field_04 = field_04;
	}

	@Column(name = "field_05")
	public Integer getField_05() {
		return field_05;
	}

	public void setField_05(Integer field_05) {
		this.field_05 = field_05;
	}

	@Column(name = "field_06")
	public Integer getField_06() {
		return field_06;
	}

	public void setField_06(Integer field_06) {
		this.field_06 = field_06;
	}

	@Column(name = "field_07")
	public Integer getField_07() {
		return field_07;
	}

	public void setField_07(Integer field_07) {
		this.field_07 = field_07;
	}

	@Column(name = "field_08")
	public Integer getField_08() {
		return field_08;
	}

	public void setField_08(Integer field_08) {
		this.field_08 = field_08;
	}

	@Column(name = "field_09")
	public Integer getField_09() {
		return field_09;
	}

	public void setField_09(Integer field_09) {
		this.field_09 = field_09;
	}

	@Column(name = "field_10")
	public Integer getField_10() {
		return field_10;
	}

	public void setField_10(Integer field_10) {
		this.field_10 = field_10;
	}

	@Column(name = "field_11")
	public Integer getField_11() {
		return field_11;
	}

	public void setField_11(Integer field_11) {
		this.field_11 = field_11;
	}

	@Column(name = "field_12")
	public Integer getField_12() {
		return field_12;
	}

	public void setField_12(Integer field_12) {
		this.field_12 = field_12;
	}

	@Column(name = "field_13")
	public Integer getField_13() {
		return field_13;
	}

	public void setField_13(Integer field_13) {
		this.field_13 = field_13;
	}
	
	@Column(name = "comment",length=1000)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Override
	public String toString() {
		return "FEffectiveAppealAmount [id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
				+ ", telecomOperatorId=" + telecomOperatorId + ", field_01=" + field_01 + ", field_02=" + field_02
				+ ", field_03=" + field_03 + ", field_04=" + field_04 + ", field_05=" + field_05 + ", field_06="
				+ field_06 + ", field_07=" + field_07 + ", field_08=" + field_08 + ", field_09=" + field_09
				+ ", field_10=" + field_10 + ", field_11=" + field_11 + ", field_12=" + field_12 + ", field_13="
				+ field_13 + ", userName=" + userName + ", company=" + company + ", mobile=" + mobile + ", email="
				+ email + ", insertTime=" + insertTime + ", updateTime=" + updateTime + "]";
	}

}
