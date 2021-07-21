package com.zup.william.proposta.proposta.bloqueio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

@Entity
public class CartaoBloqueado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String numeroCartao;

    @NotBlank
    private String ipMaquina =InetAddress.getLocalHost().getHostAddress();

    @NotNull
    private Instant instanteBloqueio = Instant.now();

    @NotBlank
    private String userAgent;


    private SituacaoENUM situacao = SituacaoENUM.BLOQUEADO;

    public CartaoBloqueado(String numeroCartao, String userAgent) throws UnknownHostException {

        this.numeroCartao = numeroCartao;
        this.userAgent = userAgent;
    }

    public CartaoBloqueado() throws UnknownHostException {
    }
}
