package com.zup.william.proposta.proposta.analiseCredito;

public enum EstadoAnaliseEnum {

    COM_RESTRICAO,
    SEM_RESTRICAO;


    public EstadoPropostaEnum retornaSeElegivelOuNao() {

        return this == COM_RESTRICAO ? EstadoPropostaEnum.NAO_ELEGIVEL :
                EstadoPropostaEnum.ELEGIVEL;
    }


}
