package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "T_SUBSCRIPTION")
@NamedQueries(
        {
                @NamedQuery(name = "SubscriptionEntity.findByBusinessKeyAndSubscriptionTypeAndUserId", query = "from SubscriptionEntity se join fetch se.userEntity ue where se.businessKey = :businessKey and ue.userId = :userId and se.subscriptionType=:subscriptionType"),
                @NamedQuery(name = "SubscriptionEntity.findBySubscriptionTypeAndUserId", query = "from SubscriptionEntity se join fetch se.userEntity ue where ue.username = :userId and se.subscriptionType=:subscriptionType")

        }
)
public class SubscriptionEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBSCRIPTION_ID")
    private Long subscriptionId;

    @Column(name = "BUSINESS_KEY")
    private Long businessKey;

    @Column(name = "SUBSCRIPTION_TYPE")
    private String subscriptionType;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;

    @Column(name="AMOUNT_PAID")
    private BigDecimal amountPaid;

    @Column(name="SUBSCRIPTION_UUID")
    private UUID subscriptionUuid;

    @Column(name="IS_SUCCESSFUL")
    private String isSuccessful;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name="TRANSACTION_ID")
    private String transactionId;

    @Column(name="ERROR_CODE")
    private String errorCode;

    @Column(name="ERROR_DESC")
    private String errorDesc;
}
