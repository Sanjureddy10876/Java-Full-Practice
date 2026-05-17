package com.magicpin.service;

import java.util.List;

import com.magicpin.request.ProductRequest;
import com.magicpin.request.ProductResponse;

public interface ProductService {

	public String addProduct(ProductRequest productRequest);
	public String updateProduct(Long id, ProductRequest productRequest);
	public String deleteProduct(Long id, String status);
	
	public List<ProductResponse> searchProduct(String name);
	
	public List<ProductResponse> findAllProducts(String status);
}
