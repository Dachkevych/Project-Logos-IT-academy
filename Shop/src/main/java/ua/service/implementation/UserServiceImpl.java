package ua.service.implementation;

import static ua.mapper.RegistrationMapper.toUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.domain.request.RegistrationRequest;
import ua.entity.UserEntity;
import ua.mapper.RegistrationMapper;
import ua.repository.UserEntityRepository;
import ua.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{
	
	@Autowired
	private UserEntityRepository repository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserEntity entity = repository.findByEmail(login);
		if(entity==null) throw new UsernameNotFoundException("User with "+login+" not found");
		return toUser(entity);
	}

	@Override
	public void save(RegistrationRequest registrationRequest) {
		UserEntity userEntity = RegistrationMapper.map(registrationRequest);
		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		repository.save(userEntity);	
		
	}

	@Override
	public UserEntity findOne(Integer id) {
		return repository.findOne(id);
	}

}
