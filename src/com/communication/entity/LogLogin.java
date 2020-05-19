package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liliang
 *
 */
public class LogLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long userId;
	private String ip;
	private Integer result;
	private String message;
	private Date createTime;

	public LogLogin() {

	}

	public LogLogin(Long userId, String ip, Integer result, String message, Date createTime) {
		this.userId = userId;
		this.ip = ip;
		this.result = result;
		this.message = message;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer isResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "LogLogin [id=" + id + ", userId=" + userId + ", ip=" + ip + ", result=" + result + ", message="
				+ message + ", createTime=" + createTime + "]";
	}

}
