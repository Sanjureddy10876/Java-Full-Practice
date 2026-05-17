package com.swish.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swish.dto.OrderRequest;
import com.swish.dto.OrderResponse;
import com.swish.entity.FoodEntity;
import com.swish.entity.OrderEntity;
import com.swish.repository.OrderRepository;
import com.swish.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;


	@Override
	public OrderResponse createnewOrder(OrderRequest orderRequest) {

		String foodname = orderRequest.getFoodName();
		String foodtype = orderRequest.getFoodtype();
		String orderedby = orderRequest.getOrderedby();
		String phonenum = orderRequest.getPhoneNumber();

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setName(foodname);
		orderEntity.setOrderedBy(orderedby);
		orderEntity.setPaymentMethod(phonenum);

		FoodEntity entity = new FoodEntity();
		entity.setFoodName(foodname);

		List<FoodEntity> foodList = new ArrayList<>();
		foodList.add(entity);
		entity.setOrderEntity(orderEntity);

		orderEntity.setFoodEntities(foodList);
		OrderResponse response = new OrderResponse();
		Long orderID = orderEntity.getOrder_id();
		orderRepository.save(orderEntity);

		if (orderID != null) {
			response.setId(orderID);
			response.setConfirmMsg("Your order is Confirmed Please wait for Delivery");
		} else {
			response.setId(orderID);
			response.setConfirmMsg("Unable to Process the order Please Try again");
		}

		return response;
	}
	

	@Override
	public List<OrderEntity> getAllProducts() {
		return (List<OrderEntity>) orderRepository.findAll();
	}
	
	
	@Override
	public void findAllorders() {
	Iterable<OrderEntity> orders =orderRepository.findAll();
	Iterator<OrderEntity> orderitr = orders.iterator();
	
	while (orderitr.hasNext()) {
		OrderEntity orderEntity = orderitr.next();
		
		List<FoodEntity> foods = orderEntity.getFoodEntities();
		for (FoodEntity food : foods) {
			System.out.println("Food Name :: "+food.getFoodName());
			System.out.println("Food id :: "+food.getId());
		}
		
	}
		
	}
}
