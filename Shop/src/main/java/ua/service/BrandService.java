package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.filter.SimpleFilter;
import ua.entity.Brand;

public interface BrandService extends CrudService<Brand, Integer>{

	Page<Brand> findAll(Pageable pageable, SimpleFilter filter);

}
