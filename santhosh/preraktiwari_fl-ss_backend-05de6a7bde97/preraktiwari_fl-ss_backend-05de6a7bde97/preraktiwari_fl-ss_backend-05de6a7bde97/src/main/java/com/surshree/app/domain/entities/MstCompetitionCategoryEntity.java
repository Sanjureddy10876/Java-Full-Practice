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
@Table(name = "T_MST_COMPETITION_CATEGORY")
public class MstCompetitionCategoryEntity extends BaseEntity{
    @Id
    @Column(name="KEY")
    private String key;

    @Column(name="DESC")
    private String desc;
}
