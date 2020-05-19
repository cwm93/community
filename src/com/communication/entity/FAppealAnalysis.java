package com.communication.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 申诉情况分析月报
 */
@Entity
@Table(name = "zf_appeal_analysis")
public class FAppealAnalysis implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID
	/**
	 * 一、申诉总体趋势
	 **/
	// 申诉总量
	private Integer field_11;// 本月投诉量
	private Integer field_12;// 上月投诉量
	private Float field_13;// 环比%
	private Integer field_14;// 上一年度同月投诉量
	private Float field_15;// 同比% 两位小数
	private String field_16;// 备注
	// 重复单量
	private Integer field_21;// 本月投诉量
	private Integer field_22;// 上月投诉量
	private Float field_23;// 环比%
	private Integer field_24;// 上一年度同月投诉量
	private Float field_25;// 同比% 两位小数
	private String field_26;// 备注
	// 无效单量
	private Integer field_31;// 本月投诉量
	private Integer field_32;// 上月投诉量
	private Float field_33;// 环比%
	private Integer field_34;// 上一年度同月投诉量
	private Float field_35;// 同比% 两位小数
	private String field_36;// 备注
	// 有效单量
	private Integer field_41;// 本月投诉量
	private Integer field_42;// 上月投诉量
	private Float field_43;// 环比%
	private Integer field_44;// 上一年度同月投诉量
	private Float field_45;// 同比% 两位小数
	private String field_46;// 备注

	/**
	 * 二、申诉内容分析
	 **/
	private List<FAppealAnalysisContent> appealAnalysisContentList = new ArrayList<FAppealAnalysisContent>();
	/**
	 * 三、处理情况
	 **/
	// 和解量（用户对处理结果认可）
	private Integer field_51;// 本月投诉量
	private Float field_52;// 占比%
	private Integer field_53;// 上月投诉量
	private Float field_54;// 环比%
	private Integer field_55;// 上一年度同月投诉量
	private Float field_56;// 同比% 两位小数
	private String field_57;// 备注
	// 不认可量（用户对处理结果不认可）
	private Integer field_61;// 本月投诉量
	private Float field_62;// 占比%
	private Integer field_63;// 上月投诉量
	private Float field_64;// 环比%
	private Integer field_65;// 上一年度同月投诉量
	private Float field_66;// 同比% 两位小数
	private String field_67;// 备注
	// 知晓量(用户对处理结果表示知晓）
	private Integer field_71;// 本月投诉量
	private Float field_72;// 占比%
	private Integer field_73;// 上月投诉量
	private Float field_74;// 环比%
	private Integer field_75;// 上一年度同月投诉量
	private Float field_76;// 同比% 两位小数
	private String field_77;// 备注

	/**
	 * 填表人相关信息
	 **/
	private String userName;
	private String company;
	private String mobile;
	private String email;
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

	@Column(name = "report_log_id")
	public long getReportLogId() {
		return reportLogId;
	}

	public void setReportLogId(long reportLogId) {
		this.reportLogId = reportLogId;
	}

	@Column(name = "insert_user_id")
	public long getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(long insertUserId) {
		this.insertUserId = insertUserId;
	}

	@Column(name = "telecom_operator_id")
	public long getTelecomOperatorId() {
		return telecomOperatorId;
	}

	public void setTelecomOperatorId(long telecomOperatorId) {
		this.telecomOperatorId = telecomOperatorId;
	}

	@Column(name = "field_11")
	public Integer getField_11() {
		return field_11;
	}

	public void setField_11(Integer field_11) {
		this.field_11 = field_11;
	}

	@Column(name = "field_12")
	public Integer getField_12() {
		return field_12;
	}

	public void setField_12(Integer field_12) {
		this.field_12 = field_12;
	}

	@Column(name = "field_13")
	public Float getField_13() {
		return field_13;
	}

	public void setField_13(Float field_13) {
		this.field_13 = field_13;
	}

	@Column(name = "field_14")
	public Integer getField_14() {
		return field_14;
	}

	public void setField_14(Integer field_14) {
		this.field_14 = field_14;
	}

	@Column(name = "field_15")
	public Float getField_15() {
		return field_15;
	}

	public void setField_15(Float field_15) {
		this.field_15 = field_15;
	}

	@Column(name = "field_16",length=500)
	public String getField_16() {
		return field_16;
	}

	public void setField_16(String field_16) {
		this.field_16 = field_16;
	}

	@Column(name = "field_21")
	public Integer getField_21() {
		return field_21;
	}

	public void setField_21(Integer field_21) {
		this.field_21 = field_21;
	}

	@Column(name = "field_22")
	public Integer getField_22() {
		return field_22;
	}

	public void setField_22(Integer field_22) {
		this.field_22 = field_22;
	}

	@Column(name = "field_23")
	public Float getField_23() {
		return field_23;
	}

	public void setField_23(Float field_23) {
		this.field_23 = field_23;
	}

	@Column(name = "field_24")
	public Integer getField_24() {
		return field_24;
	}

	public void setField_24(Integer field_24) {
		this.field_24 = field_24;
	}

	@Column(name = "field_25")
	public Float getField_25() {
		return field_25;
	}

	public void setField_25(Float field_25) {
		this.field_25 = field_25;
	}

	@Column(name = "field_26",length=500)
	public String getField_26() {
		return field_26;
	}

	public void setField_26(String field_26) {
		this.field_26 = field_26;
	}

	@Column(name = "field_31")
	public Integer getField_31() {
		return field_31;
	}

	public void setField_31(Integer field_31) {
		this.field_31 = field_31;
	}

	@Column(name = "field_32")
	public Integer getField_32() {
		return field_32;
	}

	public void setField_32(Integer field_32) {
		this.field_32 = field_32;
	}

	@Column(name = "field_33")
	public Float getField_33() {
		return field_33;
	}

	public void setField_33(Float field_33) {
		this.field_33 = field_33;
	}

	@Column(name = "field_34")
	public Integer getField_34() {
		return field_34;
	}

	public void setField_34(Integer field_34) {
		this.field_34 = field_34;
	}

	@Column(name = "field_35")
	public Float getField_35() {
		return field_35;
	}

	public void setField_35(Float field_35) {
		this.field_35 = field_35;
	}

	@Column(name = "field_36",length=500)
	public String getField_36() {
		return field_36;
	}

	public void setField_36(String field_36) {
		this.field_36 = field_36;
	}

	@Column(name = "field_41")
	public Integer getField_41() {
		return field_41;
	}

	public void setField_41(Integer field_41) {
		this.field_41 = field_41;
	}

	@Column(name = "field_42")
	public Integer getField_42() {
		return field_42;
	}

	public void setField_42(Integer field_42) {
		this.field_42 = field_42;
	}

	@Column(name = "field_43")
	public Float getField_43() {
		return field_43;
	}

	public void setField_43(Float field_43) {
		this.field_43 = field_43;
	}

	@Column(name = "field_44")
	public Integer getField_44() {
		return field_44;
	}

	public void setField_44(Integer field_44) {
		this.field_44 = field_44;
	}

	@Column(name = "field_45")
	public Float getField_45() {
		return field_45;
	}

	public void setField_45(Float field_45) {
		this.field_45 = field_45;
	}

	@Column(name = "field_46",length=500)
	public String getField_46() {
		return field_46;
	}

	public void setField_46(String field_46) {
		this.field_46 = field_46;
	}

	@OneToMany(targetEntity=FAppealAnalysisContent.class,cascade=CascadeType.ALL)  
	@Fetch(FetchMode.JOIN)  
	@JoinColumn(name="appeal_analysis_id")
	@OrderBy("id ASC")
	public List<FAppealAnalysisContent> getAppealAnalysisContentList() {
		return appealAnalysisContentList;
	}

	public void setAppealAnalysisContentList(List<FAppealAnalysisContent> appealAnalysisContentList) {
		this.appealAnalysisContentList = appealAnalysisContentList;
	}

	@Column(name = "field_51")
	public Integer getField_51() {
		return field_51;
	}

	public void setField_51(Integer field_51) {
		this.field_51 = field_51;
	}

	@Column(name = "field_52")
	public Float getField_52() {
		return field_52;
	}

	public void setField_52(Float field_52) {
		this.field_52 = field_52;
	}

	@Column(name = "field_53")
	public Integer getField_53() {
		return field_53;
	}

	public void setField_53(Integer field_53) {
		this.field_53 = field_53;
	}

	@Column(name = "field_54")
	public Float getField_54() {
		return field_54;
	}

	public void setField_54(Float field_54) {
		this.field_54 = field_54;
	}

	@Column(name = "field_55")
	public Integer getField_55() {
		return field_55;
	}

	public void setField_55(Integer field_55) {
		this.field_55 = field_55;
	}
	
	@Column(name = "field_56")
	public Float getField_56() {
		return field_56;
	}

	public void setField_56(Float field_56) {
		this.field_56 = field_56;
	}
	@Column(name = "field_57",length=500)
	public String getField_57() {
		return field_57;
	}

	public void setField_57(String field_57) {
		this.field_57 = field_57;
	}

	@Column(name = "field_61")
	public Integer getField_61() {
		return field_61;
	}

	public void setField_61(Integer field_61) {
		this.field_61 = field_61;
	}

	@Column(name = "field_62")
	public Float getField_62() {
		return field_62;
	}

	public void setField_62(Float field_62) {
		this.field_62 = field_62;
	}

	@Column(name = "field_63")
	public Integer getField_63() {
		return field_63;
	}

	public void setField_63(Integer field_63) {
		this.field_63 = field_63;
	}

	@Column(name = "field_64")
	public Float getField_64() {
		return field_64;
	}

	public void setField_64(Float field_64) {
		this.field_64 = field_64;
	}

	@Column(name = "field_65")
	public Integer getField_65() {
		return field_65;
	}

	public void setField_65(Integer field_65) {
		this.field_65 = field_65;
	}

	@Column(name = "field_66",length=500)
	public Float getField_66() {
		return field_66;
	}

	public void setField_66(Float field_66) {
		this.field_66 = field_66;
	}
	
	@Column(name = "field_67",length=500)
	public String getField_67() {
		return field_67;
	}

	public void setField_67(String field_67) {
		this.field_67 = field_67;
	}

	@Column(name = "field_71")
	public Integer getField_71() {
		return field_71;
	}

	public void setField_71(Integer field_71) {
		this.field_71 = field_71;
	}

	@Column(name = "field_72")
	public Float getField_72() {
		return field_72;
	}

	public void setField_72(Float field_72) {
		this.field_72 = field_72;
	}

	@Column(name = "field_73")
	public Integer getField_73() {
		return field_73;
	}

	public void setField_73(Integer field_73) {
		this.field_73 = field_73;
	}

	@Column(name = "field_74")
	public Float getField_74() {
		return field_74;
	}

	public void setField_74(Float field_74) {
		this.field_74 = field_74;
	}

	@Column(name = "field_75")
	public Integer getField_75() {
		return field_75;
	}

	public void setField_75(Integer field_75) {
		this.field_75 = field_75;
	}

	@Column(name = "field_76")
	public Float getField_76() {
		return field_76;
	}

	public void setField_76(Float field_76) {
		this.field_76 = field_76;
	}
	@Column(name = "field_77",length=500)
	public String getField_77() {
		return field_77;
	}

	public void setField_77(String field_77) {
		this.field_77 = field_77;
	}
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}
