package com.diplomski.backend.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final int status;
    private final String message;
    private final String stackTrace;
    private List<ValidatorError> errors;

    @Data
    @RequiredArgsConstructor
    private static class ValidatorError{
        private final String field;
        private final String message;
    }
    public void addValidatorError(String field,String message){
        if(Objects.isNull(errors)){
            errors=new ArrayList<>();
        }
        errors.add(new ValidatorError(field, message));
    }
}
