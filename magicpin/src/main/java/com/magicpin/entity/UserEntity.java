package com.magicpin.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	private String role;
	
	public UserEntity() {
		
	}
	
	@OneToMany(mappedBy = "userEntity", cascade =  CascadeType.ALL)
	private List<CartEntity> cartEntity;
	
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private List<OrderEntity> orderEntity;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public List<CartEntity> getCartEntity() {
		return cartEntity;
	}

	public List<OrderEntity> getOrderEntity() {
		return orderEntity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setCartEntity(List<CartEntity> cartEntity) {
		this.cartEntity = cartEntity;
	}

	public void setOrderEntity(List<OrderEntity> orderEntity) {
		this.orderEntity = orderEntity;
	}

	
	
}
