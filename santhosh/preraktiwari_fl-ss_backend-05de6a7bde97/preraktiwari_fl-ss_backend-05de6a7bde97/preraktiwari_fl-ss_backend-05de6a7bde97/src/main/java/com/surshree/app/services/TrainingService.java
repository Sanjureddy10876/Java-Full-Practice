package com.surshree.app.services;

import com.surshree.app.domain.entities.SubscriptionEntity;
import com.surshree.app.domain.entities.TrainingEntity;
import com.surshree.app.repository.SubscriptionRepo;
import com.surshree.app.repository.TrainingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepo trainingRepo;

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    public TrainingEntity save(TrainingEntity entity){
        return this.trainingRepo.save(entity);
    }

    public Optional<TrainingEntity> findById(Long trainingId){
        if(trainingId == null){
            return Optional.empty();
        }
        return this.trainingRepo.findById(trainingId);
    }

    public Optional<List<TrainingEntity>> getAllTrainings(){
        return Optional.ofNullable(this.trainingRepo.findAll());
    }

    public Optional<SubscriptionEntity> getSubscriptionEntityByTrainingIdAndUserId(Long trainingId, Long userId){
        return this.subscriptionRepo.findByBusinessKeyAndSubscriptionTypeAndUserId(trainingId, userId, "TRNG");
    }

    public Optional<List<SubscriptionEntity>> getSubscriptionEntityByUserId(String userId){
        return this.subscriptionRepo.findBySubscriptionTypeAndUserId( userId, "TRNG");
    }

    public Optional<SubscriptionEntity> getSubscriptionByOrderId(String orderId) {
        return this.subscriptionRepo.findByOrderId(orderId);
    }

    @Transactional
    public SubscriptionEntity saveSubscriptionEntity(SubscriptionEntity entity){
        return this.subscriptionRepo.save(entity);
    }
}
