package com.zup.william.proposta.proposta.novaProposta;

import com.zup.william.proposta.proposta.biometria.Biometria;
import com.zup.william.proposta.proposta.analiseCredito.EstadoAnaliseEnum;
import com.zup.william.proposta.proposta.analiseCredito.EstadoPropostaEnum;
import com.zup.william.proposta.proposta.solicitaCartao.NumeroDoCartaoRequest;
import com.zup.william.proposta.proposta.shared.CPFOrCNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


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

    @OneToMany(mappedBy = "dono", cascade = CascadeType.MERGE)
    private Set<Biometria> biometrias = new HashSet<>();


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

    public void adicionaBiometria(Biometria biometria) {

        this.biometrias.add(biometria);
    }

    public void atualizaEstadoProposta(EstadoAnaliseEnum retornoProposta) {
        this.estadoProposta = retornoProposta.retornaSeElegivelOuNao();
    }

    public void bloqueiaCartao() {
        this.estadoProposta = EstadoPropostaEnum.BLOQUEADO;
    }

    public EstadoPropostaEnum getEstadoProposta() {
        return estadoProposta;
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

    @Override
    public String toString() {
        return "NovaProposta{" +
                "id=" + id +

                ", numeroCartao='" + numeroCartao + '\'' +
                ", biometrias=" + biometrias +
                '}';
    }
}
