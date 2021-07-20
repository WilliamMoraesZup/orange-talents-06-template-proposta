package com.zup.william.proposta.proposta.clienteApiCartoes;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url ="http://contas:9999/api", name = "solicitaCartao")
public interface ClientDeCartoes {


    @RequestMapping(method = RequestMethod.GET, value = "/cartoes")
    NumeroDoCartaoRequest solicitarNumeroCartao(@RequestParam Long idProposta);


}

