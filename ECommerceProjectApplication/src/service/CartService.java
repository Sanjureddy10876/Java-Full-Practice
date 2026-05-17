package service;

import java.util.HashMap;
import java.util.Map;

import entity.ProductEntity;

public class CartService {

	Map<ProductEntity, Integer> cartList = new HashMap<>();

	public void addProductToCart(ProductEntity productEntity, int quantity) {
		cartList.put(productEntity, cartList.getOrDefault(productEntity, 0) + quantity);
		System.out.println(productEntity.getName() + "added to cart sucessfully");
	}

	public void removeProductFromCart(ProductEntity productEntity) {
		if (cartList.containsKey(productEntity)) {
			cartList.remove(productEntity);
			System.out.println(productEntity.getName() + "Product is removed from cart");
		} else {
			System.out.println("Product is not in your cart");
		}
	}

	public void updateQuality(ProductEntity productEntity, int newQuality) {
		if (cartList.containsKey(productEntity)) {
			if (newQuality <= 0) {
				removeProductFromCart(productEntity);
			} else {
				cartList.put(productEntity, newQuality);
				System.out.println("Quantity updated " + productEntity.getName());
			}
		} else {
			System.out.println("product is not in your cart");
		}
	}

	public void viewCart() {
		if (cartList.isEmpty()) {
			System.out.println("Your Cart is empty");
			return;
		}
		System.out.println("\n--- Your Cart ---");
		for (Map.Entry<ProductEntity, Integer> entry : cartList.entrySet()) {
			System.out.println(entry.getKey().getName() + " Qty " + entry.getValue() + " Price "
					+ entry.getKey().getPrice() * entry.getValue());
		}
		System.out.println("-----------------");
	}

	public Map<ProductEntity, Integer> getCartList() {
		return cartList;
	}

	public void clearCart() {
		cartList.clear();
	}

}
