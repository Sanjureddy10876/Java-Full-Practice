package com.dell.kode.service.impl;

import org.springframework.stereotype.Service;

import com.dell.kode.exception.UserNotFoundException;
import com.dell.kode.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	@Override
	public String doLogin(String username, String password) {
		
		if(username.equals("santhosh")&& password.equals("santhosh")) {
			
			return "Login success";
		}
		
		throw new UserNotFoundException("Invalid Username or Password");
		
	}

}
