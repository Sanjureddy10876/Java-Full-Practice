package com.swish.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_info")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	private String name;
	
	@Column(name = "order_description")
	private String orderDescription;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	
	private String orderedBy;
	
	

	@OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<FoodEntity> foodEntities;
	
	public OrderEntity() {
		
	}

	
	public OrderEntity(Long order_id, String name, String orderDescription, String paymentMethod, String orderedBy,
			List<FoodEntity> foodEntities) {
		super();
		this.order_id = order_id;
		this.name = name;
		this.orderDescription = orderDescription;
		this.paymentMethod = paymentMethod;
		this.orderedBy = orderedBy;
		this.foodEntities = foodEntities;
	}

	public String getOrderDescription() {
		return orderDescription;
	}


	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}

	public List<FoodEntity> getFoodEntities() {
		return foodEntities;
	}

	public void setFoodEntities(List<FoodEntity> foodEntities) {
		this.foodEntities = foodEntities;
	}
	
	

}
