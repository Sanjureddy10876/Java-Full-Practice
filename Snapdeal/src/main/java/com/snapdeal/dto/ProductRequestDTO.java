package com.snapdeal.dto;

public class ProductRequestDTO {
	
	private String productName;
	private String description;
	private int qty;
	private int price;
	public ProductRequestDTO() {
		
	}
	public ProductRequestDTO(String productName, String description, int qty, int price) {
		super();
		this.productName = productName;
		this.description = description;
		this.qty = qty;
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
}
