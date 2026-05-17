package com.audi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audi.entity.ProductEntity;
import com.audi.repository.ProductRepository;
import com.audi.request.ProductRequest;
import com.audi.request.ProductResponse;
import com.audi.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
 private ProductRepository productRepository;
	
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		String productname	=productRequest.getProductName();
		String productdescription	=productRequest.getDescription();
		String productquantity	=productRequest.getQty();
		String soldby	=productRequest.getSoldBy();
		System.out.println("Product Details::: name "+productname+" "+productdescription+" "+productquantity+" "+soldby);
		String data = productdescription + productname;
		String productIDD = java.util.UUID.nameUUIDFromBytes(data.getBytes()).toString();
		
		ProductEntity product = new ProductEntity(productIDD,data);
		ProductEntity prodId =productRepository.save(product);
		ProductResponse response = new ProductResponse();
		if (prodId!=null) {
			response.setProductId(productquantity);
			response.setConfirmationMsg("Sold by "+soldby);
		} else {
			response.setProductId(productquantity);
			response.setConfirmationMsg("Unable to load the product details "+soldby);
		}
		
		return response;
	}

}
