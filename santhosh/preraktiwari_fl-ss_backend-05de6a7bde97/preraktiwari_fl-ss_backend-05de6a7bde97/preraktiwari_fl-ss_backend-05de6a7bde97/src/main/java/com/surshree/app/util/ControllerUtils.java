package com.surshree.app.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class ControllerUtils {
    public static URI getResourceUrl(String path, String value){
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(path)
                .buildAndExpand(value)
                .toUri();
    }

    public static ResponseEntity getCreatedResponse(String path, String value){
        URI location = ControllerUtils.getResourceUrl(path, value);
        return ResponseEntity.created(location).build();
    }

    public static ResponseEntity getForbiddenResponse(){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have required permission to perform this operation.");
    }
}
