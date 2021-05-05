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

import com.jumia.javaexercise.model.entity.Country;
import com.jumia.javaexercise.service.CountryService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CountryController.class)
class CountryControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CountryService countryService;
	
	List<Country>  mockCountry = new ArrayList<Country>();
	
	@Test
	void testGetCountries() throws Exception {
		mockCountry.add(new Country(0, "Cameroon", "CR", "(237)", "\\(237\\)\\ ?[2368]\\d{7,8}$"));
		
		System.out.println(mockCountry);
		Mockito.when(countryService.getCountries()).thenReturn(mockCountry);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/getCountries").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(request).andReturn();
		String expected =  "[{ 'id': 0, 'name': 'Cameroon', 'label': 'CR', 'code': '(237)', 'regex': '\\\\(237\\\\)\\\\ ?[2368]\\\\d{7,8}$' }]";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}


}
