package com.jumia.javaexercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.javaexercise.model.CountryEnum;
import com.jumia.javaexercise.model.entity.Customer;
import com.jumia.javaexercise.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    
    
    public String codeToRegex(String code) {
    for (CountryEnum country : CountryEnum.values()) {
        if (country.getCode().contains(code)) {
            return country.getRegex();
        }
    }
    return "";
   }
    
    public boolean codeValidation(Customer customer, String country) {
    		
    	return Pattern.compile(country != null ?
    			Enum.valueOf(CountryEnum.class, country.toUpperCase()).getRegex() :
    			codeToRegex(customer.getPhone().substring(customer.getPhone().indexOf("("), customer.getPhone().indexOf(")")+ 1))
    			).matcher(customer.getPhone()).find();
       }
    
    

    public List<Customer> getCustomersByFilter(String country, String state){
            try {
                List<Customer> customers = new ArrayList<>();
                if(country != null) {
                	CountryEnum countryEnum = Enum.valueOf(CountryEnum.class, country.toUpperCase());
                	customers = customerRepository.findCustomersByCountry(countryEnum.getCode());
                }
                else
                	customers = getCustomers();
                
                if(state != null)
                {
                	List<Customer> filteredCustomers = customers.stream().filter(
                			c -> state.equals("true") ? codeValidation(c, country) 
                					: state.equals("false") ? !codeValidation(c, country) : false
                			).collect(Collectors.toList());
                	
                	return filteredCustomers;
                }
                	return customers;
            }catch (Exception e){
                throw e;
            }
        }

    
}
