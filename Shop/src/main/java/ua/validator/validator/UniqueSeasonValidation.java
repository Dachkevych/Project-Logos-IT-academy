package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.SeasonRepository;
import ua.validator.annotation.UniqueSeason;

public class UniqueSeasonValidation implements ConstraintValidator<UniqueSeason, String>{
	
	@Autowired
	private SeasonRepository repository;

	@Override
	public void initialize(UniqueSeason arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0)==null;
	}
	
	

}
