package com.swish.service;

import java.util.List;

import com.swish.dto.OrderRequest;
import com.swish.dto.OrderResponse;
import com.swish.entity.OrderEntity;

public interface OrderService {

	public OrderResponse createnewOrder(OrderRequest orderRequest);

	public	List<OrderEntity> getAllProducts();
	
	public void findAllorders();
	
}
