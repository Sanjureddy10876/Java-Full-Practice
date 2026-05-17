package com.swish.dto;

public class OrderResponse {

	private Long id;
	private String confirmMsg;
	private String orderedBy;
	
	public OrderResponse() {
		
	}
	public OrderResponse(Long id, String confirmMsg) {
		super();
		this.id = id;
		this.confirmMsg = confirmMsg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConfirmMsg() {
		return confirmMsg;
	}
	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}
	public String getOrderedBy() {
		return orderedBy;
	}
	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}

	
	
}
