package com.studyagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyBlockRequestDTO {

    private String name;
    private String subject;
}
