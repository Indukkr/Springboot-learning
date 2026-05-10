package com.learning.springbootweb.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleAnnotation {


    String message() default "Role of an employee can either be USER or ADMIN" ;

    Class<?>[] groups() default {} ;

    Class<? extends Payload>[] payload() default {} ;
}
