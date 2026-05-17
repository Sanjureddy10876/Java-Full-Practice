package com.swigy.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.swigy.app.entity.ProductRequest;
import com.swigy.app.entity.ProductResponse;
import com.swigy.app.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	IProductService iproductservice;
	
	@PostMapping("foods")
	public String addProduct(@ModelAttribute ProductRequest productRequest, Model model) {
	ProductResponse responseProduct1 = iproductservice.createProduct(productRequest);
		model.addAttribute("response", responseProduct1);
		return "View-foods";
	}

}
