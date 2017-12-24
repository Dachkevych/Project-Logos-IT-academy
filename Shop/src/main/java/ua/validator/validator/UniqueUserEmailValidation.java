package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.UserEntityRepository;
import ua.validator.annotation.UniqueUserEmail;

@Component
public class UniqueUserEmailValidation implements ConstraintValidator<UniqueUserEmail, String>{

	@Autowired
	private UserEntityRepository repository;
	
	@Override
	public void initialize(UniqueUserEmail arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByEmail(arg0)==null;
	}

}
