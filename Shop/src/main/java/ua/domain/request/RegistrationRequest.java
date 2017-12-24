package ua.domain.request;

import javax.validation.constraints.AssertTrue;

public class RegistrationRequest {
	
	private String email;				//ДАНІ З UserEntity
	
	private String password;
	
	private String passwordRepeat;		//ДЛЯ РЕЄСТРАЦІЇ, ПІДТВЕРДЖЕННЯ ПАРОЛЮ
	
	private String lastname;
	
	private String name;
	
	private String surname;
	
	private boolean isOwner;
	
	@AssertTrue(message="Not equal")
	public boolean getCheckPassword(){
		if(password==null) return false;
		return password.equals(passwordRepeat);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsOwner() {
		return getIsOwner();
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [email=" + email + ", password=" + password + ", passwordRepeat=" + passwordRepeat
				+ ", isOwner=" + isOwner + "]";
	}
}
