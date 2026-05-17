package com.surshree.app.domain.entities;

import com.surshree.app.models.training.TrainingModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "T_TRAINING_CONTENT")
public class TrainingContentEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRAINING_CONTENT_ID")
    private Long trainingContentId;

    @ManyToOne
    @JoinColumn(name = "TRAINING_ID")
    private TrainingEntity trainingEntity;

    @Column(name = "TRAINING_CONTENT_NAME")
    private String trainingContentName;

    @Column(name = "TRAINING_CONTENT_DESC")
    private String trainingContentDesc;

    @Column(name = "TRAINING_CONTENT")
    private UUID contentId;

    @Column(name = "SORT_ORDER")
    private Integer sortOrder;
}
