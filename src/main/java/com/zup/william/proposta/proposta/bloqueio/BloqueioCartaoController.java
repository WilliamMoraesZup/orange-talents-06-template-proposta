package com.zup.william.proposta.proposta.bloqueio;

import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import com.zup.william.proposta.proposta.novaProposta.PropostaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Optional;

@RestController
public class BloqueioCartaoController {


    @Autowired
    private BloqueioCartaoRepository bloqueioRepository;

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private ClientSolicitarBloqueio bloqueio;

    //Retorna 404 durante validação do DTO.
    @PostMapping("/cartao/bloqueio")
    public ResponseEntity<?> consultaProposta(@RequestHeader(value = "User-Agent") String userAgent,
                                              @Valid NumeroCartaoParamDTO numeroCartao,
                                              @RequestBody @Valid CartaoBloqueadoForm form) throws UnknownHostException {

        /**
         *  Verifica se já foi feito o bloqueio
         *  Return 422
         */
        Optional<CartaoBloqueado> cartaoJaBloqueado = bloqueioRepository.findByNumeroCartao(numeroCartao.getNumeroCartao());
        if (cartaoJaBloqueado.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Esse cartão já está bloqueado");
        }
        String idCartao = numeroCartao.getNumeroCartao();

        try {
            Optional<NovaProposta> optional = propostaRepository.findByNumeroCartao(numeroCartao.getNumeroCartao());
            Map<String, Object> emiteBloqueio = bloqueio.solicitaBloqueio(idCartao, form);

            CartaoBloqueado novoBloqueio = new CartaoBloqueado(numeroCartao.getNumeroCartao(), userAgent);

            NovaProposta novaProposta = optional.get();
            novaProposta.bloqueiaCartao();
            propostaRepository.save(novaProposta);
            bloqueioRepository.save(novoBloqueio);

        } catch (FeignException e) {
            if (e.status() >= 400 || e.status() <= 600) {
                System.out.println("erro no client");
                return ResponseEntity.status(422).body(e.getMessage());
            }
        }


        return ResponseEntity.ok().build();
    }
}
