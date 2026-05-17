package com.snapdeal.service;

import java.util.List;

import com.snapdeal.dto.ProductRequestDTO;
import com.snapdeal.dto.ProductResponseDTO;
import com.snapdeal.entity.ProductEntity;

public interface IProductService {

	public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
	
	public List<ProductEntity> getAllProducts();
	
	public List<ProductEntity> getSearchedProducts(String productName);
	
	//cart service
	
	public void addToCart(int productId, int quantity);
}
