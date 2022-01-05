package com.validation.formvalidation.validation.validators;

import com.validation.formvalidation.validation.annotations.BrandPrefix;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * It is required to override the isValid method of Parent class to provide
 * validation implementation.
 */
public class BrandPrefixValidator implements ConstraintValidator<BrandPrefix, String>  {

    @Override
    public boolean isValid (String brand, ConstraintValidatorContext constraintValidatorContext) {
        return brand.startsWith("@");
    }
}
