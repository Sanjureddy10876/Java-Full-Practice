package com.magicpin.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime order_date;
	
	private double total_amount;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;
	
	@OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
	private List<OrderItemsEntity> orderItemsEntity;

	public Long getId() {
		return id;
	}

	public LocalDateTime getOrder_date() {
		return order_date;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public List<OrderItemsEntity> getOrderItemsEntity() {
		return orderItemsEntity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public void setOrderItemsEntity(List<OrderItemsEntity> orderItemsEntity) {
		this.orderItemsEntity = orderItemsEntity;
	}
	
	
}
