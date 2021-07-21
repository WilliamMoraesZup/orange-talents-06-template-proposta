package com.zup.william.proposta.proposta.shared;

import com.zup.william.proposta.proposta.errorHandlers.ApiErroException;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidaExistenciaValidator implements ConstraintValidator<ValidaExistencia, String> {

    private String campo;
    private Class<?> entidade;
    @PersistenceContext
    private EntityManager manager;


    @Override
    public void initialize(ValidaExistencia constraintAnnotation) {
        campo = constraintAnnotation.campo();
        entidade = constraintAnnotation.entidade();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {


        Query query = manager.createQuery("select 1 from " + entidade.getName() + " where " + campo + "=:value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <2, "Existe um bug no sistema pois foram encontrados mais de um registro no sistema");
        if (list.size() < 1) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "O cartão informado não foi encontrado");
        }
        return list.size() == 1;
    }
}
