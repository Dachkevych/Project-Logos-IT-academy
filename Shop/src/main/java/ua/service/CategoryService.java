package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.filter.SimpleFilter;
import ua.entity.Category;

public interface CategoryService extends CrudService<Category, Integer>{

	Page<Category> findAll(Pageable pageable, SimpleFilter filter);

}
