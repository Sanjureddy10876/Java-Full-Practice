package com.surshree.app.models.training;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TrainingModel {
    private Long trainingId;

    private List<TrainingContentModel> trainingContents;

    private String category;

    private String trainingName;

    private String trainingDesc;

    private String isSubscriptionRequired;

    private BigDecimal subscriptionAmount;

    private String trainingPhoto;

    private Boolean isSubscribed = Boolean.FALSE;
}
