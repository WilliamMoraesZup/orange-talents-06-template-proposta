package com.zup.william.proposta.proposta.avisoVIagem;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


@FeignClient(url = "${url.conta}", name = "informarViagem")
public interface ClientInformarViagem {

    @PostMapping(value = "/cartoes/{id}/avisos")
    Map<String, Object> informarViagem(@PathVariable String id, @RequestBody ViagemFormParaClient form);

}





