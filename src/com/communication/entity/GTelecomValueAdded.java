package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliang 增值电信业务统计分析（含自贸区）
 */
public class GTelecomValueAdded implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String code;// 许可证编号
	private String companyName;// 公司名称
	private String businessCategory;// 业务种类
	private String businessCoverage;// 业务覆盖范围（许可证载明）
	private String serviceItems;// 服务项目
	private String approvalDate;// 批准日期
	private String licenseValidity;// 许可证有效性
	private String enterpriseNature;// 企业性质
	private String registeredCapital;// 注册资本
	private String listedCompany;// 是否上市公司

	private GTelecomValueAddedBatch batch;
	private Long userId;
	private Date insertTime;
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public String getBusinessCoverage() {
		return businessCoverage;
	}

	public void setBusinessCoverage(String businessCoverage) {
		this.businessCoverage = businessCoverage;
	}

	public String getServiceItems() {
		return serviceItems;
	}

	public void setServiceItems(String serviceItems) {
		this.serviceItems = serviceItems;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getLicenseValidity() {
		return licenseValidity;
	}

	public void setLicenseValidity(String licenseValidity) {
		this.licenseValidity = licenseValidity;
	}

	public String getEnterpriseNature() {
		return enterpriseNature;
	}

	public void setEnterpriseNature(String enterpriseNature) {
		this.enterpriseNature = enterpriseNature;
	}

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String getListedCompany() {
		return listedCompany;
	}

	public void setListedCompany(String listedCompany) {
		this.listedCompany = listedCompany;
	}

	@JsonIgnore
	public GTelecomValueAddedBatch getBatch() {
		return batch;
	}

	public void setBatch(GTelecomValueAddedBatch batch) {
		this.batch = batch;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
