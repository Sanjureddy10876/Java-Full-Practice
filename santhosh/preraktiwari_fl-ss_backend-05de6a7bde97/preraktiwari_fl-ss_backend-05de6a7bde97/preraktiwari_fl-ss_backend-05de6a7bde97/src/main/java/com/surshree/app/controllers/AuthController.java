package com.surshree.app.controllers;

import com.surshree.app.domain.entities.BaseEntity;
import com.surshree.app.domain.entities.UserDetailsEntity;
import com.surshree.app.domain.entities.UserEntity;
import com.surshree.app.models.auth.AuthRequest;
import com.surshree.app.models.auth.AuthResponse;
import com.surshree.app.models.auth.OptAuthRequest;
import com.surshree.app.services.CustomUserDetailsService;
import com.surshree.app.services.OtpService;
import com.surshree.app.util.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private OtpService otpService;

    @CrossOrigin(allowedHeaders = "*")
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody AuthRequest request) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect Username or Password specified", e);
        }
        final UserEntity user = (UserEntity)userService.loadUserByUsername(request.getUsername());

        String jwt = jwtHelper.generateTokenRegisteredUser(user);

        AuthResponse response = new AuthResponse();

        setAuthResponse(user, jwt, response);
        return ResponseEntity.ok(response);
    }

    private void setAuthResponse(UserEntity user, String jwt, AuthResponse response) {
        BeanUtils.copyProperties(user,response);
        response.setJwt(jwt);
        if(user.getRoleMapping() != null) {
            response.setRoles(user.getRoleMapping().stream().map(r -> r.getRoleName()).collect(Collectors.toList()));
            user.getRoleMapping().stream().forEach(r -> response.getFunctions().addAll(r.getFunctions().stream().map(f->f.getFuncName()).collect(Collectors.toList())));
        }
        response.setUserRegistered(true);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/auth/otp/{userName}", method = RequestMethod.GET)
    public ResponseEntity getOtp(@PathVariable String userName){
        String generatedOtp = null;
        OptAuthRequest response = new OptAuthRequest();
        try{
            final UserEntity user = (UserEntity)userService.loadUserByUsername(userName);
            generatedOtp = otpService.generateOTP(userName);
        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("Your mobile number " + userName + " is not registered with Sur Shree App. Please register yourself in order to use Sur Shree App.");
        }
        System.out.println("otp --> " + generatedOtp);
        response.setPhoneNo(userName);
        response.setOtp("OTP Generated Successfully. --> " + generatedOtp);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/auth/otp/newuser/{userName}", method = RequestMethod.GET)
    public ResponseEntity getOtpForNewUser(@PathVariable String userName){
        String generatedOtp;
        OptAuthRequest response = new OptAuthRequest();
        try{
            final UserEntity user = (UserEntity)userService.loadUserByUsername(userName);
            throw new ValidationException("Your mobile number " + userName + " is already registered with Sur Shree App.");
        }catch (UsernameNotFoundException e){
            generatedOtp = otpService.generateOTP(userName);
        }
        System.out.println("otp --> " + generatedOtp);
        response.setPhoneNo(userName);
        response.setOtp("OTP Generated Successfully. --> " + generatedOtp);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/auth/otp", method = RequestMethod.POST)
    public ResponseEntity validateOtp(@RequestBody OptAuthRequest authRequest){
        System.err.println(authRequest.getPhoneNo());
        AuthResponse response = new AuthResponse();
        boolean isValidOtp = otpService.validateOtp(authRequest.getPhoneNo(), authRequest.getOtp());
        if(isValidOtp){
            //this.otpService.clearOTP(authRequest.getPhoneNo());
            try{
                final UserEntity user = (UserEntity)userService.loadUserByUsername(authRequest.getPhoneNo());
                String jwt = jwtHelper.generateTokenRegisteredUser(user);
                setAuthResponse(user, jwt, response);

                UserDetailsEntity userDetailsEntity = userService.loadUserDetailsByUserName(authRequest.getPhoneNo());
                Optional<? extends BaseEntity> userTypeDetails = userService.getUserTypeDetailsByUserType(user);
                if(userDetailsEntity != null && userTypeDetails.isPresent()){
                    response.setUserProfileComplete(true);
                }
            }catch (Exception e){
                log.error(String.format("You phone number %s is not registered with Sur Shree App.", authRequest.getPhoneNo()), e);
                final UserEntity user = new UserEntity();
                user.setUsername(authRequest.getPhoneNo());
                String jwt = jwtHelper.generateTokenUnRegisteredUser(user);
                setAuthResponse(user, jwt, response);
                response.setUserRegistered(false);
            }
        }else{
            throw new ValidationException("OTP verification failed. Please enter correct OTP.");
        }
        return ResponseEntity.ok(response);
    }
}
