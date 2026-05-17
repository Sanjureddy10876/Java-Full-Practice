package com.swigy.app.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

	
	public String uploadProduct(String data) {
		String productIDD = java.util.UUID.nameUUIDFromBytes(data.getBytes()).toString();

		return productIDD; 
	}
}
