package com.surshree.app.repository;

import com.surshree.app.domain.entities.BaseEntity;
import com.surshree.app.domain.entities.MstStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MstStateEntityRepo extends JpaRepository<MstStateEntity, String> {

    List<MstStateEntity> findAll();

}
