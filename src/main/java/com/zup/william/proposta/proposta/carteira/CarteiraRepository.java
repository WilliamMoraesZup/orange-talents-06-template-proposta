package com.zup.william.proposta.proposta.carteira;

import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    Optional<Carteira> findByNumeroCartaoAndCarteira(String idCartao, CarteiraEnum carteira);

}
