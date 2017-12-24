package ua.service.implementation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static ua.mapper.CommodityMapper.*;

import ua.domain.CommodityIndex;
import ua.domain.request.CommodityRequest;
import ua.entity.Commodity;
import ua.repository.CommodityRepository;
import ua.service.CommodityService;

@Service
public class CommodityServiceImpl extends CrudServiceImpl<Commodity, Integer> implements CommodityService{

	private final CommodityRepository repository;
	
	@Value("${file.path}")
	private String path;
	
	@Autowired
	public CommodityServiceImpl(CommodityRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public void save(CommodityRequest request) {
		Commodity commodity = toCommodity(request);
		MultipartFile file = request.getFile();
		if(file != null && !file.isEmpty()) {
			String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
			String fileName = UUID.randomUUID().toString()+extention;
			try {
				file.transferTo(new File(path+fileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			commodity.setPhotoUrl(fileName);
		}
		System.out.println(commodity.getPhotoUrl() + "------------------");
		repository.save(commodity);
	}

	@Override
	public List<Commodity> findAll() {
		return repository.findAll();	
	}

	@Override
	public Commodity findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Commodity> findAll(Pageable p) {
		return repository.findAll(p);
	}

	@Override
	public Page<CommodityIndex> findCommodityIndex(Pageable pageable) {
		return repository.findCommodityIndex(pageable);
	}

}
