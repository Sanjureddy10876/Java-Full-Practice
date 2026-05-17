package com.lenovo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenovo.entity.ProductEntity;
import com.lenovo.repository.IPriceRepository;
import com.lenovo.repository.ProductRepository;
import com.lenovo.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private	ProductRepository productRepository;
	
	@Autowired
	private IPriceRepository iProductRepository;

	@Override
	public List<ProductEntity> getAllProducts(){
		return  productRepository.findAll();
	}
	
	@Override
	public List<ProductEntity> findByProductName(String productName){
		if (productName == null || productName.isEmpty() || productName.trim().isEmpty()) {
			throw new IllegalArgumentException("Please enter product name");
		}
		return productRepository.findByProductName(productName);
	}
	
	@Override
	public void deleteProduct(int productID) {
		if (productID <= 0) {
			throw new IllegalArgumentException("Please provide a valid product ID");
		} 
		iProductRepository.deleteByProductId(productID);
		productRepository.deleteById(productID);
	}
}
