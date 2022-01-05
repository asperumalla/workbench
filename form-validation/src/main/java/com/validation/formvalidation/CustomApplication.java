package com.validation.formvalidation;

import com.validation.formvalidation.validation.annotations.UpperCase;
import com.validation.formvalidation.validation.validators.CustomAnnotationValidators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomApplication {

    @Test
    public void testNameValidation() throws IllegalAccessException {
        CustomForm cf = new CustomForm("alpha");
        cf = (CustomForm) CustomAnnotationValidators.applyAnnotations(cf);
        assertEquals("ALPHA", cf.getFirstName());

    }
}


class CustomForm{

    public CustomForm (String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName () {
        return firstName;
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("CustomForm{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @UpperCase
    private String firstName;
}
