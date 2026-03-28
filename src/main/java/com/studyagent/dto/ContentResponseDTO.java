package com.studyagent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponseDTO {

    private Long id;
    private String title;
    private String dateTime;
}
