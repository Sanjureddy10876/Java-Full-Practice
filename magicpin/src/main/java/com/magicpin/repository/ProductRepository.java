package com.magicpin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicpin.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
    List<ProductEntity> findByNameContainingIgnoreCase(String name);
    List<ProductEntity> findByStatus(String status);
    


}
