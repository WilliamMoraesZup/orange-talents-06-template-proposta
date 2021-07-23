package com.zup.william.proposta.proposta.carteira;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PaypalForm {

    @NotBlank
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public PaypalForm() {
    }

    public PaypalForm(String email) {
        this.email = email;
    }

    public CarteiraPayPal toModel(String numeroCartao) {

        return new
                CarteiraPayPal(email, numeroCartao);
    }
}
