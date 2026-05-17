package com.crud.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.app.entity.EmployeeEntity;

@Repository
public interface EmployeerRepository extends JpaRepository<EmployeeEntity, Long> {

}
