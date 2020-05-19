package com.communication.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *中国网建短信通开放的短信平台 
 */
public class SMSUtil {
	private static final Logger logger = LoggerFactory.getLogger(SMSUtil.class);
	private static final String Uid = "shcagov";
	private static final String Key = "49ab902a79d41993b8e7";
	private static final String Get_Sms_Number_Url = "http://www.smschinese.cn/web_api/SMS/?Action=SMS_Num&Uid=shcagov&Key=49ab902a79d41993b8e7";
	
	/**
	 * 发送普通业务短信
	 **/
	public static int sendSms(String mobiles,String content) {
		HttpClientUtil httpClient = HttpClientUtil.getInstance();
		int errorCode = 0;
		try {
			errorCode = httpClient.sendMsgUtf8(Uid, Key, content, mobiles);
			logger.info("sms has been sent success");
		}catch(Exception e) {
			logger.info("sms has been sent failed");
			e.printStackTrace();
			errorCode = 0;
		}
		return errorCode;
	}
	
	/**
	 * 获取短消息数量
	 **/
	public static int getSmsNumber() {
		HttpClientUtil httpClient = HttpClientUtil.getInstance();
		int number = -1;
		try {
			number = Integer.valueOf(httpClient.sendHttpGet(Get_Sms_Number_Url));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public static void main(String[] args) {
		System.out.println(SMSUtil.getSmsNumber());
	}
	
}
