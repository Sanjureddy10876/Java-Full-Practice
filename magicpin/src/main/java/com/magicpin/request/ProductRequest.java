package com.magicpin.request;

public class ProductRequest {
	
	
	private String name;
	private String category;
	private double price;
	private String quantity;
	private String description;
	
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
public ProductRequest() {
	
}
}
