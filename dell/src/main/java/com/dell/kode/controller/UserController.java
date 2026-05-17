
package com.dell.kode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.kode.entiry.UserEntity;
import com.dell.kode.service.UserService;

@RestController
@RequestMapping("/user/api/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String register(@RequestBody UserEntity request) {
		
		
		return userService.doLogin(request.getUsername(), request.getPassword());
	}

}
