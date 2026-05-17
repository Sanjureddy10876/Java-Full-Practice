package com.magicpin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicpin.entity.ProductEntity;
import com.magicpin.repository.ProductRepository;
import com.magicpin.request.ProductRequest;
import com.magicpin.request.ProductResponse;
import com.magicpin.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
  
	@Override
	public String addProduct(ProductRequest productRequest) {
		String name = productRequest.getName();
		double price = productRequest.getPrice();
		String category = productRequest.getCategory();
		String quantity = productRequest.getQuantity();
		String description = productRequest.getDescription();

		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(name);
		productEntity.setPrice(price);
		productEntity.setCategory(category);
		productEntity.setQuantity(quantity);
		productEntity.setDescription(description);
		productEntity.setStatus("ACTIVE");

		productRepository.save(productEntity);

		return "Product Added Succesfully";
	}

	@Override
	public String updateProduct(Long id, ProductRequest productRequest) {

	    Optional<ProductEntity> productOpt = productRepository.findById(id);

	    if (!productOpt.isPresent()) {  
	        return "Product not found";
	    }

	    ProductEntity productEntity = productOpt.get(); 

	    if (productRequest.getName() != null) {
	        productEntity.setName(productRequest.getName());
	    }
	    if (productRequest.getPrice() != 0) {
	        productEntity.setPrice(productRequest.getPrice());
	    }
	    if (productRequest.getCategory() != null) {
	        productEntity.setCategory(productRequest.getCategory());
	    }
	    if (productRequest.getQuantity() != null) {
	        productEntity.setQuantity(productRequest.getQuantity());
	    }
	    if (productRequest.getDescription() != null) {
	        productEntity.setDescription(productRequest.getDescription());
	    }

	    productRepository.save(productEntity); 

	    return "Product Updated Successfully";
	}

	@Override
	public String deleteProduct(Long id, String status) {
		Optional<ProductEntity> productID = productRepository.findById(id);
		   if (!productID.isPresent()) {  
		        return "Product not found";
		    }

		    ProductEntity productEntity = productID.get();
		    productEntity.setStatus(status);

		    productRepository.save(productEntity); 

		    return "Product Deleted Successfully";
	}

	@Override
	public List<ProductResponse> searchProduct(String name) {
		
		List<ProductEntity> entities = productRepository.findByNameContainingIgnoreCase(name);
		
		List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
		
		for(ProductEntity entity : entities) {
			ProductResponse productResponse = new ProductResponse();
			productResponse.setDescription(entity.getDescription());
			productResponse.setCategory(entity.getCategory());
			productResponse.setId(entity.getId());
			productResponse.setName(entity.getName());
			productResponse.setPrice(entity.getPrice());
			productResponse.setQuantity(entity.getQuantity());
			
			
		}
		
		return productResponses;
	}

	@Override
	public List<ProductResponse> findAllProducts(String status) {
		List<ProductEntity> entities = productRepository.findByStatus(status);
		List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
		
		for(ProductEntity entity : entities) {
			ProductResponse productResponse = new ProductResponse();
			productResponse.setDescription(entity.getDescription());
			productResponse.setCategory(entity.getCategory());
			productResponse.setId(entity.getId());
			productResponse.setName(entity.getName());
			productResponse.setPrice(entity.getPrice());
			productResponse.setQuantity(entity.getQuantity());
		    productResponse.setStatus(entity.getStatus());

			
			 productResponses.add(productResponse);
		}
		
		return productResponses;
	}

	
	

}
