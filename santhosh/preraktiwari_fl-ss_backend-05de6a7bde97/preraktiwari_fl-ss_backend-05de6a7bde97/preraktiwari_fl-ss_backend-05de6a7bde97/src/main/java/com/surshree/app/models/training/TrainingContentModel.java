package com.surshree.app.models.training;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainingContentModel {

    private Long trainingContentId;

    private String trainingContentName;

    private String trainingContentDesc;

    private String contentId;

    private Integer sortOrder;

    public static int compare(Object o1, Object o2) {

        TrainingContentModel t1 = (TrainingContentModel)o1;
        TrainingContentModel t2 = (TrainingContentModel)o2;

        return t1.getSortOrder().compareTo(t2.getSortOrder());
    }
}
