package service;

import java.util.Map;

import entity.ProductEntity;
import execptions.EmptyCartExeception;
import execptions.OutOfStockException;

public class CheckOutService {

	public void processCheckout(CartService cartService) throws EmptyCartExeception, OutOfStockException {
		Map<ProductEntity, Integer> cart = cartService.getCartList();

		if (cart.isEmpty()) {
			throw new EmptyCartExeception("Your cart is empty please add items to Checkout");
		}
		for (Map.Entry<ProductEntity, Integer> entry : cart.entrySet()) {
			ProductEntity productEntity = entry.getKey();
			int requestedValue = entry.getValue();
			if (productEntity.getQty() <= requestedValue) {
				throw new OutOfStockException(
						"Not enough stock is left" + productEntity.getName() + "Avalible" + productEntity.getQty());

			}
		}
		double totalAmount = 0;
		System.out.println("\n--- Final Bill ---");
		for (Map.Entry<ProductEntity, Integer> entry : cart.entrySet()) {
			ProductEntity productEntity = entry.getKey();
			int qty = entry.getValue();

			productEntity.reduceQuantity(qty);

			double itemTotal = productEntity.getPrice() * qty;
			totalAmount += itemTotal;

		}
		System.out.println("------------------");
		System.out.println("Total Amount: Rs" + totalAmount);
		System.out.println("Thank you for shopping with us");

		cartService.clearCart();

	}
}
