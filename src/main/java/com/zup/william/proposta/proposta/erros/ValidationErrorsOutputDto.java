package com.zup.william.proposta.proposta.erros;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDto {

    private List<String> globalErrorMessages = new ArrayList<>();
    private List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();

    public void addError(String errorMessage) {
        globalErrorMessages.add(errorMessage);
    }

    public void addFieldError(String field, String errorMessage) {

        FieldErrorOutputDto fieldErrorOutputDto = new FieldErrorOutputDto(field, errorMessage);
        fieldErrors.add(fieldErrorOutputDto);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorOutputDto> getFieldErrors() {
        return fieldErrors;
    }
}
