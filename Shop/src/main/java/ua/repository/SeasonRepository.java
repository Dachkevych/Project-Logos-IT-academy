package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer>{

	Season findByName(String arg0);

	Page<Season> findAll(Specification<Season> specification, Pageable pageable);

}
