package com.communication.util;

public class Constants {
	public final static String WinPath="C:\\audit";
	public final static String LinuxPath="/home/audit";
	
	/********** 1、附件   **********/
	/*** 1.1、硬盘   ***/
	public static final String file_disk_win  ="C:\\audit\\files\\";      //Windows下的保存路径
	public static final String file_disk_linux ="/home/audit/files/";	      //Linux下的保存路径
	
	
	/*** 1.2、数据库   ***/
	public static final String file_db ="/auditResource/files/"; //保存在数据库中的路径
	
	/********** 2、封面   **********/
	/*** 2.1、硬盘   ***/
	public static final String cover_disk_win  ="C:\\audit\\covers\\";       //Windows下的保存路径
	public static final String cover_disk_linux ="/home/audit/covers/";	      //Linux下的保存路径
	
	
	/*** 2.2、数据库   ***/
	public static final String cover_db ="/auditResource/covers/"; //保存在数据库中的路径
	
	/***计划分类***/
	public static final String WEEK_PLAN = "week_plan";
	public static final String DAY_PLAN = "day_plan";
	public static final String MONTH_PLAN = "month_plan";
	
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_SUBADMIN = "SUBADMIN";
	public static final String ROLE_USER = "USER";

}
