package com.magicpin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magicpin.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	boolean existsByEmail(String email);  
	
	UserEntity findByNameAndPasswordAndRole(String name,String password,String role);
	
}
