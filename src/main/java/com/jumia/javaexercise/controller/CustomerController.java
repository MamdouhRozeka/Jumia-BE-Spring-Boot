package com.jumia.javaexercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.javaexercise.model.entity.Customer;
import com.jumia.javaexercise.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value= "info", method=RequestMethod.GET)
	public String info() {
		return "The application is up...";
	}
	
	@RequestMapping(value= "getCustomers", method=RequestMethod.GET)
	public List<Customer> getCustomers(@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "state", required = false) String state) {
			return customerService.getCustomersByFilter(country, state);
	}
	
//	@RequestMapping(value= "readCustomers", method=RequestMethod.GET)
//	public List<Customer> readCustomersByRegion) {
//		return customerService.readCustomers();
//	}
//	
}
