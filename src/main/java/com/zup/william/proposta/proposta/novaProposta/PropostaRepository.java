package com.zup.william.proposta.proposta.novaProposta;

import com.zup.william.proposta.proposta.clientAnaliseCredito.EstadoPropostaEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropostaRepository extends JpaRepository<NovaProposta, Long> {

    List<NovaProposta> findByEstadoPropostaAndNumeroCartao(EstadoPropostaEnum estado, String numeroCartao);

     Optional<NovaProposta> findByNumeroCartao(String idCartao);
}
