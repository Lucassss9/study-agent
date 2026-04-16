package com.studyagent.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudyBlockRequestDTO {

    @NotBlank(message = "Name é obrigatório")
    private String name;

    @NotBlank(message = "Subject é obrigatório")
    private String subject;
}
