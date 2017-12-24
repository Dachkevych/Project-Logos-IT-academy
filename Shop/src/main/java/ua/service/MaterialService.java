package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.filter.SimpleFilter;
import ua.entity.Material;

public interface MaterialService extends CrudService<Material, Integer>{

	Page<Material> findAll(Pageable pageable, SimpleFilter filter);

}
