package com.audi.request;

public class ProductRequest {


	private String productName;
	private String qty;
	private String description;
	private String price;
	private String soldBy;
	public ProductRequest(String productName, String qty, String description, String price, String soldBy) {
		super();
		this.productName = productName;
		this.qty = qty;
		this.description = description;
		this.price = price;
		this.soldBy = soldBy;
	}
	public ProductRequest() {
		
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSoldBy() {
		return soldBy;
	}
	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}
	
	
	
}
