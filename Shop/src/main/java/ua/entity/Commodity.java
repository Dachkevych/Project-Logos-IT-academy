package ua.entity;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="commodity")
public class Commodity {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = LAZY)
	private Brand brand;			//
	
	@ManyToOne(fetch = LAZY)
	private Gender gender;			//

	@OneToMany(mappedBy = "commodity")
	private List<Photo> photos = new ArrayList<>();

	private String photoUrl;	
	
	@ManyToOne(fetch = LAZY)
	private Category category; 		//
	
	private BigDecimal price;		//
	
	private SizeClothes sizeClothes;	//
	
	private SizeShoes sizeShoes; 		//
	
	@ManyToOne(fetch = LAZY)
	private Color color;			//
	
	@ManyToOne(fetch = LAZY)
	private Season season;			//
	
	@ManyToOne(fetch = LAZY)
	private Material material;		//
	
	private String description;
	
	@OneToMany(mappedBy="commodity")
	private List<OrderCommodity> orderCommodities = new ArrayList<>();
	
	public Commodity() {
	}

	public Commodity(Integer id, Brand brand, Gender gender, List<Photo> photos, String photoUrl,
			Category category, BigDecimal price, SizeClothes sizeClothes, SizeShoes sizeShoes, Color color,
			Season season, Material material, String description, List<OrderCommodity> orderCommodities) {
		this.id = id;
		this.brand = brand;
		this.gender = gender;
		this.photos = photos;
		this.photoUrl = photoUrl;
		this.category = category;
		this.price = price;
		this.sizeClothes = sizeClothes;
		this.sizeShoes = sizeShoes;
		this.color = color;
		this.season = season;
		this.material = material;
		this.description = description;
		this.orderCommodities = orderCommodities;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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

	public SizeShoes getSizeShoes() {
		return sizeShoes;
	}

	public void setSizeShoes(SizeShoes sizeShoes) {
		this.sizeShoes = sizeShoes;
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

	public List<OrderCommodity> getOrderCommodities() {
		return orderCommodities;
	}

	public void setOrderCommodities(List<OrderCommodity> orderCommodities) {
		this.orderCommodities = orderCommodities;
	}

	
}
