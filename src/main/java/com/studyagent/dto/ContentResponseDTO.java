package com.studyagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ContentResponseDTO {

    private Long id;
    private String title;
    private LocalDateTime dateTime;
}
