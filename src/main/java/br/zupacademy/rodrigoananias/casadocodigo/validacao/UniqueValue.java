package br.zupacademy.rodrigoananias.casadocodigo.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//cria validador @UniqueValue
@Documented
@Constraint(validatedBy = { UniqueValueValidator.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
	String message() default "Error Not Unique: O valor informado deve ser único!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String fieldName();

	Class<?> domainClass();

}
