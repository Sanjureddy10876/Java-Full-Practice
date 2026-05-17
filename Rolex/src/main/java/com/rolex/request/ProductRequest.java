package com.rolex.request;

public class ProductRequest {
	private String productName;
	private String productId;
	private String qty;
	private String productPrice;
	
	public ProductRequest( String productId,String productName, String qty, String productPrice) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.qty = qty;
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	  public ProductRequest() {
	    }

	

}
