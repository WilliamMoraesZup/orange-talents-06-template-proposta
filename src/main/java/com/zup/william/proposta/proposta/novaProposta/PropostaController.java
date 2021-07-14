package com.zup.william.proposta.proposta.novaProposta;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class PropostaController {
    private final Logger logger = LoggerFactory.getLogger(PropostaController.class);


    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/propostas")
    @Transactional
    public ResponseEntity<?> novaPorposta(@RequestBody @Valid NovaPropostaForm form, UriComponentsBuilder uriComponentsBuilder) {

        NovaProposta proposta = form.toModel();
        Assert.notNull(proposta, "Houve um erro ao converter proposta em entidade");

        manager.persist(proposta);
        URI uri = uriComponentsBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();


        //  logger.info("Proposta documento={} salário={} criada com sucesso!", proposta.getDocumento(), proposta.getSalario());
        logger.info("Proposta criada com sucesso!");

        return ResponseEntity.created(uri).build();

    }


}
