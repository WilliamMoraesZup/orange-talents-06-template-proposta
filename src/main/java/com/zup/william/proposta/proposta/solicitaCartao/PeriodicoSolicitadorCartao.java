package com.zup.william.proposta.proposta.solicitaCartao;

import com.zup.william.proposta.proposta.analiseCredito.EstadoPropostaEnum;
import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import com.zup.william.proposta.proposta.novaProposta.PropostaRepository;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PeriodicoSolicitadorCartao {

    @Autowired
    private ClientDeCartoes clientDeCartoes;

    @Autowired
    private PropostaRepository repository;

    private final Tracer tracer;

    public PeriodicoSolicitadorCartao(Tracer tracer) {
        this.tracer = tracer;
    }

    @Scheduled(fixedDelayString = "${periodicidade.executa-operacao-numero-cartao}")
    public void enviarSolicitacaoDeNumeroDeCartao() {

        Span activeSpan = tracer.activeSpan();
        activeSpan.setTag("user", "william");



        List<NovaProposta> elegivel = repository.findByEstadoPropostaAndNumeroCartao(EstadoPropostaEnum.ELEGIVEL, null);

        for (NovaProposta propostaElegivel : elegivel) {
            NumeroDoCartaoRequest cartaRecebido = clientDeCartoes.solicitarNumeroCartao(propostaElegivel.getId());
            if (cartaRecebido != null && cartaRecebido.getId().length() > 0) {
                propostaElegivel.atualizaNumeroCartao(cartaRecebido);
                repository.save(propostaElegivel);

            }
        }


    }
}
