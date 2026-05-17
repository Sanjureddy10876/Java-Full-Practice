package com.snapdeal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapdeal.dto.ProductRequestDTO;
import com.snapdeal.dto.ProductResponseDTO;
import com.snapdeal.entity.CartEntity;
import com.snapdeal.entity.CartItemEntity;
import com.snapdeal.entity.InventryEntity;
import com.snapdeal.entity.PriceEntity;
import com.snapdeal.entity.ProductEntity;
import com.snapdeal.repository.ICartItemRepository;
import com.snapdeal.repository.ICartRepository;
import com.snapdeal.repository.ProductRepository;
import com.snapdeal.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ICartRepository iCartRepository;
	
	private ICartItemRepository iCartItemRepository;

	@Override
	public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
		String productname = productRequestDTO.getProductName();
		String productdescription = productRequestDTO.getDescription();
		int qty = productRequestDTO.getQty();
		int price = productRequestDTO.getPrice();

		InventryEntity inventryEntity = new InventryEntity();
		inventryEntity.setAvaliable_qty(qty);
		inventryEntity.setStatus("UPDATED");

		PriceEntity priceEntity = new PriceEntity();
		priceEntity.setPrice(price);
		priceEntity.setCurrencyCode("Rupee");
		priceEntity.setStatus("COMPLETED");

		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductName(productname);
		productEntity.setProductDescription(productdescription);
		productEntity.setStatus("INPROGRESS");

		inventryEntity.setProductEntity(productEntity);
		priceEntity.setProductEntity(productEntity);
		productEntity.setInventryEntity(inventryEntity);
		productEntity.setPriceEntity(priceEntity);

		ProductEntity productEntity2 = new ProductEntity();
		Integer productIDD = productEntity2.getProductID();

		ProductResponseDTO response = new ProductResponseDTO();

		if (productIDD != null) {

			response.setId(productIDD);
			response.setConfirmMsg("Your Product was uploaded please wait for review from team");
		} else {
			response.setId(productIDD);
			response.setConfirmMsg("unable to upload the product");
		}

		return response;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> list = new ArrayList<>();
		productRepository.findAll().forEach(prod -> list.add(prod));
		return list;
	}

	@Override
	public List<ProductEntity> getSearchedProducts(String productName) {
		if (productName == null || productName.trim().isEmpty()) {

			throw new IllegalArgumentException("Please enter product name");
		}
		return productRepository.findByProductNameContainingIgnoreCase(productName);
	}
	
	@Override
	public void addToCart(int productId, int quantity) {
		ProductEntity product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product not found"));
		CartEntity cart = getCart();
		
		CartItemEntity existingItem = iCartItemRepository
				.findByCartAndProduct(cart, product);
		
		if (existingItem!= null) {
			existingItem.setQuantity(existingItem.getQuantity() + quantity);
			iCartItemRepository.save(existingItem);
			
		} else {
			CartItemEntity item = new CartItemEntity();
			item.setCart(cart);
			item.setProduct(product);
			item.setQuantity(quantity);
			iCartItemRepository.save(item);
		}
	}
	
	private CartEntity getCart() {
		List<CartEntity> cartList = (List<CartEntity>) iCartRepository.findAll();
		
		if (!cartList.isEmpty()) {
			return cartList.get(0);
		}
		 CartEntity cart = new CartEntity();
		return iCartRepository.save(cart);
		
	}
	
	
}
