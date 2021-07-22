package com.zup.william.proposta.proposta.clientAnaliseCredito;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url="${url.analise}", name = "analiseDeCredito")
public interface ClientDaAnalise {


    @RequestMapping(method = RequestMethod.POST, value = "/solicitacao", consumes = "application/json")
    RetornoDaAnaliseRequest enviarParaAnalise(@RequestBody AnaliseDePropostaForm request);


}

