package com.zup.william.proposta.proposta.novaProposta;

import com.zup.william.proposta.proposta.analiseCreditoClient.EstadoPropostaEnum;
import com.zup.william.proposta.proposta.analiseCreditoClient.RetornoDaAnaliseRequest;
import com.zup.william.proposta.proposta.clienteApiCartoes.NumeroDoCartaoRequest;
import com.zup.william.proposta.proposta.shared.CPFOrCNPJ;

import javax.persistence.*;
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

    @NotBlank
    @CPFOrCNPJ
    private String documento;

    @Enumerated(EnumType.STRING)
    private EstadoPropostaEnum estadoProposta;

    @NotNull
    @Positive
    private BigDecimal salario;

    private String numeroCartao;

    public NovaProposta(String nome, String email, String endereco, String documento, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.documento = documento;
        this.salario = salario;
    }

    public NovaProposta() {
    }

    public void atualizaNumeroCartao(NumeroDoCartaoRequest numeroRecebidoClient) {
        this.numeroCartao = numeroRecebidoClient.getId();
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public String getDocumento() {
        return documento;
    }

    public void atualizaEstadoProposta(RetornoDaAnaliseRequest retornoProposta) {
        this.estadoProposta = retornoProposta.getAnaliseStatusEnum().retornaSeElegivelOuNao();
    }

    public EstadoPropostaEnum getEstadoProposta() {
        return estadoProposta;
    }
}
