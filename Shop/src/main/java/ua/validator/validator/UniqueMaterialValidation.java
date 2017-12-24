package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.MaterialRepository;
import ua.validator.annotation.UniqueMaterial;

@Component
public class UniqueMaterialValidation implements ConstraintValidator<UniqueMaterial, String>{

	@Autowired
	private MaterialRepository repository;

	@Override
	public void initialize(UniqueMaterial arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0)==null;
	}
	
	
}
