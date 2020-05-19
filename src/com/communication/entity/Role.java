package com.communication.entity;

import java.io.Serializable;

public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String code;
	private String comment;
	
	public Role(){
		
	}

	public Role(int id, String name, String code, String comment) {
		this.id = id;
		this.name = name;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", code=" + code + ", comment=" + comment + "]";
	}

}
