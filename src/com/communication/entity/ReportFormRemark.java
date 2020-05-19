package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author liliang
 * @description 报表表单备注
 */
@Entity
@Table(name = "tb_report_form_remark")
public class ReportFormRemark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long reportId;
	private Integer year;// 年
	private String remarkContent;// 备注内容
	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更新时间

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getRemarkContent() {
		return remarkContent;
	}

	public void setRemarkContent(String remarkContent) {
		this.remarkContent = remarkContent;
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

	@Override
	public String toString() {
		return "ReportFormRemark [id=" + id + ", year=" + year + ", remarkContent=" + remarkContent + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + "]";
	}

}
