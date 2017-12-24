package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer>, JpaSpecificationExecutor<Gender>{

	Gender findByName(String arg0);

}
