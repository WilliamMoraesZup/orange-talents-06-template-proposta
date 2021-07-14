package com.zup.william.proposta.proposta.errorHandlers;

import org.springframework.http.HttpStatus;

public class ApiErroException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final String motivo;


    public ApiErroException(HttpStatus httpStatus, String motivo) {
        this.httpStatus = httpStatus;
        this.motivo = motivo;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMotivo() {
        return motivo;
    }
}
