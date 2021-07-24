package com.zup.william.proposta.proposta.avisoVIagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface AvisoViagemRepository extends JpaRepository<Viagem, Long> {


}
