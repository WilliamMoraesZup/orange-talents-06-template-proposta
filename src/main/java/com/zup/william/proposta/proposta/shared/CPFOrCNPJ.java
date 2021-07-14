package com.zup.william.proposta.proposta.shared;


import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;


/**
 * https://gist.github.com/rponte/b7a827224c2ac88d588c2ed6fbeefd14
 * rponte
 *
 */

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR) // specifies OR as boolean operator instead of AND
@ReportAsSingleViolation // the error reports of each individual composing constraint are ignored
@Constraint(validatedBy = {}) // we don't need a validator :-)
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFOrCNPJ {

    String message() default "O CPF ou CNPJ digitado não é valido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

