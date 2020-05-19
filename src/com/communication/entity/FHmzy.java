/**
 * 
 */
package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liliang
 *
 */
public class FHmzy implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;// 表格对应的记录的ID
	private String code;// 局号
	private String zoneCode;// 区号
	private int logicUsegeNumber;// 逻辑号码在用数量
	private int physicsAssignedNumber;// 物理号码已分配个数
	private int occupiedNumber;// 占用数量
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID
	private String isPHS;// 是否是PHS，默认不是
	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	public FHmzy() {
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public int getLogicUsegeNumber() {
		return logicUsegeNumber;
	}

	public void setLogicUsegeNumber(int logicUsegeNumber) {
		this.logicUsegeNumber = logicUsegeNumber;
	}

	public int getPhysicsAssignedNumber() {
		return physicsAssignedNumber;
	}

	public void setPhysicsAssignedNumber(int physicsAssignedNumber) {
		this.physicsAssignedNumber = physicsAssignedNumber;
	}

	public int getOccupiedNumber() {
		return occupiedNumber;
	}

	public void setOccupiedNumber(int occupiedNumber) {
		this.occupiedNumber = occupiedNumber;
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

	public String getIsPHS() {
		return isPHS;
	}

	public void setIsPHS(String isPHS) {
		this.isPHS = isPHS;
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
		return "FHmzy {id=" + id + ", reportLogId=" + reportLogId + ", code=" + code + ", zoneCode=" + zoneCode
				+ ", logicUsegeNumber=" + logicUsegeNumber + ", physicsAssignedNumber=" + physicsAssignedNumber
				+ ", occupiedNumber=" + occupiedNumber + ", insertUserId=" + insertUserId + ", telecomOperatorId="
				+ telecomOperatorId + ", isPHS=" + isPHS + ", userName=" + userName + ", company=" + company
				+ ", mobile=" + mobile + ", email=" + email + ", insertTime=" + insertTime + ", updateTime="
				+ updateTime + "}";
	}

}
