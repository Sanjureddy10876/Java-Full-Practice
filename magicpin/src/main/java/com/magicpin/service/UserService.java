package com.magicpin.service;

import com.magicpin.entity.UserEntity;
import com.magicpin.request.UserRequest;


public interface UserService {
	
	public String doRegistration(UserRequest userRequest);
	
	public UserEntity validateUser(String name, String password, String role);

}
