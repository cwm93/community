/**
 * 
 */
package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liliang
 * @物联网号码段分配使用情况
 */
public class FWlwhd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID

	private String hd;// 号码段
	private String ws;// 位数
	private String hdmx;// 号段明细
	private int ysmdjs;// 已实名登记数（万）
	private int wsmdjs;// 未实名登记数（万）
	private int wsys;// 未使用数（万）

	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	public FWlwhd() {
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

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getWs() {
		return ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	public String getHdmx() {
		return hdmx;
	}

	public void setHdmx(String hdmx) {
		this.hdmx = hdmx;
	}

	public int getYsmdjs() {
		return ysmdjs;
	}

	public void setYsmdjs(int ysmdjs) {
		this.ysmdjs = ysmdjs;
	}

	public int getWsmdjs() {
		return wsmdjs;
	}

	public void setWsmdjs(int wsmdjs) {
		this.wsmdjs = wsmdjs;
	}

	public int getWsys() {
		return wsys;
	}

	public void setWsys(int wsys) {
		this.wsys = wsys;
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
		return "FWlwhd {id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
				+ ", telecomOperatorId=" + telecomOperatorId + ", hd=" + hd + ", ws=" + ws + ", hdmx=" + hdmx
				+ ", ysmdjs=" + ysmdjs + ", wsmdjs=" + wsmdjs + ", wsys=" + wsys + ", userName=" + userName
				+ ", company=" + company + ", mobile=" + mobile + ", email=" + email + ", insertTime=" + insertTime
				+ ", updateTime=" + updateTime + "}";
	}

}
