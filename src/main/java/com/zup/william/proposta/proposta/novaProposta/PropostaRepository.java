package com.zup.william.proposta.proposta.novaProposta;

import com.zup.william.proposta.proposta.analiseCredito.EstadoPropostaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<NovaProposta, Long> {

    List<NovaProposta> findByEstadoPropostaAndNumeroCartao(EstadoPropostaEnum estado, String numeroCartao);

     Optional<NovaProposta> findByNumeroCartao(String idCartao);
}
