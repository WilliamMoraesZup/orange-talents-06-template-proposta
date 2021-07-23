package com.zup.william.proposta.proposta.carteira;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;


@FeignClient(url = "${url.conta}", name = "associarCarteira")
public interface ClientAssociaCarteira {

    @PostMapping(value = "/cartoes/{id}/carteiras")
    Map<String, Object> associarCartao(@PathVariable String id, CarteiraParaClientForm form);

}





