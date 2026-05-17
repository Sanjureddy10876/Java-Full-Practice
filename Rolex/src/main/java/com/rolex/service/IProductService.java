package com.rolex.service;

import com.rolex.request.ProductRequest;
import com.rolex.request.ProductResponse;

public interface IProductService {
	
	public ProductResponse createProduct(ProductRequest productRequest);

}
