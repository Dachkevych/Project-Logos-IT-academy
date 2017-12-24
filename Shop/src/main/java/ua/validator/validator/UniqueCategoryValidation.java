package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.CategoryRepository;
import ua.validator.annotation.UniqueCategory;

@Component
public class UniqueCategoryValidation implements ConstraintValidator<UniqueCategory, String>{
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public void initialize(UniqueCategory arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0)==null;
	}

}
