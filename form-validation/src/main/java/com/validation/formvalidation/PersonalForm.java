package com.validation.formvalidation;

import com.validation.formvalidation.validation.annotations.BrandPrefix;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonalForm {

    @NotNull
    @Size( min = 4, max = 10)
    @BrandPrefix
    private String name;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("PersonalForm{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
