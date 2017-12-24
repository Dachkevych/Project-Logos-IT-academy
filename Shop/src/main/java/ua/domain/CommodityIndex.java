package ua.domain;

import java.math.BigDecimal;

public class CommodityIndex {
	
	private Integer id;
	
	private String photoUrl;
	
	private BigDecimal price;
	
	private String brand;
	
	private String category;
	
	private String sizeClothes;
	
	private String sizeShoes;

	public CommodityIndex(Integer id, String photoUrl, BigDecimal price, String brand, String category,
			String sizeClothes, String sizeShoes) {
		this.id = id;
		this.photoUrl = photoUrl;
		this.price = price;
		this.brand = brand;
		this.category = category;
		this.sizeClothes = sizeClothes;
		this.sizeShoes = sizeShoes;
	}
	
	public CommodityIndex(Integer id, String photoUrl, BigDecimal price, String brand, String category) {
		this.id = id;
		this.photoUrl = photoUrl;
		this.price = price;
		this.brand = brand;
		this.category = category;
	}



	public CommodityIndex() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSizeClothes() {
		return sizeClothes;
	}

	public void setSizeClothes(String sizeClothes) {
		this.sizeClothes = sizeClothes;
	}

	public String getSizeShoes() {
		return sizeShoes;
	}

	public void setSizeShoes(String sizeShoes) {
		this.sizeShoes = sizeShoes;
	}
	
}