package com.zup.william.proposta.proposta.clienteApiCartoes;

import com.zup.william.proposta.proposta.analiseCreditoClient.EstadoPropostaEnum;
import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import com.zup.william.proposta.proposta.novaProposta.PropostaRepository;
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

    @Scheduled(fixedDelayString = "${periodicidade.executa-operacao-numero-cartao}")
    public void enviarSolicitacaoDeNumeroDeCartao() {
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
