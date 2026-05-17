package com.surshree.app.models.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequest {
    private String username;

    private String otp;

    private String password;

    private String userType;

    private String firstName;

    private String middleName;

    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

    private String gender;

    private String country;

    private String state;

    private String city;

    private String aadharNo;

    private String aadharPhoto;

    private String profileVideo;

    private String profilePicture;

    private String getProfileDescription;
}
