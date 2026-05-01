package com.studyagent.handler;

import com.studyagent.dto.error.ErrorResponse;
import com.studyagent.dto.error.FieldError;
import com.studyagent.exception.EntityNotFoundException;
import com.studyagent.exception.StudyAgentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(
                404,
                List.of(new FieldError("error", ex.getMessage())));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(StudyAgentException.class)
    public ResponseEntity<ErrorResponse> handleStudyAgentException(StudyAgentException ex) {
        ErrorResponse response = new ErrorResponse(
                500,
                List.of(new FieldError("error", ex.getMessage())));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse response = new ErrorResponse(
                500,
                List.of(new FieldError("error", ex.getMessage())));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(f -> new FieldError(
                        f.getField(),
                        f.getDefaultMessage()))
                .toList();

        ErrorResponse response = new ErrorResponse(400, errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
