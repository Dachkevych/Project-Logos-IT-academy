package ua.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import ua.domain.CommodityIndex;
import ua.domain.request.CommodityRequest;
import ua.entity.Commodity;

public interface CommodityMapper {
	
	public static CommodityIndex toCommodityIndex(Commodity commodity) {
		Integer id = commodity.getId();
		String photoUrl = commodity.getPhotoUrl();
		BigDecimal price = commodity.getPrice();
		String brand = commodity.getBrand().getName();
		String category = commodity.getCategory().getName();
		String sizeClothes = commodity.getSizeClothes().getValue();
		String sizeShoes = commodity.getSizeShoes().getValue();
		return new CommodityIndex(id, photoUrl, price, brand, category, sizeClothes, sizeShoes);
	}
	
	public static List<CommodityIndex> toCommodityIndex(List<Commodity> commodities){
		return commodities.stream()
				.map(CommodityMapper::toCommodityIndex)
				.collect(Collectors.toList());
	}
	
	public static Commodity toCommodity(CommodityRequest request) {
		Commodity commodity = new Commodity();
		commodity.setBrand(request.getBrand());
		commodity.setCategory(request.getCategory());
		commodity.setId(request.getId());
		commodity.setColor(request.getColor());
		commodity.setDescription(request.getDescription());
		commodity.setGender(request.getGender());
		commodity.setMaterial(request.getMaterial());
		commodity.setPrice(new BigDecimal(request.getPrice()));
		commodity.setSeason(request.getSeason());
		commodity.setSizeClothes(request.getSizeClothes());
		commodity.setSizeShoes(request.getSizeShoes());
		return commodity;
	}
	
}
