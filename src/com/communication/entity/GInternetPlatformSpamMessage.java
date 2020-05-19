package com.communication.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 网间平台垃圾短信举报
 **/
public class GInternetPlatformSpamMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	// 电信
	private String field_11;// 排名（集团/全国）
	private Float field_12;// 被举报率（件次/千万用户）
	private Float field_13;// 增幅
	private Integer field_14;// 0000退订
	private Integer field_15;// 收到垃圾短信息投诉量（起）
	private Integer field_16;// 处理完毕（起）
	private Float field_17;// 拦截垃圾短信息总量（万条）
	// 移动
	private String field_21;// 排名（集团/全国）
	private Float field_22;// 被举报率（件次/千万用户）
	private Float field_23;// 增幅
	private Integer field_24;// 0000退订
	private Integer field_25;// 收到垃圾短信息投诉量（起）
	private Integer field_26;// 处理完毕（起）
	private Float field_27;// 拦截垃圾短信息总量（万条）
	// 联通
	private String field_31;// 排名（集团/全国）
	private Float field_32;// 被举报率（件次/千万用户）
	private Float field_33;// 增幅
	private Integer field_34;// 0000退订
	private Integer field_35;// 收到垃圾短信息投诉量（起）
	private Integer field_36;// 处理完毕（起）
	private Float field_37;// 拦截垃圾短信息总量（万条）

	private Integer year;// 年份
	private Integer month;// 月份

	private Long createUserId;
	private Date insertTime;
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getField_11() {
		return field_11;
	}

	public void setField_11(String field_11) {
		this.field_11 = field_11;
	}

	public Float getField_12() {
		return field_12;
	}

	public void setField_12(Float field_12) {
		this.field_12 = field_12;
	}

	public Float getField_13() {
		return field_13;
	}

	public void setField_13(Float field_13) {
		this.field_13 = field_13;
	}

	public Integer getField_14() {
		return field_14;
	}

	public void setField_14(Integer field_14) {
		this.field_14 = field_14;
	}

	public Integer getField_15() {
		return field_15;
	}

	public void setField_15(Integer field_15) {
		this.field_15 = field_15;
	}

	public Integer getField_16() {
		return field_16;
	}

	public void setField_16(Integer field_16) {
		this.field_16 = field_16;
	}

	public Float getField_17() {
		return field_17;
	}

	public void setField_17(Float field_17) {
		this.field_17 = field_17;
	}

	public String getField_21() {
		return field_21;
	}

	public void setField_21(String field_21) {
		this.field_21 = field_21;
	}

	public Float getField_22() {
		return field_22;
	}

	public void setField_22(Float field_22) {
		this.field_22 = field_22;
	}

	public Float getField_23() {
		return field_23;
	}

	public void setField_23(Float field_23) {
		this.field_23 = field_23;
	}

	public Integer getField_24() {
		return field_24;
	}

	public void setField_24(Integer field_24) {
		this.field_24 = field_24;
	}

	public Integer getField_25() {
		return field_25;
	}

	public void setField_25(Integer field_25) {
		this.field_25 = field_25;
	}

	public Integer getField_26() {
		return field_26;
	}

	public void setField_26(Integer field_26) {
		this.field_26 = field_26;
	}

	public Float getField_27() {
		return field_27;
	}

	public void setField_27(Float field_27) {
		this.field_27 = field_27;
	}

	public String getField_31() {
		return field_31;
	}

	public void setField_31(String field_31) {
		this.field_31 = field_31;
	}

	public Float getField_32() {
		return field_32;
	}

	public void setField_32(Float field_32) {
		this.field_32 = field_32;
	}

	public Float getField_33() {
		return field_33;
	}

	public void setField_33(Float field_33) {
		this.field_33 = field_33;
	}

	public Integer getField_34() {
		return field_34;
	}

	public void setField_34(Integer field_34) {
		this.field_34 = field_34;
	}

	public Integer getField_35() {
		return field_35;
	}

	public void setField_35(Integer field_35) {
		this.field_35 = field_35;
	}

	public Integer getField_36() {
		return field_36;
	}

	public void setField_36(Integer field_36) {
		this.field_36 = field_36;
	}

	public Float getField_37() {
		return field_37;
	}

	public void setField_37(Float field_37) {
		this.field_37 = field_37;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
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
