package com.nothing.repository;

import org.springframework.data.repository.CrudRepository;

import com.nothing.entity.PhoneEntity;

public interface PhoneRepository  extends CrudRepository<PhoneEntity, Integer>{

}
