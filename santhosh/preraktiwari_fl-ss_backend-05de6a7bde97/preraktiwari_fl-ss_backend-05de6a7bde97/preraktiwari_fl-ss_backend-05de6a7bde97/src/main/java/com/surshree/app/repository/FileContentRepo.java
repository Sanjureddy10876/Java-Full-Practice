package com.surshree.app.repository;

import com.surshree.app.domain.entities.FileContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FileContentRepo extends JpaRepository<FileContentEntity, UUID> {

    @Override
    Optional<FileContentEntity> findById(UUID fileContentId);
}
