package com.lenovo.service;

import java.util.List;

import com.lenovo.entity.ProductEntity;

public interface IProductService {
	
	public List<ProductEntity> getAllProducts();

	public List<ProductEntity> findByProductName(String productName);
	
	public void deleteProduct(int productID);
}
