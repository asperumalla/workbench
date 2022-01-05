package com.validation.formvalidation.validation.validators;

import com.validation.formvalidation.validation.annotations.UpperCase;

import java.lang.reflect.Field;

public class CustomAnnotationValidators {

    public  static Object applyAnnotations( Object object ) throws IllegalAccessException {

        Class clazz = object.getClass();

        for(Field filed : clazz.getDeclaredFields()){
            if( filed.isAnnotationPresent(UpperCase.class) ){
                filed.setAccessible(true);
                String s = (String)filed.get( object );
                filed.set(object, s.toUpperCase());
            }
        }

        return object;
    }

    public  static Object validateAnnotations( Object object ) throws Exception {

        Class clazz = object.getClass();

        for(Field filed : clazz.getDeclaredFields()){
            if( filed.isAnnotationPresent(UpperCase.class) ){
                filed.setAccessible(true);
                String s = (String)filed.get( object );
                filed.getName();
                throw new Exception( "The Field: "+filed.getName()+" cannot have this value :"+s );
            }
        }

        return object;
    }
}
