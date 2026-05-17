package com.lenovo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenovo.entity.ProductEntity;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity, Integer> {


	List<ProductEntity> findByProductName(String productName);

}
