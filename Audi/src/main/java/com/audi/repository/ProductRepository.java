package com.audi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.audi.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

}
