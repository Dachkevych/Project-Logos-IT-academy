package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.BrandRepository;
import ua.validator.annotation.UniqueBrand;

@Component
public class UniqueBrandValidation implements ConstraintValidator<UniqueBrand, String>{
	
	@Autowired
	private BrandRepository repository;

	@Override
	public void initialize(UniqueBrand arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0)==null;
	}

}
