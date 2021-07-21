package com.zup.william.proposta.proposta.shared;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;


@NotBlank
@ConstraintComposition(CompositionType.OR) // specifies OR as boolean operator instead of AND
@Constraint(validatedBy = {ValidaBiometriaValidator.class})
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaBiometria {



    String message() default "A biometria informada é invalida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
