package com.magicpin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.magicpin.entity.ProductEntity;
import com.magicpin.repository.ProductRepository;
import com.magicpin.request.ProductRequest;
import com.magicpin.request.ProductResponse;
import com.magicpin.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/addProduct")
	@ResponseBody
	public String addProduct(@ModelAttribute ProductRequest productRequest, Model model) {
		String response	=productService.addProduct(productRequest);
		model.addAttribute("message", response);
		return "";
	}
	
	@PostMapping("/updateProduct")
	@ResponseBody
	public String updateProduct(@RequestParam("id") Long id, @ModelAttribute ProductRequest productRequest, Model model) {
	String response	= productService.updateProduct(id,productRequest);
		model.addAttribute("message", response);
	return "";	
	}
	
	@PostMapping("/deleteProduct")
	@ResponseBody
	public String deleteProduct(@RequestParam("id") Long id,@RequestParam("status") String status, Model model ) {
	String response	= productService.deleteProduct(id, status);
		model.addAttribute("message", response);
		return "";
	}
	@GetMapping("/searchProduct")
	public String searchProduct(@RequestParam("name") String name, Model model) {
	 List<ProductResponse> response = productService.searchProduct(name);
	 model.addAttribute("message", response);
		return "productDashboard";
	}
	
	@GetMapping("/viewProducts")
	public String findAllProducts(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") String status, Model model) {
		List<ProductResponse> response = productService.findAllProducts(status);
		model.addAttribute("products", response);
		model.addAttribute("selectedStatus", status);
		return "productDashboard";
	}
	@GetMapping("/viewAll")
	public String findAlluserProducts(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") String status, Model model) {
		List<ProductResponse> response = productService.findAllProducts(status);
		model.addAttribute("products", response);
		model.addAttribute("selectedStatus", status);
		return "UserproductDashboard";
	}
	
	
	
	@GetMapping("/editProduct")
	public String editProduct(@RequestParam("id") Long id, Model model) {

	    ProductEntity product = productRepository.findById(id).orElse(null);

	    model.addAttribute("editProduct", product);

	    List<ProductResponse> products = productService.findAllProducts("ACTIVE");
	    model.addAttribute("products", products);

	    return "productDashboard";
	}
	
}
