package com.zup.william.proposta.proposta.errorHandlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadronizado> handleBeanValidationError(MethodArgumentNotValidException exception) {
        Collection<String> mensagensDeErros = new ArrayList();

        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();

        fieldErrorList.forEach(fieldError -> {
            String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
            mensagensDeErros.add(message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroPadronizado(mensagensDeErros));
    }


    @ExceptionHandler(ApiErroException.class)
    public ResponseEntity<ErroPadronizado> erroGenerico(ApiErroException apiErroException) {
        Collection<String> mensagensDeErros = new ArrayList();

        mensagensDeErros.add(apiErroException.getMotivo());

        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagensDeErros);


        return ResponseEntity.status(apiErroException.getHttpStatus()).body(erroPadronizado);
    }


}
