package ua.domain.request;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.*;

public class CommodityRequest {

	private Integer id;
	
	private Brand brand;
	
	private MultipartFile file;
	
	private String name;
	
	private Gender gender;
	
	private Color color;
	
	private Season season;
	
	private Material material;
	
	private String price;
	
	private String description;
	
	private Category category;
	
	private SizeClothes sizeClothes;	
	
	private SizeShoes sizeShoes;
	
	private UserEntity owner;

	public CommodityRequest(Integer id, Brand brand, MultipartFile file, String name, Gender gender, Color color,
			Season season, Material material, String price, String description, Category category,
			SizeClothes sizeClothes, SizeShoes sizeShoes, UserEntity owner) {
		this.id = id;
		this.brand = brand;
		this.file = file;
		this.name = name;
		this.gender = gender;
		this.color = color;
		this.season = season;
		this.material = material;
		this.price = price;
		this.description = description;
		this.category = category;
		this.sizeClothes = sizeClothes;
		this.sizeShoes = sizeShoes;
		this.owner = owner;
	}
	
	public CommodityRequest() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SizeClothes getSizeClothes() {
		return sizeClothes;
	}

	public void setSizeClothes(SizeClothes sizeClothes) {
		this.sizeClothes = sizeClothes;
	}

	public SizeShoes getSizeShoes() {
		return sizeShoes;
	}

	public void setSizeShoes(SizeShoes sizeShoes) {
		this.sizeShoes = sizeShoes;
	}

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}
	
	
}
