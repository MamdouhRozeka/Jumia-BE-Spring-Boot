package com.jumia.javaexercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jumia.javaexercise.model.CountryEnum;
import com.jumia.javaexercise.model.entity.Country;

@Service
public class CountryService {

//----- NOTE: Country Enum was created to expose the current list of countries to FE so as when scaling up the change is localized to BE changes only -----//
    
	/********* getCountries: returns all countries from Country Enum *********/
	
	public List<Country> getCountries(){
      try {
                List<Country> countries = new ArrayList<>();
                int index = 0;
                for (CountryEnum countryEnum : CountryEnum.values()) {
                    Country country = new Country(index++, countryEnum.getName(),countryEnum.getLabel(), countryEnum.getCode(), countryEnum.getRegex());
                    countries.add(country);
                }
                return countries ;
            }catch (Exception e){
                throw e;
            }

        }
}
