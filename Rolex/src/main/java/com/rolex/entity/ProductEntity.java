package com.rolex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rolex_product_info")
public class ProductEntity {
	

	@Id
	private String productID;
	@Column
	private String productName;
	@Column
	private String price;
	@Column
	private String quantity;
	
	public ProductEntity(){
		
	}

	public ProductEntity(String productID, String productName, String price, String quantity) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
}
