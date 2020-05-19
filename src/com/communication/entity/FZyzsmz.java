/**
 * 
 */
package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator 电话实名制志愿者监督检查情况
 */
public class FZyzsmz implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID

	private int jcdxmds;// 基础电信企业门店数
	private int jcdxmdhgs;// 基础电信企业门店检查数（合规数）

	private int zsqymdjcs;// 转售企业门店数检查数
	private int zsqymdshg;// 转售企业门店数（合规数）
	private int zsqymdswg;// 转售企业门店数（违规）
	private int checkNumber;// 检查人次
	private String zsqydlwdhgl;// 转售企业代理网点合规率
	private String comment;// 备注

	/******* 填表人相关信息 ********/
	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date createTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	public FZyzsmz() {

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

	public int getJcdxmds() {
		return jcdxmds;
	}

	public void setJcdxmds(int jcdxmds) {
		this.jcdxmds = jcdxmds;
	}

	public int getJcdxmdhgs() {
		return jcdxmdhgs;
	}

	public void setJcdxmdhgs(int jcdxmdhgs) {
		this.jcdxmdhgs = jcdxmdhgs;
	}

	public int getZsqymdjcs() {
		return zsqymdjcs;
	}

	public void setZsqymdjcs(int zsqymdjcs) {
		this.zsqymdjcs = zsqymdjcs;
	}

	public int getZsqymdshg() {
		return zsqymdshg;
	}

	public void setZsqymdshg(int zsqymdshg) {
		this.zsqymdshg = zsqymdshg;
	}

	public int getZsqymdswg() {
		return zsqymdswg;
	}

	public void setZsqymdswg(int zsqymdswg) {
		this.zsqymdswg = zsqymdswg;
	}

	public int getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getZsqydlwdhgl() {
		return zsqydlwdhgl;
	}

	public void setZsqydlwdhgl(String zsqydlwdhgl) {
		this.zsqydlwdhgl = zsqydlwdhgl;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FZyzsmz [id=" + id + ", reportLogId=" + reportLogId + ", insertUserId=" + insertUserId
				+ ", telecomOperatorId=" + telecomOperatorId + ", jcdxmds=" + jcdxmds + ", jcdxmdhgs=" + jcdxmdhgs
				+ ", zsqymdjcs=" + zsqymdjcs + ", zsqymdshg=" + zsqymdshg + ", zsqymdswg=" + zsqymdswg
				+ ", checkNumber=" + checkNumber + ", zsqydlwdhgl=" + zsqydlwdhgl + ", comment=" + comment
				+ ", userName=" + userName + ", company=" + company + ", mobile=" + mobile + ", email=" + email
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
