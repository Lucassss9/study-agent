package com.studyagent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudyBlockResponseDTO {

    private Long id;
    private String name;
    private String subject;
}
