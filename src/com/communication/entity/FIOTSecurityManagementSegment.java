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
 * IOT Security Management 物联网行业卡安全管理 按号段分类统计（全量统计，含未定向分配号段数）
 */
@Entity
@Table(name = "zf_iot_segment_assign")
public class FIOTSecurityManagementSegment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID
	
	private String type;// 专用、公众号段
	private String digitType;// 11、13位号段
	private String hdmx;// 号段明细
	private Integer amount;//总数（个）
	private Integer usedAmount;//已使用数（个）
	private Integer unusedAmount;//未使用数（个）
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDigitType() {
		return digitType;
	}

	public void setDigitType(String digitType) {
		this.digitType = digitType;
	}

	public String getHdmx() {
		return hdmx;
	}

	public void setHdmx(String hdmx) {
		this.hdmx = hdmx;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(Integer usedAmount) {
		this.usedAmount = usedAmount;
	}

	public Integer getUnusedAmount() {
		return unusedAmount;
	}

	public void setUnusedAmount(Integer unusedAmount) {
		this.unusedAmount = unusedAmount;
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

}
