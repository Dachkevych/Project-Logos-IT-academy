package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{

	UserEntity findByEmail(String email);

	@Query("FROM UserEntity WHERE email=?1")
	UserEntity findForAuth(String email);
}
