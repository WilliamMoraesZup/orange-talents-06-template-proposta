package com.zup.william.proposta.proposta.avisoVIagem;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ViagemForm {

    @NotBlank
    private String destino;
    @NotNull
    @Future
    private LocalDate dataTermino;

    public ViagemForm(String destino, LocalDate dataTermino) {
        this.destino = destino;
        this.dataTermino = dataTermino;
    }

    public Viagem toModel(String userAgent, String numeroCartao, String ip) {
        return new Viagem(numeroCartao, destino, dataTermino, ip, userAgent);
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }
}
