package com.communication.entity;

import java.io.Serializable;

public class ReportType implements Serializable {

	/**
	 * 报表分类：号码管理/资费管理
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String comment;

	public ReportType() {

	}

	public ReportType(int id, String name, String comment) {
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
		return "ReportType [id=" + id + ", name=" + name + ", comment=" + comment + "]";
	}

}
