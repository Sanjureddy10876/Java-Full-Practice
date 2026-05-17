package com.swigy.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swigy.app.entity.ProductRequest;
import com.swigy.app.entity.ProductResponse;
import com.swigy.app.repository.ProductRepository;
import com.swigy.app.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		String foodId =productRequest.getFoodId();
		String foodName=productRequest.getFoodName();
		String qty=productRequest.getQty();
		String type=productRequest.getType();
		
		System.out.println("added food"+foodId+" "+foodName+" "+qty+" "+type);
		String data = foodId + foodName;
		System.out.println("Data::: "+data);
		String response1 =productRepository.uploadProduct(data);
		System.out.println("product IDDD :::: "+response1);
		ProductResponse productResponse = new ProductResponse();
		productResponse.setFoodId(response1);
		
		productResponse.setConfirmationDetails("Your Food item is validated Please wait we will update soon");

		return productResponse;
	}

}
