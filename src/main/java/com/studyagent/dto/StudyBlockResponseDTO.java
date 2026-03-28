package com.studyagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyBlockResponseDTO {

    private Long id;
    private String name;
    private String subject;
}
