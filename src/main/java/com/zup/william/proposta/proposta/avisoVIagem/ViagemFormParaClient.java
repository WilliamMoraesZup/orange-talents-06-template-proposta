package com.zup.william.proposta.proposta.avisoVIagem;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ViagemFormParaClient {


    @NotBlank
    private String destino;
    @NotNull
    @Future
    private LocalDate validoAte;

    public ViagemFormParaClient(ViagemForm form) {
        this.destino = form.getDestino();
        this.validoAte = form.getDataTermino();
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }
}
