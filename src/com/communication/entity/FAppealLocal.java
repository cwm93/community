package com.communication.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 本地投诉情况
 */
@Entity
@Table(name = "zf_appeal_local")
public class FAppealLocal implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 基本信息
	 **/
	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID
	/**
	 * 一、本地投诉总体情况
	 **/
	private Integer field_11;// 本月投诉量
	private Integer field_12;// 上月投诉量
	private Float field_13;// 环比%
	private Integer field_14;// 上一年度同月投诉量
	private Float field_15;// 同比% 两位小数
	private String field_16;// 备注
	/**
	 * 二、投诉热点问题TOP10
	 **/
	private List<FAppealLocalTopTen> appealLocalTopTenList = new ArrayList<FAppealLocalTopTen>(10);
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

	@Column(name = "field_01")
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
	public Float getField_13() {
		return field_13;
	}

	public void setField_13(Float field_13) {
		this.field_13 = field_13;
	}

	@Column(name = "field_14")
	public Integer getField_14() {
		return field_14;
	}

	public void setField_14(Integer field_14) {
		this.field_14 = field_14;
	}

	@Column(name = "field_15")
	public Float getField_15() {
		return field_15;
	}

	public void setField_15(Float field_15) {
		this.field_15 = field_15;
	}

	@Column(name = "field_16",length=1000)
	public String getField_16() {
		return field_16;
	}

	public void setField_16(String field_16) {
		this.field_16 = field_16;
	}

	@OneToMany(targetEntity=FAppealLocalTopTen.class,cascade=CascadeType.ALL)  
	@Fetch(FetchMode.JOIN)   
	@JoinColumn(name="appeal_local_id")
	@OrderBy("id ASC")
	public List<FAppealLocalTopTen> getAppealLocalTopTenList() {
		return appealLocalTopTenList;
	}

	public void setAppealLocalTopTenList(List<FAppealLocalTopTen> appealLocalTopTenList) {
		this.appealLocalTopTenList = appealLocalTopTenList;
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
		return "FAppealLocal [id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
				+ ", telecomOperatorId=" + telecomOperatorId + ", field_11=" + field_11 + ", field_12=" + field_12
				+ ", field_13=" + field_13 + ", field_14=" + field_14 + ", field_15=" + field_15 + ", field_16="
				+ field_16 + ", appealLocalTopTenList=" + appealLocalTopTenList + ", userName=" + userName
				+ ", company=" + company + ", mobile=" + mobile + ", email=" + email + ", insertTime=" + insertTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
}
