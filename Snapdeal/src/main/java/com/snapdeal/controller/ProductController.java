package com.snapdeal.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snapdeal.dto.ProductRequestDTO;
import com.snapdeal.dto.ProductResponseDTO;
import com.snapdeal.entity.ProductEntity;
import com.snapdeal.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService iProductService;
	
	@PostMapping("/products")
	public String addProduct(@ModelAttribute ProductRequestDTO productRequestDTO,Model model) {
		ProductResponseDTO response = iProductService.createProduct(productRequestDTO);
		model.addAttribute("response", response);
		return "product-confirm";
	}
	
	@GetMapping("/getAllProducts")
	public String getAllProducts(Model model) {
		List<ProductEntity> productList	= iProductService.getAllProducts();
	List<ProductEntity> avalibleProducts = productList.stream().filter(p -> p.getInventryEntity() !=null && p.getInventryEntity()
				.getAvaliable_qty() > 0).collect(Collectors.toList());
	model.addAttribute("productList", avalibleProducts);
		return "product-confirm";
	}
	
	@GetMapping("/searchProducts")
	public String getSearchedProducts(@RequestParam(value = "searchProductByName", required = false) String name,
			Model model) {
		List<ProductEntity> products = iProductService.getSearchedProducts(name);
		List<ProductEntity> filteredProducts = products.stream().filter(p -> p.getInventryEntity() !=null && p.getInventryEntity()
				.getAvaliable_qty() > 0).collect(Collectors.toList());
		model.addAttribute("productList", filteredProducts);
		return "product-confirm";
	}
	
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestParam("productId")int productId, @RequestParam("quantity") int quantity, Model model) {
		iProductService.addToCart(productId, quantity);
	List<ProductEntity> productList	= iProductService.getAllProducts();
	
		model.addAttribute("productList", model);
		return "cart-products";
	}
	
}
