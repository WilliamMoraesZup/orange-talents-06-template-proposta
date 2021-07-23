package com.zup.william.proposta.proposta.carteira;


import com.zup.william.proposta.proposta.avisoVIagem.ViagemFormParaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


@FeignClient(url = "${url.conta}", name = "associarCarteira")
public interface ClientAssociaCarteira {

    @PostMapping(value = "/cartoes/{id}/carteiras")
    Map<String, Object> associarPaypal(@PathVariable String id, @RequestBody PaypalParaClientForm form);

}





