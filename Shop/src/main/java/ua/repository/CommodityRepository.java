package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.domain.CommodityIndex;
import ua.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Integer>{

	@Query("SELECT c FROM Commodity c JOIN FETCH c.brand JOIN FETCH c.category JOIN FETCH c.color JOIN FETCH c.gender JOIN FETCH c.material JOIN FETCH c.season")
	List<Commodity> findAll();

	@Query("SELECT new ua.domain.CommodityIndex(c.id, c.photoUrl, c.price, b.name, ct.name) FROM Commodity c JOIN c.brand b JOIN c.category ct")
	Page<CommodityIndex> findCommodityIndex(Pageable pageable);

//	@Query("SELECT new ua.domain.CommodityIndex(c.id, c.photoUrl, c.price, b.name, ct.name) FROM Commodity c JOIN c.brand b JOIN c.category ct")
//	Page<Commodity> findAll(Pageable pageable);

	Commodity findOne(Integer id);
}
