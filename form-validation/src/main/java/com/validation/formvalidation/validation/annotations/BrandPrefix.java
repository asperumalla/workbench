package com.validation.formvalidation.validation.annotations;

import com.validation.formvalidation.validation.validators.BrandPrefixValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Provide the custom validator class ( BrandPrefixValidator.class )  that validates the FILED annotated with BrandPrefix
 */
@Constraint(validatedBy = BrandPrefixValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BrandPrefix {

    String message() default "Brand Name is missing while filling the form";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
