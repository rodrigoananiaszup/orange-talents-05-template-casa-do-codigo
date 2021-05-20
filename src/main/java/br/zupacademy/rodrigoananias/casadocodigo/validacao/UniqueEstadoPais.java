package br.zupacademy.rodrigoananias.casadocodigo.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {UniqueEstadoPaisValidator.class})
public @interface UniqueEstadoPais {
    String message() default "Error: Somente valores únicos!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName1();
    String fieldName2();
    Class<?> domainClass();
}