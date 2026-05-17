package com.rolex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rolex.request.ProductRequest;
import com.rolex.request.ProductResponse;
import com.rolex.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	IProductService iProductService;
	
	@PostMapping("products")
	public String createProduct(@ModelAttribute ProductRequest request, Model model) {
		ProductResponse response = iProductService.createProduct(request);
		model.addAttribute("response", response);
		return "product-confirm";
	}
}
