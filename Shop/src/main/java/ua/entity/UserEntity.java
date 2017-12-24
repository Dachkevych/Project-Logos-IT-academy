package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ua.validator.annotation.UniqueUserEmail;

@Entity
@Table(name="userEntity")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@UniqueUserEmail
	private String email;
	
	private String password;
	
	private String surname;
	
	private String lastname;
	
	private String name;
	
	private Role role;
	
	@OneToMany(mappedBy="userEntity")
	private List<OrderCommodity> orderCommodity = new ArrayList<>();
	
	public UserEntity() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<OrderCommodity> getOrder() {
		return orderCommodity;
	}

	public void setOrder(List<OrderCommodity> orderCommodity) {
		this.orderCommodity = orderCommodity;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + "]";
	}
}

