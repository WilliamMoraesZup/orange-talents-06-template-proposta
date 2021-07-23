package com.zup.william.proposta.proposta.carteira;


import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import com.zup.william.proposta.proposta.novaProposta.PropostaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class CarteiraController {

    @Autowired
    private PropostaRepository repositoryProposta;

    @Autowired
    private CarteiraPayPalRepository repositoryPaypal;

    @Autowired
    private ClientAssociaCarteira clientCarteira;


    @PostMapping("/carteira/{numeroCartao}/paypal")
    @Transactional
    public ResponseEntity<?> associarPaypal(@RequestBody @Valid PaypalForm form,
                                            @PathVariable String numeroCartao, UriComponentsBuilder uriComponentsBuilder) {

        Optional<NovaProposta> byNumeroCartao = repositoryProposta.findByNumeroCartao(numeroCartao);

        //404
        if (byNumeroCartao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Optional<NovaProposta> cartaoJaAssociado = repositoryPaypal.findByNumeroCartao(numeroCartao);

        // 422
        if (cartaoJaAssociado.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }


        try {
            PaypalParaClientForm paraClient = new PaypalParaClientForm("id da carteira", form.getEmail());

            clientCarteira.associarPaypal(numeroCartao, paraClient);

            CarteiraPayPal novaCarteiraPayPal = form.toModel(numeroCartao);
            URI uri = uriComponentsBuilder.path("/carteiraPaypal/{id}").buildAndExpand(novaCarteiraPayPal.getId()).toUri();

            return ResponseEntity.created(uri).build();

        } catch (FeignException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Não foi possivel associar o cartão");
        }
    }

}
