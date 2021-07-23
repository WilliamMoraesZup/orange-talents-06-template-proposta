package com.zup.william.proposta.proposta.avisoVIagem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String numeroCartao;
    @NotBlank
    private String destino;
    @NotNull
    @Future
    private LocalDate dataTermino;
    @NotNull
    private Instant instanteAviso = Instant.now();
    @NotBlank
    private String ip;
    @NotBlank
    private String userAgent;


    public Viagem() {
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "numeroCartao='" + numeroCartao + '\'' +
                ", destino='" + destino + '\'' +
                ", dataTermino=" + dataTermino +
                ", instanteAviso=" + instanteAviso +
                ", ip='" + ip + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }

    public Viagem(String numeroCartao, String destino, LocalDate dataTermino, String ip, String userAgent) {
        this.numeroCartao = numeroCartao;
        this.destino = destino;
        this.dataTermino = dataTermino;
        this.ip = ip;
        this.userAgent = userAgent;
    }
}
