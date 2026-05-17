package com.surshree.app.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum implements IBaseEnum{

    ADMN("ADMN", "Administrator"),
    CONT("CONT", "Contestant"),
    MENT("MENT", "Mentor");

    private String name;

    private String desc;

    public static UserTypeEnum getDescByName(String name){
        return UserTypeEnum.valueOf(name);
    }

    public static boolean isAdmin(String name){
        return UserTypeEnum.valueOf(name) == ADMN;
    }

    public static boolean isContestant(String name){
        return UserTypeEnum.valueOf(name) == CONT;
    }

    public static boolean isMentor(String name){
        return UserTypeEnum.valueOf(name) == MENT;
    }
}
