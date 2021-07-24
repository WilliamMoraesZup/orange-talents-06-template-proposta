package com.zup.william.proposta.proposta.carteira;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String numeroCartao;

    @Enumerated(EnumType.STRING)
    private CarteiraEnum carteira;


    public Long getId() {
        return id;
    }

    public Carteira(String email, String numeroCartao, CarteiraEnum carteiraEnum) {
        this.email = email;
        this.numeroCartao = numeroCartao;
        this.carteira = carteiraEnum;
    }

    public Carteira() {
    }
}
