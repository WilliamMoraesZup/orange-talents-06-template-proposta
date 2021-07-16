package com.zup.william.proposta.proposta.novaProposta;

import com.zup.william.proposta.proposta.analiseCreditoClient.EstadoPropostaEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaRepository extends JpaRepository<NovaProposta, String> {

    List<NovaProposta> findByEstadoPropostaAndNumeroCartao(EstadoPropostaEnum estado, String numeroCartao);


}
