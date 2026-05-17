package com.magicpin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.magicpin.entity.UserEntity;
import com.magicpin.request.UserRequest;
import com.magicpin.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	@ResponseBody
	public String doRegister(@ModelAttribute UserRequest userRequest, Model model) {
		String response = userService.doRegistration(userRequest);

		model.addAttribute("response", response);

		return "UserRegistration";
	}

//	@GetMapping("/")
//	@ResponseBody
//	public String doLogin(@RequestParam("") String name, @RequestParam("") String password,
//			@RequestParam("") String role, Model model) {
//		String response = userService.doLogin(name, password, role);
//		model.addAttribute("response", response);
//		return "";
//	}
	
	@PostMapping("/login")
	public String doLogin(@RequestParam("userName") String userName,
	                     @RequestParam("password") String password,
	                     @RequestParam("role") String role,
	                     HttpSession session,
	                     Model model)
	{
	    UserEntity entity = userService.validateUser(userName, password, role);

	    if(entity == null) {
	        model.addAttribute("message", "Invalid login details!");
	        model.addAttribute("role", role);
	        return "login";
	    }

	    session.setAttribute("loggedInUser", entity);

	    model.addAttribute("message", "Hello " + entity.getName());
	    return "homeAfterLogin";
	}  


	
}
