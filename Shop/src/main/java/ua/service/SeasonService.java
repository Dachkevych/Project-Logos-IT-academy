package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.filter.SimpleFilter;
import ua.entity.Season;

public interface SeasonService extends CrudService<Season, Integer>{

	Page<Season> findAll(Pageable pageable, SimpleFilter filter);

}
