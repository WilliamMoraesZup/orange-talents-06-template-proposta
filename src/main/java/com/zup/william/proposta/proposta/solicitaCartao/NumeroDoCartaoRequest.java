package com.zup.william.proposta.proposta.solicitaCartao;

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

    @Override
    public String toString() {
        return "NumeroDoCartaoRequest{" +
                "id='" + id + '\'' +
                '}';
    }
}
