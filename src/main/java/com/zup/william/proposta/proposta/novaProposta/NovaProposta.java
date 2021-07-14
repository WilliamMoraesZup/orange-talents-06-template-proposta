package com.zup.william.proposta.proposta.novaProposta;

import com.zup.william.proposta.proposta.shared.CPFOrCNPJ;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


@Entity
public class NovaProposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String endereco;

    @NotBlank @CPFOrCNPJ
    private String documento;


    @NotNull
    @Positive
    private BigDecimal salario;

    public NovaProposta(String nome, String email, String endereco, String documento, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.documento = documento;
        this.salario = salario;
    }

    public NovaProposta() {
    }

    public Long getId() {
        return id;
    }


}
