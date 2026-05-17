package com.lenovo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lenovo.entity.PriceEntity;

import jakarta.transaction.Transactional;

public interface IPriceRepository extends CrudRepository<PriceEntity, Integer> {
	
	@Modifying
	@Transactional
	@Query("delete from PriceEntity p where p.productEntity.productID = :productID")
	void deleteByProductId(@Param("productID") int productID);
}
