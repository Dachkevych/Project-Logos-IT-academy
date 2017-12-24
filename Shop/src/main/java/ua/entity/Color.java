package ua.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ua.validator.annotation.UniqueColor;

@Entity
@Table(name="color")
public class Color {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
	@UniqueColor
	private String name;
	
	@OneToMany(mappedBy="color")
	private List<Commodity> commodities = new ArrayList<>();
	
	public Color() {
	}

	public Color(String name) {
		this.name = name;
	}
	
	public Color(Integer id, String name) {
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
