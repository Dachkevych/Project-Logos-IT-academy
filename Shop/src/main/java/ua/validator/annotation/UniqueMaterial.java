package ua.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.validator.validator.UniqueMaterialValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueMaterialValidation.class)
public @interface UniqueMaterial {
	
	String message() default "Not Unique";
	
	Class<?>[] groups () default {};
		
	Class<? extends Payload>[] payload() default{};

}
