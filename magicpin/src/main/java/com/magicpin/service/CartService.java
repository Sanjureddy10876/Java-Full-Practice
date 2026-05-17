package com.magicpin.service;

import java.util.List;

import com.magicpin.entity.CartEntity;

public interface CartService {
	 List<CartEntity> getCartItems(Long userId);

	public String addToCart(Long userId, Long productId, int quantity);
}
