package com.surshree.app.repository;

import com.surshree.app.GlobalConstant;
import com.surshree.app.domain.entities.CompetitionEntity;
import com.surshree.app.models.comp.CompetitionSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CompetitionEntityRepoImpl {

    @Autowired
    private EntityManager em;

    public Optional<List<CompetitionEntity>> findUsingCriteria(CompetitionSearchModel searchModel){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CompetitionEntity> cq = cb.createQuery(CompetitionEntity.class);
        Root<CompetitionEntity> compRoot = cq.from(CompetitionEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if(searchModel != null){
            if(searchModel.getCompId() != null){
                predicates.add(cb.equal(compRoot.get("competitionId"), searchModel.getCompId()));
            }
            if(searchModel.getStartDate() != null){
                predicates.add(cb.equal(compRoot.get("startTime"), searchModel.getStartDate()));
            }
            if(searchModel.getEndDate() != null){
                predicates.add(cb.equal(compRoot.get("endTime"), searchModel.getEndDate()));
            }
            if(searchModel.getIsActive() != null && !GlobalConstant.BLANK.equals(searchModel.getIsActive())){
                predicates.add(cb.equal(compRoot.get("isActive"), searchModel.getIsActive()));
            }
            if(searchModel.getIsWinnerAnnounced() != null && !GlobalConstant.BLANK.equals(searchModel.getIsWinnerAnnounced())){
                predicates.add(cb.equal(compRoot.get("isWinnerAnnounced"), searchModel.getIsWinnerAnnounced()));
            }
        }

        if(predicates.size() > 0){
            cq.where(predicates.stream().toArray(Predicate[]::new));
        }

        TypedQuery<CompetitionEntity> query = em.createQuery(cq);
        return Optional.ofNullable(query.getResultList());
    }
}
