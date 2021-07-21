package com.zup.william.proposta.proposta.bloqueio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@RestController
public class BloqueioCartaoController {

    @Autowired
    private HttpServletRequest req;
    @Autowired
    private BloqueioCartaoRepository repository;

    //Retorna 404 durante validação do DTO.
    @PostMapping("/cartao/bloqueio")
    public ResponseEntity<?> consultaProposta(@RequestHeader(value = "User-Agent") String userAgent, @Valid NumeroCartaoParamDTO numeroCartao) throws UnknownHostException {


        Optional<CartaoBloqueado> cartaoJaBloqueado = repository.findByNumeroCartao(numeroCartao.getNumeroCartao());

        //VerificaSeJáFoiBloqueado, pra retornar 422
        if (cartaoJaBloqueado.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Esse cartão já está bloqueado");
        }

        CartaoBloqueado novoBloqueio = new CartaoBloqueado(numeroCartao.getNumeroCartao(), userAgent);
        repository.save(novoBloqueio);


        return ResponseEntity.ok().build();
    }
}
