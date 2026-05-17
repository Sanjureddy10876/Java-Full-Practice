package com.surshree.app.repository;

import com.surshree.app.domain.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepo extends JpaRepository<SubscriptionEntity, Long> {
    Optional<SubscriptionEntity> findByBusinessKeyAndSubscriptionTypeAndUserId(Long businessKey, Long userId, String subscriptionType);

    Optional<List<SubscriptionEntity>> findBySubscriptionTypeAndUserId(String userId, String subscriptionType);

    Optional<SubscriptionEntity> findByOrderId(String orderId);
}
