package com.audi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {


	@Id
	private String productId;
	@Column
	private String name;
	
	public ProductEntity(){
		
	}

	public ProductEntity(String productId, String name) {
		super();
		this.productId = productId;
		this.name = name;
	}
	
	
	
}
