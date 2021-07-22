package com.zup.william.proposta.proposta.bloqueio;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


@FeignClient(url = "${url.conta}", name = "solicitarBloqueio")
public interface ClientSolicitarBloqueio {

    @PostMapping(value = "cartoes/{id}/bloqueios")
    Map<String, Object> solicitaBloqueio(@PathVariable String id, @RequestBody CartaoBloqueadoForm form);

}





