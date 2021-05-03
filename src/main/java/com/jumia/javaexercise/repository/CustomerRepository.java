package com.jumia.javaexercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jumia.javaexercise.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	@Query("select c from Customer c where c.phone like %:country%")
	public List<Customer> findCustomersByCountry(@Param("country") String country);
	
	
	
	

}
