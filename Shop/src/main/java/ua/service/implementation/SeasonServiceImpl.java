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
import ua.entity.Season;
import ua.repository.SeasonRepository;
import ua.service.SeasonService;

@Service
public class SeasonServiceImpl extends CrudServiceImpl<Season, Integer> implements SeasonService{

	private final SeasonRepository repository;
	
	@Autowired
	public SeasonServiceImpl(SeasonRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Season> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(getSpecification(filter), pageable);
	}
	
	public Specification<Season> getSpecification(SimpleFilter filter){
		return new Specification<Season>() {

			@Override
			public Predicate toPredicate(Root<Season> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
		};
		
	}
}
