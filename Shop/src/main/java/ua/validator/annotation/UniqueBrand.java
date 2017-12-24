package ua.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.validator.validator.UniqueBrandValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueBrandValidation.class)
public @interface UniqueBrand {
	
	String message() default "Not Unique";
	
	Class<?>[] groups () default {};
		
	Class<? extends Payload>[] payload() default{};

}
