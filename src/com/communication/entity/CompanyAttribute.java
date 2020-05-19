package com.communication.entity;

import java.io.Serializable;
/**
 * 单位属性
 */
public class CompanyAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String comment;
	
	public CompanyAttribute() {

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
		return "CompanyAttribute [id=" + id + ", name=" + name + ", comment=" + comment + "]";
	}
}
