package com.magicpin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.magicpin.entity.CartEntity;
import com.magicpin.entity.UserEntity;
import com.magicpin.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/addToCart")
	public String addToCart(@RequestParam("productId") Long productId, @RequestParam("quantity") int quantity,
			HttpSession session, Model model) {

		UserEntity user = (UserEntity) session.getAttribute("loggedInUser");

		if (user == null) {
			return "redirect:/loginForm?role=USER";
		}
		System.out.println("user :: "+user.getName());

		String message = cartService.addToCart(user.getId(), productId, quantity);

		model.addAttribute("message", message);

		return "UserproductDashboard";
	}

	@GetMapping("/viewCart")
	public String viewCart(HttpSession session, Model model) {

		UserEntity user = (UserEntity) session.getAttribute("loggedInUser");

		if (user == null) {
			return "redirect:/loginForm?role=USER";
		}

		List<CartEntity> cartList = cartService.getCartItems(user.getId());

		double totalAmount = 0;

		for (CartEntity cart : cartList) {
			double price = cart.getProductEntity().getPrice();
			int qty = cart.getQuantity();
			totalAmount += price * qty;
		}

		model.addAttribute("cartList", cartList);
		model.addAttribute("totalAmount", totalAmount);

		return "cart";
		
		
	}
}
