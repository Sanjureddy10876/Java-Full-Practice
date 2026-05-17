package com.nothing.dto;

public class PhoneRequest {

	private String phoneName;
	private String phoneDescription;
	private int price;
	private int qty;
	private String currencyType;
	
	
	public String getCurrencyType() {
		return currencyType;
	}


	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}


	public PhoneRequest() {
		
	}



	public PhoneRequest(String phoneName, String phoneDescription, int price, int qty, String currencyType) {
		super();
		this.phoneName = phoneName;
		this.phoneDescription = phoneDescription;
		this.price = price;
		this.qty = qty;
		this.currencyType = currencyType;
	}


	public String getPhoneName() {
		return phoneName;
	}


	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}


	public String getPhoneDescription() {
		return phoneDescription;
	}


	public void setPhoneDescription(String phoneDescription) {
		this.phoneDescription = phoneDescription;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	
	
}
