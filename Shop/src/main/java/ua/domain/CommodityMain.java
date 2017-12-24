package ua.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Brand;
import ua.entity.Color;
import ua.entity.Gender;
import ua.entity.Material;
import ua.entity.Season;
import ua.entity.SizeClothes;
import ua.entity.Category;

public class CommodityMain {
	
	private Brand brand;
	
	private Gender gender;
	
	private List<PhotoDto> photos = new ArrayList<>();
	
	private MultipartFile url;
	
	private String namePhoto;
	
	private Category category;
	
	private BigDecimal price;
	
	private SizeClothes sizeClothes;
	
	private Color color;
	
	private Season season;
	
	private Material material;
	
	private String description;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<PhotoDto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoDto> photos) {
		this.photos = photos;
	}

	public MultipartFile getUrl() {
		return url;
	}

	public void setUrl(MultipartFile url) {
		this.url = url;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getNamePhoto() {
		return namePhoto;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategoryS(Category category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public SizeClothes getSizeClothes() {
		return sizeClothes;
	}

	public void setSizeClothes(SizeClothes sizeClothes) {
		this.sizeClothes = sizeClothes;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
