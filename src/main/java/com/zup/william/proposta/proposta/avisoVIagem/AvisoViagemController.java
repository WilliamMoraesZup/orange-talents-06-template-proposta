package com.zup.william.proposta.proposta.avisoVIagem;

import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import com.zup.william.proposta.proposta.novaProposta.PropostaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Optional;

@RestController
public class AvisoViagemController {

    @Autowired
    private PropostaRepository repositoryProposta;
    @Autowired
    private AvisoViagemRepository repositoryViagem;
    @Autowired
    private ClientInformarViagem clientViagem;


    @PostMapping("/viagem")
    public ResponseEntity<?> avisarViagem(@RequestBody @Valid ViagemForm form,
                                          @RequestParam(required = true) String numeroCartao,
                                          @RequestHeader(value = "User-Agent") String userAgent) throws UnknownHostException {

        Optional<NovaProposta> optional = repositoryProposta.findByNumeroCartao(numeroCartao);

        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {

            Map<String, Object> stringObjectMap = clientViagem.informarViagem(numeroCartao, new ViagemFormParaClient(form));

            Viagem novoAviso = form.toModel(userAgent, numeroCartao, InetAddress.getLocalHost().getHostAddress());
            repositoryViagem.save(novoAviso);

            return ResponseEntity.ok().build();
        } catch (FeignException e) {
            System.out.println(e);
            return ResponseEntity.status(422).body("erro no cliente, tente novamente");

        }


    }
}
