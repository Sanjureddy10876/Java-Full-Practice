package com.swish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "food_info")
public class FoodEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "food_name")
	private String foodName;
	
	private String description;
	
	private Long price;
	
	private Long qty;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity orderEntity;

	public FoodEntity() {
		
	}
	public FoodEntity(Long id, String foodName, String description, Long price, Long qty, OrderEntity orderEntity) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.description = description;
		this.price = price;
		this.qty = qty;
		this.orderEntity = orderEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}
	
	

}
