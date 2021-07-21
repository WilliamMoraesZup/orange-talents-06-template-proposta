package com.zup.william.proposta.proposta.shared;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

@Constraint(validatedBy = {ValidaExistenciaValidator.class})
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})

@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaExistencia {


    String campo();

    Class entidade();

    String message() default "O campo informado não existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
