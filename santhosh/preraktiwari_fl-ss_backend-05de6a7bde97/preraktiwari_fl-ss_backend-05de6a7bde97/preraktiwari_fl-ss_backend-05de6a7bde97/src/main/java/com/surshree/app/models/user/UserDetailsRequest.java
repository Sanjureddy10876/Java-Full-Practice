package com.surshree.app.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsRequest {

    private Long userDetailsId;

    private String phoneNo;

    private String emailAddress;

    private String addressLine1;

    private String addressLine2;

    private String addressCity;

    private String addressState;

    private String addressPin;

    private String addressCountry;

    private String aadharNo;

    private String aadharPhoto;

    private String profileVideo;

    private String profilePicture;
}
