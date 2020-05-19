package com.communication.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String username;// 用户名，手机号码
	private String password;// 登陆密码
	/**
	 * 用户基本信息
	 */
	private TelecomOperator telecomOperator;// 运营商
	private CompanyAttribute companyAttribute;// 单位属性
	private String company;// 单位名称
	private String position;// 职务
	private String realname;// 姓名
	private String mobile;// 手机，用于登录
	private String email;// 电子邮箱
	private String idCardNumber;// 身份证号码
	private String address;// 地址
	private String telephone;// 固话
	/**
	 * 其他信息
	 */
	private Role role;// 用户角色
	private Date createdTime;// 注册时间
	private Date lastLoginTime;// 登陆时间
	private String lastLoginIp;// 登陆IP
	private String status;// 用户状态0：未审核；1：审核通过；2：禁用账号

	private String smscode;// 短信验证码
	private long sendCodeTime;// 发送时间
	private long codeExpire;// 过期时间

	/**
	 * 仅当角色为管理员的user调用
	 */
	private Set<User> assignedUsers = new HashSet<User>(0);
	private Set<Report> assignedReports = new HashSet<Report>(0);
	private Set<AdministrationReport> assignedAdministrationReports = new HashSet<AdministrationReport>(0);

	public User() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public TelecomOperator getTelecomOperator() {
		return telecomOperator;
	}

	public void setTelecomOperator(TelecomOperator telecomOperator) {
		this.telecomOperator = telecomOperator;
	}

	@JsonIgnore
	public CompanyAttribute getCompanyAttribute() {
		return companyAttribute;
	}

	public void setCompanyAttribute(CompanyAttribute companyAttribute) {
		this.companyAttribute = companyAttribute;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@JsonIgnore
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@JsonIgnore
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	@JsonIgnore
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@JsonIgnore
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonIgnore
	public Set<User> getAssignedUsers() {
		return assignedUsers;
	}

	public void setAssignedUsers(Set<User> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}

	@JsonIgnore
	public Set<Report> getAssignedReports() {
		return assignedReports;
	}

	public void setAssignedReports(Set<Report> assignedReports) {
		this.assignedReports = assignedReports;
	}

	@JsonIgnore
	public Set<AdministrationReport> getAssignedAdministrationReports() {
		return assignedAdministrationReports;
	}

	public void setAssignedAdministrationReports(Set<AdministrationReport> assignedAdministrationReports) {
		this.assignedAdministrationReports = assignedAdministrationReports;
	}

	public String getSmscode() {
		return smscode;
	}

	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}

	public long getSendCodeTime() {
		return sendCodeTime;
	}

	public void setSendCodeTime(long sendCodeTime) {
		this.sendCodeTime = sendCodeTime;
	}

	public long getCodeExpire() {
		return codeExpire;
	}

	public void setCodeExpire(long codeExpire) {
		this.codeExpire = codeExpire;
	}

}
