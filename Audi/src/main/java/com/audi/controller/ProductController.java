	package com.audi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.audi.request.ProductRequest;
import com.audi.request.ProductResponse;
import com.audi.service.IProductService;

@Controller
public class ProductController {

	
	@Autowired
	private IProductService iProductService;
	
	@PostMapping("products")
	@ResponseBody
	public String createProduct(@ModelAttribute ProductRequest productRequest, Model model) { 
		ProductResponse productResponse=iProductService.createProduct(productRequest);
		model.addAttribute("response", productResponse);
		
		return "product-confirm";
	}
}
