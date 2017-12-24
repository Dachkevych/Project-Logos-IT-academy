package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.GenderRepository;
import ua.validator.annotation.UniqueGender;

@Component
public class UniqueGenderValidation implements ConstraintValidator<UniqueGender, String>{
	
	@Autowired
	private GenderRepository repository;

	@Override
	public void initialize(UniqueGender arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0)==null;
	}
	
	

}
