package com.zup.william.proposta.proposta.carteira;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

public class CarteiraParaClientForm {
    @NotBlank
    private String email;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private CarteiraEnum carteira = CarteiraEnum.SEM_CARTEIRA;

    public String getEmail() {
        return email;
    }

    public CarteiraEnum getCarteira() {
        return carteira;
    }

    public CarteiraParaClientForm(CarteiraEnum carteira, String email) {
        this.email = email;
        this.carteira = carteira;
    }
}
