package com.communication.entity;

import java.io.Serializable;

public class TelecomOperator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String comment;

	public TelecomOperator() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "TelecomOperator [id=" + id + ", name=" + name + ", comment=" + comment + "]";
	}

}
