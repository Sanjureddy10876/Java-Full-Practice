package com.surshree.app.controllers;

import com.surshree.app.domain.entities.*;
import com.surshree.app.models.auth.AuthResponse;
import com.surshree.app.models.user.UpdateUserRequest;
import com.surshree.app.models.user.UserDetailsRequest;
import com.surshree.app.models.user.UserDetailsResponse;
import com.surshree.app.services.CustomUserDetailsService;
import com.surshree.app.services.OtpService;
import com.surshree.app.services.RoleService;
import com.surshree.app.util.ControllerUtils;
import com.surshree.app.util.UserContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private OtpService otpService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity setupUserInitialDetails(@RequestBody UpdateUserRequest userRequest){
        UserEntity user = null;
        try{

//            replaced with the static value with this userRequest.getUsername()
            user = (UserEntity)this.userService.loadUserByUsername(userRequest.getUsername());
            throw new ValidationException("Your mobile number " + userRequest.getUsername() + " is already registered with Sur Shree App.");
        }catch (Exception e){
            user = new UserEntity();
        }

        UserDetailsEntity userDetails = null;
        boolean isValidOtp = otpService.validateOtp(userRequest.getUsername(), userRequest.getOtp());
        if(!isValidOtp){
            throw new ValidationException("OTP verification failed. Please enter correct OTP.");
        }
        BeanUtils.copyProperties(userRequest,user,"userId");
        user.setIsActive("1");
        user.setIsApproved("1");

        userDetails = new UserDetailsEntity();

        BeanUtils.copyProperties(userRequest, userDetails);
        userDetails.setAadharPhoto(UUID.fromString(userRequest.getAadharPhoto()));

        userDetails.getAddress().setAddressCity(userRequest.getCity());
        userDetails.getAddress().setAddressCountry(userRequest.getCountry());
        userDetails.getAddress().setAddressState(userRequest.getState());

        if (!user.isUserRegistered()){

//            replacing with static values due db issue  "user.getUserType()
            MstRoleEntity role = roleService.getRoleForUser("CONT");
            UserRoleMpgEntity userRole = new UserRoleMpgEntity();
            userRole.setRole(role);
            user.getRoleMapping().clear();
            user.getRoleMapping().add(role);
        }

        user = userService.saveOrUpdateUser(user, userDetails);

        return ControllerUtils.getCreatedResponse("/{userName}", user.getUsername());
    }

    public void get(String ...s){

    }

    @RequestMapping(value = "user/{userName}", method = RequestMethod.GET)
    public ResponseEntity getUserInitialDetails(@PathVariable String userName){
        final UserEntity user = (UserEntity)userService.loadUserByUsername(userName);
        AuthResponse response = new AuthResponse();
        BeanUtils.copyProperties(user, response);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "user/details", method = RequestMethod.POST)
    public ResponseEntity getUserDetails(@RequestBody UserDetailsRequest request){
        UserEntity user = (UserEntity)this.userService.loadUserByUsername(UserContext.getLoggedInUserId());
        UserDetailsEntity details = userService.loadUserDetailsByUserName(user.getUsername());
        if(details == null){
            details = new UserDetailsEntity();
            details.setUser(user);
            details.setIsEmailVerified("0");
            details.setIsPhoneVerified("1");
        }
        BeanUtils.copyProperties(request, details, "userDetailsId");
        BeanUtils.copyProperties(request, details.getAddress(), "addressId");
        if(details.getPhoneNo() == null){
            details.setPhoneNo(user.getUsername());
        }
        this.userService.saveOrUpdateUser(details);

        return ControllerUtils.getCreatedResponse("/{userName}", user.getUsername());
    }

    @RequestMapping(value = "user/details/{userName}", method = RequestMethod.GET)
    public ResponseEntity getUserDetails(@PathVariable String userName){
        UserDetailsResponse response = new UserDetailsResponse();
        UserDetailsEntity details = userService.loadUserDetailsByUserName(userName);
        if(details != null){
            BeanUtils.copyProperties(details, response);
            BeanUtils.copyProperties(details.getAddress(), response);
        }
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "user/profile", method = RequestMethod.POST)
    public ResponseEntity updateUserProfile(@RequestBody UpdateUserRequest userRequest){
        UserEntity user = (UserEntity)this.userService.loadUserByUsername(UserContext.getLoggedInUserId());
        UserDetailsEntity userDetails = user.getDetails();

        user.setFirstName(userRequest.getFirstName());
        user.setMiddleName(userRequest.getMiddleName());
        user.setLastName(userRequest.getLastName());
        user.setGender(userRequest.getGender());

        if(userDetails == null){
            userDetails = new UserDetailsEntity();
            userDetails.setUser(user);
            user.setDetails(userDetails);
        }
        if(userRequest.getProfilePicture() != null){
            userDetails.setProfilePicture(UUID.fromString(userRequest.getProfilePicture()));
        }

        if(userRequest.getProfileVideo() != null){
            userDetails.setProfileVideo(UUID.fromString(userRequest.getProfileVideo()));
        }

        if(userRequest.getGetProfileDescription() != null){
            userDetails.setGetProfileDescription(userRequest.getGetProfileDescription());
        }

        userDetails.getAddress().setAddressCity(userRequest.getCity());
        userDetails.getAddress().setAddressCountry(userRequest.getCountry());
        userDetails.getAddress().setAddressState(userRequest.getState());

        user = userService.saveOrUpdateUser(user, userDetails);

        return ControllerUtils.getCreatedResponse("/{userName}", user.getUsername());
    }

}
