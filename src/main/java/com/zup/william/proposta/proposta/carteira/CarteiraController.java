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

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
public class CarteiraController {

    @Autowired
    private PropostaRepository repositoryProposta;

    @Autowired
    private CarteiraRepository repositoryCarteira;

    @Autowired
    private ClientAssociaCarteira clientCarteira;


    @PostMapping("/carteira/{numeroCartao}")
    @Transactional
    public ResponseEntity<?> associarPaypal(@RequestBody @Valid CarteiraForm form,
                                            @PathVariable String numeroCartao) {

        Optional<NovaProposta> found = repositoryProposta.findByNumeroCartao(numeroCartao);
        //404
        if (found.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println(form.getCarteiraEnum());
        Optional<Carteira> cartaoJaAssociado = repositoryCarteira.findByNumeroCartaoAndCarteira(numeroCartao, form.getCarteiraEnum());
        // 422
        if (cartaoJaAssociado.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        try {
            Map<String, Object> retorno = clientCarteira.associarCartao(numeroCartao, new CarteiraParaClientForm(form.getCarteiraEnum(), form.getEmail()));

            Carteira novaCarteira = form.toModel(numeroCartao);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaCarteira.getId()).toUri();


            repositoryCarteira.save(novaCarteira);

            return ResponseEntity.created(uri).build();

        } catch (FeignException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Não foi possivel associar o cartão");
        }
    }

}
