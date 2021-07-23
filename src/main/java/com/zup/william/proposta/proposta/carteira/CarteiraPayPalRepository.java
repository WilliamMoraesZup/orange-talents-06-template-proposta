package com.zup.william.proposta.proposta.carteira;

import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarteiraPayPalRepository extends JpaRepository<CarteiraPayPal, Long> {

    Optional<NovaProposta> findByNumeroCartao(String idCartao);

}
