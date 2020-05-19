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
 * 骚扰电话举报分类汇总表
 */
@Entity
@Table(name = "zf_crank_call")
public class FCrankCall implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private long reportLogId;
	private long insertUserId;// 插入者id
	private long telecomOperatorId;// 运营商ID
	
	// 公安部门
	private String field_000; // 总举报数量
	private String field_011; // 淫秽色情举报数量
	private String field_012;// 具体案例描述
	private String field_021;// 发票办证举报数量
	private String field_022;// 具体案例描述
	private String field_031;// 诈骗反诈举报数量
	private String field_032;// 具体案例描述
	// 银监会
	private String field_100;// 总举报数量
	private String field_111;// 贷款理财
	private String field_112;//
	private String field_121;// 催收电话
	private String field_122;//
	// 证监会
	private String field_200;//总举报数量
	private String field_211;//总举报数量
	private String field_212;//具体案例描述（填写有明确指向拨打主体的案例）
	// 保监会
	private String field_300;
	private String field_311;
	private String field_312;
	// 住建部（房管局）
	private String field_400;
	private String field_411;
	private String field_412;
	// 教育部
	private String field_500;
	private String field_511;
	private String field_512;
	// 卫计委、食药监局
	private String field_600;
	private String field_611;
	private String field_612;
	// 卫计委
	private String field_700;
	private String field_711;
	private String field_712;
	// 人社部
	private String field_800;
	private String field_811;
	private String field_812;
	// 旅游局
	private String field_900;
	private String field_911;
	private String field_912;
	// 食药监局
	private String field_1000;
	private String field_1011;
	private String field_1012;
	// 工商局
	private String field_1100;
	private String field_1111;
	private String field_1112;
	// 需文字描述
	private String field_1200;
	private String field_1211;
	private String field_1212;

	private String field_1300; // 本月总体举报数量
	private String field_1301; // 上海号码举报数量
	private String field_1302; // 他省号码举报数量

	private String userName;
	private String company;
	private String mobile;
	private String email;
	private Date insertTime;// 插入时间
	private Date updateTime;// 最后一次更改时间

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getField_000() {
		return field_000;
	}

	public void setField_000(String field_000) {
		this.field_000 = field_000;
	}

	
	public String getField_011() {
		return field_011;
	}

	public void setField_011(String field_011) {
		this.field_011 = field_011;
	}

	public String getField_012() {
		return field_012;
	}

	public void setField_012(String field_012) {
		this.field_012 = field_012;
	}

	public String getField_021() {
		return field_021;
	}

	public void setField_021(String field_021) {
		this.field_021 = field_021;
	}

	public String getField_022() {
		return field_022;
	}

	public void setField_022(String field_022) {
		this.field_022 = field_022;
	}

	public String getField_031() {
		return field_031;
	}

	public void setField_031(String field_031) {
		this.field_031 = field_031;
	}

	public String getField_032() {
		return field_032;
	}

	public void setField_032(String field_032) {
		this.field_032 = field_032;
	}

	public String getField_100() {
		return field_100;
	}

	public void setField_100(String field_100) {
		this.field_100 = field_100;
	}

	public String getField_111() {
		return field_111;
	}

	public void setField_111(String field_111) {
		this.field_111 = field_111;
	}

	public String getField_112() {
		return field_112;
	}

	public void setField_112(String field_112) {
		this.field_112 = field_112;
	}

	public String getField_121() {
		return field_121;
	}

	public void setField_121(String field_121) {
		this.field_121 = field_121;
	}

	public String getField_122() {
		return field_122;
	}

	public void setField_122(String field_122) {
		this.field_122 = field_122;
	}

	public String getField_200() {
		return field_200;
	}

	public void setField_200(String field_200) {
		this.field_200 = field_200;
	}

	public String getField_211() {
		return field_211;
	}

	public void setField_211(String field_211) {
		this.field_211 = field_211;
	}

	public String getField_212() {
		return field_212;
	}

	public void setField_212(String field_212) {
		this.field_212 = field_212;
	}

	public String getField_300() {
		return field_300;
	}

	public void setField_300(String field_300) {
		this.field_300 = field_300;
	}

	public String getField_311() {
		return field_311;
	}

	public void setField_311(String field_311) {
		this.field_311 = field_311;
	}

	public String getField_312() {
		return field_312;
	}

	public void setField_312(String field_312) {
		this.field_312 = field_312;
	}

	public String getField_400() {
		return field_400;
	}

	public void setField_400(String field_400) {
		this.field_400 = field_400;
	}

	public String getField_411() {
		return field_411;
	}

	public void setField_411(String field_411) {
		this.field_411 = field_411;
	}

	public String getField_412() {
		return field_412;
	}

	public void setField_412(String field_412) {
		this.field_412 = field_412;
	}

	public String getField_500() {
		return field_500;
	}

	public void setField_500(String field_500) {
		this.field_500 = field_500;
	}

	public String getField_511() {
		return field_511;
	}

	public void setField_511(String field_511) {
		this.field_511 = field_511;
	}

	public String getField_512() {
		return field_512;
	}

	public void setField_512(String field_512) {
		this.field_512 = field_512;
	}

	public String getField_600() {
		return field_600;
	}

	public void setField_600(String field_600) {
		this.field_600 = field_600;
	}
	
	public String getField_611() {
		return field_611;
	}

	public void setField_611(String field_611) {
		this.field_611 = field_611;
	}

	public String getField_612() {
		return field_612;
	}

	public void setField_612(String field_612) {
		this.field_612 = field_612;
	}

	public String getField_700() {
		return field_700;
	}

	public void setField_700(String field_700) {
		this.field_700 = field_700;
	}

	public String getField_711() {
		return field_711;
	}

	public void setField_711(String field_711) {
		this.field_711 = field_711;
	}

	public String getField_712() {
		return field_712;
	}

	public void setField_712(String field_712) {
		this.field_712 = field_712;
	}

	public String getField_800() {
		return field_800;
	}

	public void setField_800(String field_800) {
		this.field_800 = field_800;
	}

	public String getField_811() {
		return field_811;
	}

	public void setField_811(String field_811) {
		this.field_811 = field_811;
	}

	public String getField_812() {
		return field_812;
	}

	public void setField_812(String field_812) {
		this.field_812 = field_812;
	}

	public String getField_900() {
		return field_900;
	}

	public void setField_900(String field_900) {
		this.field_900 = field_900;
	}

	public String getField_911() {
		return field_911;
	}

	public void setField_911(String field_911) {
		this.field_911 = field_911;
	}

	public String getField_912() {
		return field_912;
	}

	public void setField_912(String field_912) {
		this.field_912 = field_912;
	}

	public String getField_1000() {
		return field_1000;
	}

	public void setField_1000(String field_1000) {
		this.field_1000 = field_1000;
	}

	public String getField_1011() {
		return field_1011;
	}

	public void setField_1011(String field_1011) {
		this.field_1011 = field_1011;
	}

	public String getField_1012() {
		return field_1012;
	}

	public void setField_1012(String field_1012) {
		this.field_1012 = field_1012;
	}

	public String getField_1100() {
		return field_1100;
	}

	public void setField_1100(String field_1100) {
		this.field_1100 = field_1100;
	}

	public String getField_1111() {
		return field_1111;
	}

	public void setField_1111(String field_1111) {
		this.field_1111 = field_1111;
	}

	public String getField_1112() {
		return field_1112;
	}

	public void setField_1112(String field_1112) {
		this.field_1112 = field_1112;
	}

	public String getField_1200() {
		return field_1200;
	}

	public void setField_1200(String field_1200) {
		this.field_1200 = field_1200;
	}

	public String getField_1211() {
		return field_1211;
	}

	public void setField_1211(String field_1211) {
		this.field_1211 = field_1211;
	}

	public String getField_1212() {
		return field_1212;
	}

	public void setField_1212(String field_1212) {
		this.field_1212 = field_1212;
	}
	
	public String getField_1300() {
		return field_1300;
	}

	public void setField_1300(String field_1300) {
		this.field_1300 = field_1300;
	}

	public String getField_1301() {
		return field_1301;
	}

	public void setField_1301(String field_1301) {
		this.field_1301 = field_1301;
	}

	public String getField_1302() {
		return field_1302;
	}

	public void setField_1302(String field_1302) {
		this.field_1302 = field_1302;
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

	@Override
	public String toString() {
		return "FCrankCall [id=" + id + ", field_000=" + field_000 + ", field_011=" + field_011 + ", field_012="
				+ field_012 + ", field_021=" + field_021 + ", field_022=" + field_022 + ", field_031=" + field_031
				+ ", field_032=" + field_032 + ", field_100=" + field_100 + ", field_111=" + field_111 + ", field_112="
				+ field_112 + ", field_121=" + field_121 + ", field_122=" + field_122 + ", field_200=" + field_200
				+ ", field_211=" + field_211 + ", field_212=" + field_212 + ", field_300=" + field_300 + ", field_311="
				+ field_311 + ", field_312=" + field_312 + ", field_400=" + field_400 + ", field_411=" + field_411
				+ ", field_412=" + field_412 + ", field_500=" + field_500 + ", field_511=" + field_511 + ", field_512="
				+ field_512 + ", field_600=" + field_600 + ", field_611=" + field_611 + ", field_612=" + field_612
				+ ", field_700=" + field_700 + ", field_711=" + field_711 + ", field_712=" + field_712 + ", field_800="
				+ field_800 + ", field_811=" + field_811 + ", field_812=" + field_812 + ", field_900=" + field_900
				+ ", field_911=" + field_911 + ", field_912=" + field_912 + ", field_1000=" + field_1000
				+ ", field_1011=" + field_1011 + ", field_1012=" + field_1012 + ", field_1100=" + field_1100
				+ ", field_1111=" + field_1111 + ", field_1112=" + field_1112 + ", field_1200=" + field_1200
				+ ", field_1211=" + field_1211 + ", field_1212=" + field_1212 + ", field_1300=" + field_1300
				+ ", field_1301=" + field_1301 + ", field_1302=" + field_1302 + ", userName=" + userName + ", company="
				+ company + ", mobile=" + mobile + ", email=" + email + ", insertTime=" + insertTime + ", updateTime="
				+ updateTime + "]";
	}

}
