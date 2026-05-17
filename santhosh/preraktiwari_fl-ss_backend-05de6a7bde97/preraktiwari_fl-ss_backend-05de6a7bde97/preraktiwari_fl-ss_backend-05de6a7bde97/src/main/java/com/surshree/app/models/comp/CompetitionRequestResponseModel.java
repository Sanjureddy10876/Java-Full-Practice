package com.surshree.app.models.comp;

import com.surshree.app.domain.entities.CompetitionEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CompetitionRequestResponseModel {
    private Long competitionId;

    private String competitionCategory;

    private String title;

    private String description;

    private Date startTime;

    private Date endTime;

    private int minAge;

    private int maxAge;

    private String isActive;

    private String isSubscriptionRequired;

    private BigDecimal subscriptionPrice;

    private String isWinnerAnnounced;

    private String compPhoto;

    public CompetitionRequestResponseModel(CompetitionEntity compEntity){
        super();
        BeanUtils.copyProperties(compEntity, this);
        if(compEntity.getCompPhoto() != null) {
            this.setCompPhoto(compEntity.getCompPhoto().toString());
        }
    }
}
