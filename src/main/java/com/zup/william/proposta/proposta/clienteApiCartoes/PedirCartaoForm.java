package com.zup.william.proposta.proposta.clienteApiCartoes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PedirCartaoForm {


    @NotBlank
    private String nome;
    @NotBlank
    private String documento;
    @NotNull
    private Long idProposta;

}
