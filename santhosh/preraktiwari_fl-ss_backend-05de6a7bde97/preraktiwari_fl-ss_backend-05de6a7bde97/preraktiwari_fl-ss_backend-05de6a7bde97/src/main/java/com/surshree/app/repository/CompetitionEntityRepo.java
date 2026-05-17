package com.surshree.app.repository;

import com.surshree.app.domain.entities.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompetitionEntityRepo extends JpaRepository<CompetitionEntity, Long> {
    Optional<List<CompetitionEntity>> findByIsActiveAndIsWinnerAnnouncedOrderByCreatedTsDesc(String isActive, String isWinnerAnnounced);
}
