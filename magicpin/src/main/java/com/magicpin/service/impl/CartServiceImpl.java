package com.magicpin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicpin.entity.CartEntity;
import com.magicpin.entity.ProductEntity;
import com.magicpin.entity.UserEntity;
import com.magicpin.repository.CartRepository;
import com.magicpin.repository.ProductRepository;
import com.magicpin.repository.UserRepository;
import com.magicpin.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CartEntity> getCartItems(Long userId) {
	    return (List<CartEntity>) cartRepository.findByUserEntityId(userId);
	}

	@Override
	public String addToCart(Long userId, Long productId, int quantity) {
		CartEntity cart = cartRepository.findByUserEntityIdAndProductEntityId(userId, productId);

		if (cart != null) {

			cart.setQuantity(cart.getQuantity() + quantity);
		} else {

			UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

			ProductEntity product = productRepository.findById(productId)
					.orElseThrow(() -> new RuntimeException("Product not found"));

			cart = new CartEntity();
			cart.setUserEntity(user);
			cart.setProductEntity(product);
			cart.setQuantity(quantity);
		}

		cartRepository.save(cart);

		return "Item added to cart successfully!";
	}

}
