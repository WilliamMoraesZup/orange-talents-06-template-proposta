package com.zup.william.proposta.proposta.novaProposta;

import com.zup.william.proposta.proposta.shared.CPFOrCNPJ;
import com.zup.william.proposta.proposta.shared.DeveSerUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaForm {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String endereco;

    @NotBlank
    @CPFOrCNPJ
    @DeveSerUnico(campo = "documento", entidade = NovaProposta.class)
    private String documento;

    @NotNull
    @Positive
    private BigDecimal salario;

    public NovaProposta toModel() {
        this.documento = criptografar(documento);


        return new NovaProposta(nome, email, endereco, documento, salario);
    }

    public NovaPropostaForm(String nome, String email, String endereco, String documento, BigDecimal salario) {

        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.documento = documento;
        this.salario = salario;
    }


    public String criptografar(String documento) {
        try {
            java.security.MessageDigest algorithm = java.security.MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = algorithm.digest(documento.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            return hexString.toString();
        } catch (java.io.UnsupportedEncodingException | java.security.NoSuchAlgorithmException ex) {
            return null;
        }
    }
}
