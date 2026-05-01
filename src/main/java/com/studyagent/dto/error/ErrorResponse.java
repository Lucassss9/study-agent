package com.studyagent.dto.error;

import java.util.List;

public record ErrorResponse(int status, List<FieldError> errors) {
}
