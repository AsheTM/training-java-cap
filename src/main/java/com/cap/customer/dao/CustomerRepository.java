package com.cap.customer.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cap.customer.data.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findByLastName(String lastName);
	
	Optional<Customer> findById(Long id);

}
