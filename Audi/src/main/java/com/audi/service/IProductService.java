package com.audi.service;

import com.audi.request.ProductRequest;
import com.audi.request.ProductResponse;

public interface IProductService {

	public ProductResponse createProduct(ProductRequest productRequest);
	
}
