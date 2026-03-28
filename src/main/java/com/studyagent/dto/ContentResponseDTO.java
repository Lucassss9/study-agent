package com.studyagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponseDTO {

    private Long id;
    private String title;
    private LocalDateTime dateTime;
}
