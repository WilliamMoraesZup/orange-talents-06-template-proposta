package com.zup.william.proposta.proposta.bloqueio;

import javax.validation.constraints.NotBlank;

public class CartaoBloqueadoForm {


    @NotBlank
    private String sistemaResponsavel;

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public void setSistemaResponsavel(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public CartaoBloqueadoForm() {
    }

    public CartaoBloqueadoForm(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }
}
