package com.surshree.app.models.comp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CompetitionSearchModel {
    private Long compId;

    private Date startDate;

    private Date endDate;

    private String isActive;

    private String isWinnerAnnounced;
}
