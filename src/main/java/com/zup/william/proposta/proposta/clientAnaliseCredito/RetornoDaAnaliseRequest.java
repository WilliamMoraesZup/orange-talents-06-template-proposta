package com.zup.william.proposta.proposta.clientAnaliseCredito;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class RetornoDaAnaliseRequest {

    private String documento;
    private String nome;
    private String idProposta;
    @Enumerated(EnumType.STRING)
    private EstadoAnaliseEnum resultadoSolicitacao;

    public RetornoDaAnaliseRequest(String documento, String nome, String idProposta, EstadoAnaliseEnum resultadoSolicitacao) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    @Override
    public String toString() {
        return "RequisitanteAnaliseRetorno{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", idProposta='" + idProposta + '\'' +
                ", resultadoSolicitacao=" + resultadoSolicitacao +
                '}';
    }



    public EstadoAnaliseEnum getAnaliseStatusEnum() {
        return resultadoSolicitacao;
    }
}