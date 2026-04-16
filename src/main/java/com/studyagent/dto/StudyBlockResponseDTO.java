package com.studyagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class StudyBlockResponseDTO {

    private Long id;
    private String name;
    private String subject;
}
