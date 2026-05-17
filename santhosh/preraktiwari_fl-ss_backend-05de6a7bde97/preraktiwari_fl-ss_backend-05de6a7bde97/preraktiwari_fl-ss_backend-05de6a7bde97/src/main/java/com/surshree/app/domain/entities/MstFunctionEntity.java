package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "T_MST_FUNCTION")
public class MstFunctionEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FUNCTION_ID")
    private Long functionId;

    @Column(name = "FUNCTION_NAME")
    private String funcName;

    @Column(name = "FUNCTION_DESC")
    private String funcDesc;

}
