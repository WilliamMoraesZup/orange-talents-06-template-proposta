package com.zup.william.proposta.proposta.biometria;

import com.zup.william.proposta.proposta.shared.ValidaBiometria;

import javax.validation.constraints.NotBlank;

public class BiometriaForm {

    @NotBlank
    @ValidaBiometria
    private String numeroBiometria;

    public BiometriaForm(String numeroBiometria) {
        this.numeroBiometria = numeroBiometria;
    }


    public BiometriaForm() {
    }

    public Biometria toModel() {
        return new Biometria(numeroBiometria);
    }

    public String getNumeroBiometria() {
        return numeroBiometria;
    }
}
