package com.communication.dto;

public class IOTSecurityManagementSegmentDTO {

	private Long id;
	private String segment;// 11 、13
	private Integer usedAmount;
	private Integer amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public Integer getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(Integer usedAmount) {
		this.usedAmount = usedAmount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
