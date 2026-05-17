package com.swish.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.swish.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer>{

	//this solves n+1 problem we have two ways to solve one is @entitygraph and 
	// anotherone is @query (fetch join) (when we have validations we use fetch join for control)
	
	@Override
	@EntityGraph(attributePaths = "foodEntities")
	public Iterable<OrderEntity> findAll();

}
