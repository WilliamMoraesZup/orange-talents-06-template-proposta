package com.zup.william.proposta.proposta.clienteApiCartoes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RestController
public class SolicitarCartaoController {
    private final Logger logger = LoggerFactory.getLogger(SolicitarCartaoController.class);


    @PersistenceContext
    private EntityManager manager;

    @Autowired
    ClientDeCartoes clientDeCartoes;


    @PostMapping("/cartoes")
    public ResponseEntity<?> solicitarNumeroCartao(@RequestParam Long idProposta) {
        NumeroDoCartaoRequest idCartao = clientDeCartoes.solicitarNumeroCartao(idProposta);
        System.out.println(idCartao );
        return ResponseEntity.ok().build();

    }


}

