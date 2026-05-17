package com.surshree.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseModel {
    private Boolean isSuccessful;
    private String msg;
}
