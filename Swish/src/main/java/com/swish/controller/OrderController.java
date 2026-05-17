package com.swish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swish.dto.OrderRequest;
import com.swish.dto.OrderResponse;
import com.swish.entity.OrderEntity;
import com.swish.service.OrderService;
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/createNewOrder")
	public String createOrder(@ModelAttribute OrderRequest orderRequest, Model model) {
	OrderResponse response = orderService.createnewOrder(orderRequest);
		model.addAttribute("response", response);
		
		return "order-confirm";
	}
	
	@GetMapping("/getOrderDetails")
	public String getOrderdetails(Model model) {
		 Iterable<OrderEntity> response = orderService.getAllProducts();
		model.addAttribute("response", response);
		return "order-details";
	}
	
	@GetMapping("/getAllcategry")
	@ResponseBody
	public String findAllCategry() {
	 orderService.findAllorders();
	 
	
	return "";
	}
}
