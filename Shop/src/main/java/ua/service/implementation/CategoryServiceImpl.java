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
import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category, Integer> implements CategoryService{

	private final CategoryRepository repository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Category> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(getSpecification(filter), pageable);
	}
	
	private Specification<Category> getSpecification(SimpleFilter filter){
		return new Specification<Category>() {

			@Override
			public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
			
		};
		
	}

}
