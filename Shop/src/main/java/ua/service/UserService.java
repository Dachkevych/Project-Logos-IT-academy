package ua.service;

import ua.domain.request.RegistrationRequest;
import ua.entity.UserEntity;

public interface UserService{

	void save(RegistrationRequest registrationRequest);

	UserEntity findOne(Integer id);
	
}
