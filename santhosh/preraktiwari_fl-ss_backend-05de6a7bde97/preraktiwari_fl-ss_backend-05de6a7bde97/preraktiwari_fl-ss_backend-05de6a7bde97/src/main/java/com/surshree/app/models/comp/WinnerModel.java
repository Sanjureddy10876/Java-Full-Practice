package com.surshree.app.models.comp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WinnerModel {
    private String compId;

    private String compTitle;

    private String compDesc;

    private String compPhoto;

    private List<SubmittedEntriesModel> winners = new ArrayList<>();
}
