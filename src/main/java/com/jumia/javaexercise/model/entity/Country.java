package com.jumia.javaexercise.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id
	private int id;
	
	private String name;

	private String label;
	
	private String code;
	
	private String regex;
	
	

	public Country(int id, String name, String label, String code, String regex) {
		this.id = id;
		this.name = name;
		this.label = label;
		this.code = code;
		this.regex = regex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}
	

	
	

}
