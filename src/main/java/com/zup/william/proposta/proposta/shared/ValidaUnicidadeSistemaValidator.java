package com.zup.william.proposta.proposta.shared;

import com.zup.william.proposta.proposta.errorHandlers.ApiErroException;
import org.springframework.http.HttpStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidaUnicidadeSistemaValidator implements ConstraintValidator<DeveSerUnico, String> {

    private String campo;
    private Class entidade;

    @PersistenceContext
    private EntityManager manager;


    @Override
    public void initialize(DeveSerUnico constraintAnnotation) {

        campo = constraintAnnotation.campo();
        entidade = constraintAnnotation.entidade();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query buscaValor = manager.createQuery("from " + entidade.getName() + " where " + campo + "=:pValue");
        buscaValor.setParameter("pValue", value);
        List resultList = buscaValor.getResultList();
        if (resultList.size() > 0) {
            throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Esse requisitante já solicitou uma proposta");

        }

        return true;
    }
}
