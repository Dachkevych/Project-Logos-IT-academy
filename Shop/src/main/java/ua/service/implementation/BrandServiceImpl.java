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
import ua.entity.Brand;
import ua.repository.BrandRepository;
import ua.service.BrandService;

@Service
public class BrandServiceImpl extends CrudServiceImpl<Brand, Integer> implements BrandService{

	private final BrandRepository repository;
	
	@Autowired
	public BrandServiceImpl(BrandRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Brand> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(getSpecification(filter), pageable);
	}

	private Specification<Brand> getSpecification(SimpleFilter filter){
		return new Specification<Brand>() {

			@Override
			public Predicate toPredicate(Root<Brand> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
			
		};
	}
}
