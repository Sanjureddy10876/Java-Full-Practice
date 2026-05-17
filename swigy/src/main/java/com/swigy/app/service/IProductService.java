package com.swigy.app.service;

import com.swigy.app.entity.ProductRequest;
import com.swigy.app.entity.ProductResponse;

public interface IProductService {

	public ProductResponse createProduct(ProductRequest productRequest);
}
