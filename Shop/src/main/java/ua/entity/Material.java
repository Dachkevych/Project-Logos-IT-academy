package ua.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ua.validator.annotation.UniqueMaterial;

@Entity
@Table(name="material")
public class Material {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
	@UniqueMaterial
	private String name;
	
	@OneToMany(mappedBy="material")
	private List<Commodity>	commodities = new ArrayList<>();

	public Material() {
	}

	public Material(String name) {
		this.name = name;
	}

	public Material(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

}
