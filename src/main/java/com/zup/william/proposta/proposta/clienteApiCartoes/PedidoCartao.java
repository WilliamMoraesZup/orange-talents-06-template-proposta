package com.zup.william.proposta.proposta.clienteApiCartoes;

import com.zup.william.proposta.proposta.novaProposta.NovaProposta;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PedidoCartao {

    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotNull
    private Long idProposta;


    public PedidoCartao(@Valid NovaProposta proposta) {

        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId();
    }


    @Override
    public String toString() {
        return "RequisitanteRequest{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }
}
