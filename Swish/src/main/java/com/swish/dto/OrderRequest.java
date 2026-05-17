package com.swish.dto;

public class OrderRequest {

	
	private String foodName;
	private String foodtype;
	private String orderedby;
	private String phoneNumber;
	
	public OrderRequest() {
		
	}
	public OrderRequest(String foodName, String foodtype, String orderedby, String phoneNumber) {
		super();
		this.foodName = foodName;
		this.foodtype = foodtype;
		this.orderedby = orderedby;
		this.phoneNumber = phoneNumber;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	public String getOrderedby() {
		return orderedby;
	}
	public void setOrderedby(String orderedby) {
		this.orderedby = orderedby;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
}
