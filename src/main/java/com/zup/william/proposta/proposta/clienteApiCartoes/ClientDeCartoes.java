package com.zup.william.proposta.proposta.clienteApiCartoes;


import com.zup.william.proposta.proposta.analiseCreditoClient.RetornoDaAnaliseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "zupacademy/contas/api", name = "solicitaCartao")
public interface ClientDeCartoes {


    @RequestMapping(method = RequestMethod.GET, value = "/cartoes" )
    NumeroDoCartaoRequest solicitarNumeroCartao(@RequestParam Long idProposta);





}

