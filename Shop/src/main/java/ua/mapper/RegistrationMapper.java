package ua.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.domain.request.RegistrationRequest;
import ua.entity.Role;
import ua.entity.UserEntity;

public interface RegistrationMapper {
	
	public static User toUser(UserEntity entity){
		return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	public static UserEntity map(RegistrationRequest registrationRequest) {		//перетворення об'єкт entity в DTO(щоб уникнути LEsyInicilizationException)
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(registrationRequest.getEmail());					
		userEntity.setName(registrationRequest.getName());
		userEntity.setLastname(registrationRequest.getLastname());
		userEntity.setSurname(registrationRequest.getSurname());
		userEntity.setPassword(registrationRequest.getPassword());
		userEntity.setRole(Role.ROLE_USER_OWNER);
		return userEntity;
	}
}
