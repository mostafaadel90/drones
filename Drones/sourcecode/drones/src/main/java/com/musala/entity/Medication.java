package com.musala.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	String name;
	String code;
	Integer weight;
	String image;


	
	public Medication() {
		
	}
	public Medication(Integer id, String name, String code, Integer weight, String image) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.weight = weight;
		this.image = image;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
