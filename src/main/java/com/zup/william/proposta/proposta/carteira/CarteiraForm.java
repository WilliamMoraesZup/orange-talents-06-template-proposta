package com.zup.william.proposta.proposta.carteira;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarteiraForm {

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Enumerated (EnumType.STRING)
    private CarteiraEnum carteira;


    public CarteiraForm(String email, CarteiraEnum carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public Carteira toModel(String numeroCartao) {
        return new Carteira(email, numeroCartao, carteira);
    }

    public CarteiraEnum getCarteiraEnum() {
        return carteira;
    }

    public String getEmail() {
        return email;
    }

}
