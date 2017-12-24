package ua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration		//це клас який налаштовує наш проект
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService service;
	
	@Autowired
	public void configurerAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {	//дані повинні бути закодовані()-ким закодований
		authenticationManagerBuilder.userDetailsService(service).passwordEncoder(passwordEncoder());
	}	 
	
	//
	//userDetailsService - відповідає за кодування
	//passwordEncoder - хто кодує паролі
	
	
	@Bean
	public PasswordEncoder passwordEncoder() { // - для того щоб був біном
		return new BCryptPasswordEncoder();  //-об'єкт який вміє кодувати
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {								 										
		http.formLogin().loginPage("/login").//ВІДКРИЄ СТОРІНКУ ЛОГІНУВАННЯ	
		loginProcessingUrl("/login").		//саме логінування
		usernameParameter("email").			//пошук юзера по email(логін)
		failureUrl("/login?fail=true")		//якщо не правильно введе дані юзер
	.and().logout().						//
		logoutUrl("/logout").				//логаут по якій ссилці
		logoutSuccessUrl("/").  			//вийде коли користувач захоче вийти
		deleteCookies("JSESSIONID", "Secret_cookei")		//що видалити з Cookki якщо користувач вийде
	.and().authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().permitAll()
	.and()
		.exceptionHandling().accessDeniedPage("/")
	.and()
		.sessionManagement().maximumSessions(1)
	.and().and()
		.rememberMe()
		.rememberMeParameter("rememberMe")
		.key("my super secret key")
		.rememberMeCookieName("Secret_cookei");;
	}
}
