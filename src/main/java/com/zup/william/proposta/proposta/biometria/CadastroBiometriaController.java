package com.zup.william.proposta.proposta.biometria;

import com.zup.william.proposta.proposta.errorHandlers.ApiErroException;
import com.zup.william.proposta.proposta.novaProposta.NovaProposta;
import com.zup.william.proposta.proposta.novaProposta.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;


@RestController
public class CadastroBiometriaController {

    @Autowired
    private PropostaRepository repository;

    @PostMapping("/biometria")
    @Transactional
    public ResponseEntity<?> novaBiometria(@RequestParam String idCartao, @RequestBody @Valid BiometriaForm form, UriComponentsBuilder uriComponentsBuilder) {

        Optional<NovaProposta> byNumeroCartao = repository.findByNumeroCartao(idCartao);
        Biometria novaBiometria = form.toModel();

        if (byNumeroCartao.isPresent()) {


            NovaProposta proposta = byNumeroCartao.get();
            proposta.adicionaBiometria(novaBiometria);
            repository.save(proposta);

        } else {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "O cartão não foi encontrado no sistema");
        }

        URI uri = uriComponentsBuilder.path("/biometria/{id}").buildAndExpand(novaBiometria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
