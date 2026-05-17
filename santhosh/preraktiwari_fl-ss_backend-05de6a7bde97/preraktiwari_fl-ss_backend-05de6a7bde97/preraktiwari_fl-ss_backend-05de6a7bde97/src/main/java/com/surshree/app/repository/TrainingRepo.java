package com.surshree.app.repository;

import com.surshree.app.domain.entities.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingRepo extends JpaRepository<TrainingEntity, Long> {
}
