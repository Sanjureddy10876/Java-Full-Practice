package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "T_MST_STATE")
public class MstStateEntity extends BaseEntity{

    @Id
    @Column(name = "STATE_ABR")
    private String key;

    @Column(name = "STATE_DESC")
    private String desc;
}
