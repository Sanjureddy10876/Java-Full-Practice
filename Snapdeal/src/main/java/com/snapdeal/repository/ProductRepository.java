package com.snapdeal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snapdeal.entity.CartEntity;
import com.snapdeal.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

	List<ProductEntity> findByProductNameContainingIgnoreCase(String productName);
	CartEntity findByUserId(int userId);
}
