package com.jumia.javaexercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.javaexercise.model.entity.Country;
import com.jumia.javaexercise.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	/********* getCountries: returns all valid countries to FE *********/
	
	@RequestMapping(value= "getCountries", method=RequestMethod.GET)
	public List<Country> getCountries() {
			return countryService.getCountries();
	}
}
