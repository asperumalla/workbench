package com.validation.formvalidation.validation.validators;

import com.validation.formvalidation.validation.annotations.BrandPrefix;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class BrandPrefixValidator implements ConstraintValidator<BrandPrefix, String>  {

    @Override
    public void initialize (BrandPrefix constraintAnnotation) {}

    @Override
    public boolean isValid (String brand, ConstraintValidatorContext constraintValidatorContext) {
        return brand.startsWith("@");
    }
}
