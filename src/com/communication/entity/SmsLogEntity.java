package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 短消息发送记录
 */
public class SmsLogEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String content;//执行的内容
	private String status;//执行结果状态1:success；-1:failure；0:未执行
	private Integer pieces;//成功时发送短信的条数
	private Date insertTime;//
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPieces() {
		return pieces;
	}

	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
