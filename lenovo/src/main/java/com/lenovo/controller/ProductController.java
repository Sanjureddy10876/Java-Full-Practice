package com.lenovo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lenovo.entity.ProductEntity;
import com.lenovo.service.IProductService;

@Controller
public class ProductController {
	@Autowired
	private IProductService iProductService;
	
	@RequestMapping("getAllProducts")
	public String getAllProducts(Model model) {
	List<ProductEntity> list = iProductService.getAllProducts();
	model.addAttribute("response",list);
		return "product-results";
	}
	
	@GetMapping("searchByName")
	public String searchProducts(@RequestParam(value = "search") String productName, Model model) {
	List<ProductEntity> productList	=iProductService.findByProductName(productName);
	model.addAttribute("response", productList);
		return "product-results";
	}
	
	@PostMapping("deleteProduct")
	public String deleteProduct(@RequestParam("productID") int productID, Model model) {
		 iProductService.deleteProduct(productID);
		 List<ProductEntity> result = new ArrayList<>();
		model.addAttribute("response", result);
		return "product-results";
	}

}
