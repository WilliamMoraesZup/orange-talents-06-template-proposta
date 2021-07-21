package com.zup.william.proposta.proposta.bloqueio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BloqueioCartaoRepository extends JpaRepository<CartaoBloqueado, String> {

    Optional<CartaoBloqueado> findByNumeroCartao(String numeroCartao);
}
