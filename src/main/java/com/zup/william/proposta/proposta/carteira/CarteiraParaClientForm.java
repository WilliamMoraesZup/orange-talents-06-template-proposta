package com.zup.william.proposta.proposta.carteira;

import javax.validation.constraints.NotBlank;

public class CarteiraParaClientForm {
    @NotBlank
    private String email;
    @NotBlank
    private CarteiraEnum carteira;

    public String getEmail() {
        return email;
    }



    public CarteiraParaClientForm(CarteiraEnum carteira, String email) {
        this.email =email;
        this.carteira = carteira;
    }
}
