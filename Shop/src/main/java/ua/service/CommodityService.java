package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.CommodityIndex;
import ua.domain.request.CommodityRequest;
import ua.entity.Commodity;

public interface CommodityService extends CrudService<Commodity, Integer>{

	public List<Commodity> findAll();
	
	public void save(CommodityRequest request);

	Page<CommodityIndex> findCommodityIndex(Pageable pageable);

	Commodity findOne(Integer id);

	public Page<Commodity> findAll(Pageable p);
	
}
