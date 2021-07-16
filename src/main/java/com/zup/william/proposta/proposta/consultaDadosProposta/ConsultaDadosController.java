package com.zup.william.proposta.proposta.consultaDadosProposta;

import com.zup.william.proposta.proposta.errorHandlers.ApiErroException;
import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import com.zup.william.proposta.proposta.novaProposta.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ConsultaDadosController {

    @Autowired
    PropostaRepository repository;


    @GetMapping("/proposta")
    public ResponseEntity<?> consultaProposta(@RequestParam Long idProposta) {
        Optional<NovaProposta> propostaBuscada = repository.findById(idProposta);

        if (propostaBuscada.isPresent()) {
            ConsultaPropostaRequest propostaRequest = new ConsultaPropostaRequest(propostaBuscada.get());
            return ResponseEntity.ok(propostaRequest);

        } else {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "A proposta informada não foi localizada");

        }

    }
}
