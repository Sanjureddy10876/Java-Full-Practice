package com.surshree.app.domain.entities;

import com.surshree.app.util.UserContext;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Column(name = "CREATED_BY", nullable = false)
    public String createdBy;

    @Column(name = "CREATED_TS", nullable = false)
    public Date createdTs;

    @Column(name = "UPDATED_BY", nullable = false)
    public String updatedBy;

    @Column(name = "UPDATED_TS", nullable = false)
    public Date updatedTs;

    @Transient
    private Boolean useCustomUserId = Boolean.FALSE;

    @PrePersist
    protected void onCreate(){
        if(!useCustomUserId){
            this.createdBy = UserContext.getLoggedInUserId();
            this.updatedBy = UserContext.getLoggedInUserId();
        }
        this.createdTs = new Date();
        this.updatedTs = new Date();
        System.out.println("onCreate called -->");
    }

    @PreUpdate
    protected void onUpdate(){
        if(!useCustomUserId){
            this.updatedBy = UserContext.getLoggedInUserId();
        }
        this.updatedTs = new Date();
        System.out.println("onUpdate called -->");
    }
}
