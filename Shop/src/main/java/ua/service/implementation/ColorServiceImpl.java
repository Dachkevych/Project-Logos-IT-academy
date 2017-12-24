package ua.service.implementation;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.domain.filter.SimpleFilter;
import ua.entity.Color;
import ua.repository.ColorRepository;
import ua.service.ColorService;

@Service
public class ColorServiceImpl extends CrudServiceImpl<Color, Integer> implements ColorService{

	private final ColorRepository repository;
	
	@Autowired
	public ColorServiceImpl(ColorRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Color> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(getSpecification(filter), pageable);
	}
	
	public Specification<Color> getSpecification(SimpleFilter filter){
		return new Specification<Color>() {

			@Override
			public Predicate toPredicate(Root<Color> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
		};
		
	}


}
