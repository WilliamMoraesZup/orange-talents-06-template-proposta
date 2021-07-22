package com.zup.william.proposta.proposta.consultaDadosProposta;

import com.zup.william.proposta.proposta.clientAnaliseCredito.EstadoPropostaEnum;
import com.zup.william.proposta.proposta.novaProposta.NovaProposta;

public class ConsultaPropostaRequest {

    private EstadoPropostaEnum estadoProposta;

    public ConsultaPropostaRequest(NovaProposta proposta) {
        this.estadoProposta = proposta.getEstadoProposta();
    }

    public EstadoPropostaEnum getEstadoProposta() {
        return estadoProposta;
    }
}
