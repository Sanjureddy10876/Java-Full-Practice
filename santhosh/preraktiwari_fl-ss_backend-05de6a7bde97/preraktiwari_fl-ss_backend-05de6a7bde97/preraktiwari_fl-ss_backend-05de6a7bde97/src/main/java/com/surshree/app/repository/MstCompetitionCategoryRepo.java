package com.surshree.app.repository;

import com.surshree.app.domain.entities.MstCompetitionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MstCompetitionCategoryRepo extends JpaRepository<MstCompetitionCategory, String> {
}
