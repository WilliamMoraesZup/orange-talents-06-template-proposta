package com.zup.william.proposta.proposta.shared;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {ValidaUnicidadeSistemaValidator.class})
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DeveSerUnico {


    String campo();

    Class entidade();

    String message() default "O campo já se encontrada cadastrado no sistema";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
