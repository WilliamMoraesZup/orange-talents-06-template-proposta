package com.zup.william.proposta.proposta.carteira;

import javax.validation.constraints.NotBlank;

public class PaypalParaClientForm {
    @NotBlank
    private String email;
    @NotBlank
    private String carteira;

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }

    public PaypalParaClientForm(String idCarteira, String email) {
        this.email =email;
        this.carteira = idCarteira;
    }
}
