package com.magicpin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magicpin.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{

	List<CartEntity> findByUserEntityId(Long userId);
	
	CartEntity findByUserEntityIdAndProductEntityId(Long userId, Long productId);
}
