package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "T_COMPETITION")
public class CompetitionEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPETITION_ID")
    private Long competitionId;

    @Column(name = "COMPETITION_CATEGORY")
    private String competitionCategory;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "MIN_AGE")
    private int minAge;

    @Column(name = "MAX_AGE")
    private int maxAge;

    @Column(name = "IS_ACTIVE")
    private String isActive;

    @Column(name = "IS_SUBSCRIPTION_REQUIRED")
    private String isSubscriptionRequired;

    @Column(name = "SUBSCRIPTION_PRICE")
    private BigDecimal subscriptionPrice;

    @Column(name = "IS_WINNER_ANNOUNCED")
    private String isWinnerAnnounced;

    @Column(name = "COMP_PHOTO")
    private UUID compPhoto;
}
