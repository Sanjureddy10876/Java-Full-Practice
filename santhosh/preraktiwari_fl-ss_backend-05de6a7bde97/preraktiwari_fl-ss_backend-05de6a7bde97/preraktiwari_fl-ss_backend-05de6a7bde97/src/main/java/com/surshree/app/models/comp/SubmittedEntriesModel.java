package com.surshree.app.models.comp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SubmittedEntriesModel {
    private Long competitionId;

    private String compTitle;

    private String compDesc;

    private String compPhoto;

    private Long submittedEntriesId;

    private String username;

    private String gender;

    private String fullUserName;

    private String state;

    private String city;

    private String isWinner;

    private String isShortlisted;

    private BigDecimal priceWon;

    private String winnerDesc;

    private String fileId;

    private String userProfile;

    private int age;

    private boolean expanded = false;
}
