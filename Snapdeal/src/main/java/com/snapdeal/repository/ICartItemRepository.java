package com.snapdeal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snapdeal.entity.CartEntity;
import com.snapdeal.entity.CartItemEntity;
import com.snapdeal.entity.ProductEntity;

@Repository
public interface ICartItemRepository extends CrudRepository<CartItemEntity, Integer> {

    CartItemEntity findByCartAndProduct(CartEntity cart, ProductEntity product);

}
