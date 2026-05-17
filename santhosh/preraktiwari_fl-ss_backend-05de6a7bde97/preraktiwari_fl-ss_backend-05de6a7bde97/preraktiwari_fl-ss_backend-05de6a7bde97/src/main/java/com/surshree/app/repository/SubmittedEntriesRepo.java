package com.surshree.app.repository;

import com.surshree.app.domain.entities.SubmittedEntriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubmittedEntriesRepo extends JpaRepository<SubmittedEntriesEntity, Long> {
    Optional<List<SubmittedEntriesEntity>> findByUserId(Long userId);

    Optional<List<SubmittedEntriesEntity>> findByCompetitionId(Long competitionId);

    Optional<List<SubmittedEntriesEntity>> findByCompetitionIdAndIsShortlisted(Long competitionId);

    Optional<List<SubmittedEntriesEntity>> findByCompetitionIdAndIsWinnerAnnounced(Long competitionId);

    Optional<List<SubmittedEntriesEntity>> findAllByIsWinnerAnnounced();
}
