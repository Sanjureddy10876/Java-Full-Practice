package com.surshree.app.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum implements IBaseEnum{

    ADMN("ADMN", "ROLE_ADMN"),
    CONT("CONT", "ROLE_CONT"),
    MENT("MENT", "ROLE_MENT");


    private String name;

    private String desc;

    public static RoleEnum getDescByName(String name){
        return RoleEnum.valueOf(name);
    }
}
