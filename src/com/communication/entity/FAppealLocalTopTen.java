package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 本地投诉情况
 */
@Entity
@Table(name = "zf_appeal_local_top_ten")
public class FAppealLocalTopTen implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	/**
	 * 二、投诉热点问题TOP10
	 **/
	private FAppealLocal appealLocal;
	private Integer type;
	private String top_01;// 投诉类型
	private String top_02;// 主要问题
	private Integer top_03;// 本月投诉量
	private Float top_04;// 占比%
	private Integer top_05;// 上月投诉量
	private Float top_06;// 环比%
	private Integer top_07;// 上一年度同月投诉量
	private Float top_08;// 同比%
	private String top_09;// 解决方案（客户界面处理口径/内部整改优化方案）

	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//多对一，@JoinColumn与@column类似，指定映射的数据库字段  
	@ManyToOne(targetEntity = FAppealLocal.class)  
	@JoinColumn(name="appeal_local_id",updatable=false) 
	public FAppealLocal getAppealLocal() {
		return appealLocal;
	}

	public void setAppealLocal(FAppealLocal appealLocal) {
		this.appealLocal = appealLocal;
	}

	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "top_01",length=200)
	public String getTop_01() {
		return top_01;
	}

	public void setTop_01(String top_01) {
		this.top_01 = top_01;
	}

	@Column(name = "top_02",length=500)
	public String getTop_02() {
		return top_02;
	}

	public void setTop_02(String top_02) {
		this.top_02 = top_02;
	}

	@Column(name = "top_03")
	public Integer getTop_03() {
		return top_03;
	}

	public void setTop_03(Integer top_03) {
		this.top_03 = top_03;
	}

	@Column(name = "top_04")
	public Float getTop_04() {
		return top_04;
	}

	public void setTop_04(Float top_04) {
		this.top_04 = top_04;
	}

	@Column(name = "top_05")
	public Integer getTop_05() {
		return top_05;
	}

	public void setTop_05(Integer top_05) {
		this.top_05 = top_05;
	}

	@Column(name = "top_06")
	public Float getTop_06() {
		return top_06;
	}

	public void setTop_06(Float top_06) {
		this.top_06 = top_06;
	}

	@Column(name = "top_07")
	public Integer getTop_07() {
		return top_07;
	}

	public void setTop_07(Integer top_07) {
		this.top_07 = top_07;
	}

	@Column(name = "top_08")
	public Float getTop_08() {
		return top_08;
	}

	public void setTop_08(Float top_08) {
		this.top_08 = top_08;
	}

	@Column(name = "top_09",length=500)
	public String getTop_09() {
		return top_09;
	}

	public void setTop_09(String top_09) {
		this.top_09 = top_09;
	}

	@Column(name = "insert_time")
	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	
	@Column(name = "update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "FAppealLocalTopTen [id=" + id + ", type=" + type + ", top_01=" + top_01
				+ ", top_02=" + top_02 + ", top_03=" + top_03 + ", top_04=" + top_04 + ", top_05=" + top_05
				+ ", top_06=" + top_06 + ", top_07=" + top_07 + ", top_08=" + top_08 + ", top_09=" + top_09
				+ ", insertTime=" + insertTime + ", updateTime=" + updateTime + "]";
	}

}
