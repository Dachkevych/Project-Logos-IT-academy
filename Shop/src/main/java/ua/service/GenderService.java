package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.filter.SimpleFilter;
import ua.entity.Gender;

public interface GenderService extends CrudService<Gender, Integer>{

	Page<Gender> findAll(Pageable pageable, SimpleFilter filter);

}
