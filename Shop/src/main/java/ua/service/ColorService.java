package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.filter.SimpleFilter;
import ua.entity.Color;

public interface ColorService extends CrudService<Color, Integer>{

	Page<Color> findAll(Pageable pageable, SimpleFilter filter);

}
