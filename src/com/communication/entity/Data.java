package com.communication.entity;

import java.io.Serializable;

public class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int CODE_SUCCESS = 0;
	public static int CODE_FALLURED = -1;

	private int code;// 处理状态：0：成功
	private String message;
	
	private String url;
	private String urlTitle;

	public Data(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Data(int code, String message,String url,String urlTitle) {
		this.code = code;
		this.message = message;
		this.url = url;
		this.urlTitle = urlTitle;
	}

	/**
	 * 处理成功,并返回数据
	 * 
	 * @param data
	 *            数据对象
	 * @return data
	 */
	public static final Data success(String message) {
		return new Data(CODE_SUCCESS, message);
	}
	
	
	/**
	 * 处理成功,并返回数据
	 * 
	 * @param data
	 *            数据对象
	 * @return data
	 */
	public static final Data success(String message,String url,String urlTitle) {
		return new Data(CODE_SUCCESS, message,url,urlTitle);
	}

	/**
	 * 处理失败,并返回数据
	 * 
	 * @param message
	 *            消息
	 * @return data
	 */
	public static final Data failure(String message) {
		return new Data(CODE_FALLURED, message);
	}
	
	/**
	 * 处理失败,并返回数据
	 * 
	 * @param message
	 *            消息
	 * @return data
	 */
	public static final Data failure(String message,String url,String urlTitle) {
		return new Data(CODE_FALLURED, message,url,urlTitle);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlTitle() {
		return urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}

	@Override
	public String toString() {
		return "Data {code=" + code + ", message=" + message + "}";
	}

}
