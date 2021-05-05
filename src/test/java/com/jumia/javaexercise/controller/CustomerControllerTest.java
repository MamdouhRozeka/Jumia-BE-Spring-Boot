package com.jumia.javaexercise.controller;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jumia.javaexercise.model.entity.Customer;
import com.jumia.javaexercise.service.CustomerService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CustomerService customerService;
	
	List<Customer>  mockCustomer = new ArrayList<Customer>();

	@Test
	void testGetCustomers() throws Exception {
		
		Customer test = new Customer();
		
		mockCustomer.add(test);
		
		Mockito.when(customerService.getCustomersByFilter(Mockito.anyString(),Mockito.anyString())).thenReturn(mockCustomer);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/getCustomers").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(request).andReturn();
		String expected =  "[{ 'id': 0, 'name': 'Walid Hammadi', 'phone': '(212) 6007989253'}]";
	}
		

}
