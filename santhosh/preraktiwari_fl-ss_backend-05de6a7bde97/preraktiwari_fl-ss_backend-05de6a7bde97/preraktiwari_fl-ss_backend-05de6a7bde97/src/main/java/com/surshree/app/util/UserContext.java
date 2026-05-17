package com.surshree.app.util;

import com.surshree.app.domain.entities.UserEntity;
import com.surshree.app.domain.enums.RoleEnum;
import org.apache.catalina.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserContext {
    public static Authentication getCurrentLoggedInUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }

    public static String getLoggedInUserId(){
        if(getCurrentLoggedInUser().getPrincipal() instanceof UserEntity){
            UserEntity user = (UserEntity)getCurrentLoggedInUser().getPrincipal();
            return user.getUsername();
        }
        return (String)getCurrentLoggedInUser().getPrincipal();
    }

    public static boolean checkRole(RoleEnum role){
        return getCurrentLoggedInUser().getAuthorities()
                                        .stream()
                                        .anyMatch(a -> a.getAuthority().equals(role.getDesc()));
    }

    public static boolean hasMentorRole(){
        return checkRole(RoleEnum.CONT);
    }

    public static boolean hasAdminRole(){
        return checkRole(RoleEnum.ADMN);
    }

    public static boolean hasContestantRole(){
        return checkRole(RoleEnum.MENT);
    }
}
