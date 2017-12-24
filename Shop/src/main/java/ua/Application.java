package ua;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ua.entity.Role;
import ua.entity.UserEntity;
import ua.repository.UserEntityRepository;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		addAdmin(SpringApplication.run(Application.class, args));
	}
	
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	static void addAdmin(ConfigurableApplicationContext run) {
		UserEntityRepository repository = run.getBean(UserEntityRepository.class);
		UserEntity user = repository.findByEmail("admin");
		if(user==null) {
			PasswordEncoder encoder = run.getBean(PasswordEncoder.class);
			user = new UserEntity();
			user.setEmail("admin");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			repository.save(user);
		}
	}
	 
	@Bean
	HandlerMethodArgumentResolver resolver(){
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setOneIndexedParameters(true);
		resolver.setPageParameterName("page");
		resolver.setSizeParameterName("size");
		return resolver;
	}
	
}
