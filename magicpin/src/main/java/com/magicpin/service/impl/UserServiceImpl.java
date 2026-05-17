package com.magicpin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicpin.entity.UserEntity;
import com.magicpin.repository.UserRepository;
import com.magicpin.request.UserRequest;
import com.magicpin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String doRegistration(UserRequest userRequest) {
		String Name = userRequest.getName();
		String Mail = userRequest.getEmail();
		String Phone = userRequest.getPhone();
		String Password = userRequest.getPassword();
		String Role = userRequest.getRole();

		boolean available = userRepository.existsByEmail(Mail);

		if (available) {
			return "User is Already Registered Please try with another mail";
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setName(Name);
		userEntity.setPassword(Password);
		userEntity.setEmail(Mail);
		userEntity.setPhone(Phone);
		userEntity.setRole(Role);

		userRepository.save(userEntity);

		return "Registration Successful";
	}

//	@Override
//	public String doLogin(String name, String password, String role) {
//
//		String userlogin = userRepository.findByNameAndPasswordAndRole(name, password, role);
//		if (userlogin == null) {
//			return "user is invalid please try again";
//		}
//		return "Login Successfull";
//	}

	@Override
	public UserEntity validateUser(String name, String password, String role) {
	    return userRepository.findByNameAndPasswordAndRole(name, password, role);
	}

}
