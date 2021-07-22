package com.zup.william.proposta.proposta.novaProposta;


import com.zup.william.proposta.proposta.clientAnaliseCredito.AnaliseDePropostaForm;
import com.zup.william.proposta.proposta.clientAnaliseCredito.ClientDaAnalise;
import com.zup.william.proposta.proposta.clientAnaliseCredito.EstadoAnaliseEnum;
import com.zup.william.proposta.proposta.clientAnaliseCredito.RetornoDaAnaliseRequest;
import com.zup.william.proposta.proposta.prometheus.MinhasMetricas;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ClientDaAnalise clientDaAnalise;
    @Autowired
    private MinhasMetricas metricas;

    @PostMapping("/proposta")
    @Transactional
    public ResponseEntity<?> novaProposta(@RequestBody @Valid NovaPropostaForm form, UriComponentsBuilder uriComponentsBuilder) {

        NovaProposta proposta = form.toModel();
        Assert.notNull(proposta, "Houve um erro ao converter proposta em entidade");
        manager.persist(proposta);

        URI uri = uriComponentsBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();

        try { //200 salva sem retrição
            RetornoDaAnaliseRequest retorno = clientDaAnalise.enviarParaAnalise(new AnaliseDePropostaForm(proposta));
            proposta.atualizaEstadoProposta(EstadoAnaliseEnum.SEM_RESTRICAO);
            manager.merge(proposta);
            logger.info("Proposta criada com sucesso!");
            metricas.meuContador();

            return ResponseEntity.created(uri).build();
        } catch (FeignException e) {  //salva com restricao
            proposta.atualizaEstadoProposta(EstadoAnaliseEnum.COM_RESTRICAO);
            manager.merge(proposta);
            logger.info("Proposta criada com sucesso, porém com restriçao!");
            return ResponseEntity.created(uri).build();
        }


    }


}
