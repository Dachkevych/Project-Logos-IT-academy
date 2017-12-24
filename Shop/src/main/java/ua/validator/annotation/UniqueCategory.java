package ua.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.validator.validator.UniqueCategoryValidation;

@Retention(RetentionPolicy.RUNTIME)		//анотація буде використовуватись в самому коді
@Target(ElementType.FIELD)				//над якими елементами буде використовуватись анотація(FIELD-полями класу)
@Constraint(validatedBy = UniqueCategoryValidation.class)		//клас який буде проводити валідацію
public @interface UniqueCategory {

	String message() default "Not unique"; //значення по дефолту
	
	Class<?>[] groups () default {};		//якщо будемо передавати багато валідацій одночасно
	
	Class<? extends Payload>[] payload() default{};		
}
