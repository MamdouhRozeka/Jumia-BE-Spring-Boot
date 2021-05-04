package com.jumia.javaexercise.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {
	
	@Id
	private int id;
	
	private String name;
	
	private String phone;
	
	@Transient
	private String country; 
	
	@Transient
	private String countryCode;

	@Transient
	private boolean state;
	

	public Customer() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCountry() {
		return country;
	}

	@Transient
	public void setCountry(String country) {
		this.country = country;
	}

	@Transient
	public String getCountryCode() {
		return countryCode;
	}

	@Transient
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Transient
	public boolean isState() {
		return state;
	}

	@Transient
	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

	
	
}
