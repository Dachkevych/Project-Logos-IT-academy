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
import ua.entity.Material;
import ua.repository.MaterialRepository;
import ua.service.MaterialService;

@Service
public class MaterialServiceImpl extends CrudServiceImpl<Material, Integer> implements MaterialService{

	private final MaterialRepository reposiroty;
	
	@Autowired
	public MaterialServiceImpl(MaterialRepository repository) {
		super(repository);
		this.reposiroty = repository;
	}

	@Override
	public Page<Material> findAll(Pageable pageable, SimpleFilter filter) {
		return reposiroty.findAll(getSpecification(filter), pageable);
	}
	
	public Specification<Material> getSpecification(SimpleFilter filter){
		return new Specification<Material>() {

			@Override
			public Predicate toPredicate(Root<Material> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
		};
		
	}

	

}
