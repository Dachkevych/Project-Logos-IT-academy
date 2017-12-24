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
import ua.entity.Gender;
import ua.repository.GenderRepository;
import ua.service.GenderService;

@Service
public class GenderServiceImpl extends CrudServiceImpl<Gender, Integer> implements GenderService{

	private final GenderRepository repository;
	
	@Autowired
	public GenderServiceImpl(GenderRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Gender> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(getSpecification(filter), pageable);
	}

	public Specification<Gender> getSpecification(SimpleFilter filter){
		return new Specification<Gender>() {

			@Override
			public Predicate toPredicate(Root<Gender> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
		};
		
	}

}
