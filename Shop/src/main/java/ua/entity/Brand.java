package ua.entity;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ua.validator.annotation.UniqueBrand;

@Entity
@Table(name="brand")
public class Brand {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
	@UniqueBrand
	private String name;
	
	@OneToMany(mappedBy="brand")
	private List<Commodity>	commodities = new ArrayList<>();

	public Brand() {
	}

	public Brand(String name) {
		this.name = name;
	}

	public Brand(Integer id, String name) {
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
