package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "T_TRAINING")
public class TrainingEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRAINING_ID")
    private Long trainingId;

    @OneToMany(mappedBy = "trainingEntity", cascade = CascadeType.PERSIST)
    private Set<TrainingContentEntity> trainingContents = new HashSet<>();

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "TRAINING_NAME")
    private String trainingName;

    @Column(name = "TRAINING_DESC")
    private String trainingDesc;

    @Column(name = "IS_SUBSCRIPTION_REQUIRED")
    private String isSubscriptionRequired;

    @Column(name = "SUBSCRIPTION_PRICE")
    private BigDecimal subscriptionAmount;

    @Column(name = "TRAINING_PHOTO")
    private UUID trainingPhoto;

}
