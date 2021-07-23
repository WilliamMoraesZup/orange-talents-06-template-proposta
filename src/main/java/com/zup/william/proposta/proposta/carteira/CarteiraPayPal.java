package com.zup.william.proposta.proposta.carteira;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class CarteiraPayPal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String numeroCartao;


    public Long getId() {
        return id;
    }

    public CarteiraPayPal(String email, String numeroCartao) {
        this.email = email;
        this.numeroCartao = numeroCartao;
    }
}
