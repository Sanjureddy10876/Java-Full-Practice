package com.rolex.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolex.repository.ProductRepository;
import com.rolex.request.ProductRequest;
import com.rolex.request.ProductResponse;
import com.rolex.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Transactional
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		
		String productId = productRequest.getProductId();
		String productName = productRequest.getProductName();
		String qty = productRequest.getQty();
		String productPrice = productRequest.getProductPrice();
		
		System.out.println("Your Data : "+productId+" "+productName+" "+qty+" "+productPrice);
		String data = productId + productName;
		String productID =productRepository.uploadProduct(data,productName,qty,productPrice);
		
		ProductResponse response = new ProductResponse();
		if (productID != null) {
			response.setProductID(productId);
			response.setProductName(productName);
			response.setQuantity(qty);
			response.setPrice(productPrice);
		} else {
			response.setProductID(productId);
			response.setProductName(productName);
			response.setQuantity(qty);
			response.setPrice("Unable to Load Product Deatils");
		}
		
		return response;
	}

}
