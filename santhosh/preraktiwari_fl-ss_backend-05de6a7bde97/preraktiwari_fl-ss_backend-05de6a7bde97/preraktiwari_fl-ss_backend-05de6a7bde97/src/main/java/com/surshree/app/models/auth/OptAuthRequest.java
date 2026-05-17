package com.surshree.app.models.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OptAuthRequest {
    public String phoneNo;
    public String otp;
}
