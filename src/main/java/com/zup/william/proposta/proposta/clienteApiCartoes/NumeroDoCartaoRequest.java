package com.zup.william.proposta.proposta.clienteApiCartoes;

public class NumeroDoCartaoRequest {

    private String id;

    public NumeroDoCartaoRequest(String id) {
        this.id = id;
    }


    public NumeroDoCartaoRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
