package com.communication.entity;

import java.io.Serializable;

public class ReportKind implements Serializable {

	/**
	 * 报表种类：周报；日报；年报；月报
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String comment;
	
	public ReportKind() {
		
	}

	public ReportKind(int id, String name, String comment) {
		this.id = id;
		this.name = name;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "ReportKind [id=" + id + ", name=" + name + ", comment=" + comment + "]";
	}


}
