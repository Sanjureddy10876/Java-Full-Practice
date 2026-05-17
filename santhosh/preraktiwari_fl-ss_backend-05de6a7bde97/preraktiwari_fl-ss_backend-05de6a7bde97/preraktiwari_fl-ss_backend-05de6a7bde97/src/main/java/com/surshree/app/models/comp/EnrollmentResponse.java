package com.surshree.app.models.comp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnrollmentResponse {
    private Long competitionId;

    private String fileId;

    private boolean isFileUploaded;

    private Long submittedEntryId;
}
