package com.snapdeal.repository;

import org.springframework.data.repository.CrudRepository;

import com.snapdeal.entity.CartEntity;

public interface ICartRepository extends CrudRepository<CartEntity, Integer> {

	CartEntity findByUserId(int userId);
}
