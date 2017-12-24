package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.ColorRepository;
import ua.validator.annotation.UniqueColor;

@Component
public class UniqueColorValidation implements ConstraintValidator<UniqueColor, String>{
	
	@Autowired
	private ColorRepository repository;

	@Override
	public void initialize(UniqueColor arg0) {

	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0)==null;
	}
	
	

}
