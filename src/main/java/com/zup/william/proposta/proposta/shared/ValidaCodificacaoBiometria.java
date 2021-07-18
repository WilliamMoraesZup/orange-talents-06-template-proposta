package com.zup.william.proposta.proposta.shared;

import com.zup.william.proposta.proposta.errorHandlers.ApiErroException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotBlank;


public class ValidaCodificacaoBiometria implements ConstraintValidator<ValidaBiometria, String> {


    @Override
    public void initialize(ValidaBiometria constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(@NotBlank String value, ConstraintValidatorContext context) {
        Assert.notNull(value, "A biometria não foi informada corretamente");

        //decoda
        byte[] bytesDecoded = Base64.decodeBase64(value);

        //encoda
        String valorCodadoNovamente = new String(Base64.encodeBase64(bytesDecoded));

        if (value.equals(valorCodadoNovamente)) {
            return true;
        }
        throw new ApiErroException(HttpStatus.BAD_REQUEST, "A biometria informada está incorreta");
    }

}



