package com.surshree.app.models.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String username;

    private String userType;

    private String firstName;

    private String middleName;

    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

    private String isApproved;

    private String isActive;

    private List<String> roles = new ArrayList<>();

    private List<String> functions = new ArrayList<>();

    private String jwt;

    private boolean isUserRegistered = false;

    private boolean isUserProfileComplete = false;
}
