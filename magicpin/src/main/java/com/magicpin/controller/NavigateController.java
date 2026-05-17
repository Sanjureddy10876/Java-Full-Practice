package com.magicpin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavigateController {
	
	@GetMapping("/UserReg")
	public String navidoRegistration() {
		
		return "UserRegistration";
	}

	@GetMapping("/AdminReg")
	public String adminnavidoRegistration() {
		
		return "UserRegistration";
	}
	
	@GetMapping("/productPage")
	public String pager() {
		
		return "productDashboard";
	}
	
	@GetMapping("loginForm")
	public String showLoginForm(@RequestParam("role") String role, Model model) {
	    model.addAttribute("role", role);
	    return "login";
	}
	

}
