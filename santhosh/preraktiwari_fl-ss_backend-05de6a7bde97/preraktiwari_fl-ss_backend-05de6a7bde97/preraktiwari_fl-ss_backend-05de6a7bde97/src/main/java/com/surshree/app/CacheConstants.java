package com.surshree.app;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CacheConstants {
    private CacheConstants(){}

    public static final String CACHE_USERS = "cache_users";
    public static final String CACHE_ROLES = "cache_roles";

    public static List<String> getAllCacheNames(){
        List allCacheNames = new ArrayList();
        Field[] fields = CacheConstants.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                if(field.getType() ==  String.class) {
                    allCacheNames.add((String) field.get(field.getName()));
                }
            }
        }catch (Exception e){
            log.error("Error occurred while initializing the cache names", e);
            throw new RuntimeException(e);
        }
        return allCacheNames;
    }

}
