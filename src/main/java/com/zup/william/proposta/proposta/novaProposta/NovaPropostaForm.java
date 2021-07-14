package com.zup.william.proposta.proposta.novaProposta;

import com.zup.william.proposta.proposta.shared.CPFOrCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaForm {


    @NotBlank
    private String nome;


    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String endereco;

    @NotBlank  @CPFOrCNPJ
    private String documento;


    @NotNull
    @Positive
    private BigDecimal salario;

    public NovaProposta toModel() {
        return new NovaProposta(nome, email, endereco, documento, salario);
    }

    public NovaPropostaForm(String nome, String email, String endereco, String documento, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.documento = documento;
        this.salario = salario;
    }
}
