package com.zup.william.proposta.proposta.bloqueio;

import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import com.zup.william.proposta.proposta.shared.ValidaExistencia;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;


@Validated
public class NumeroCartaoParamDTO {

    @NotBlank
    @ValidaExistencia(campo = "numeroCartao", entidade = NovaProposta.class)
    private String numeroCartao;


    public NumeroCartaoParamDTO(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

}
