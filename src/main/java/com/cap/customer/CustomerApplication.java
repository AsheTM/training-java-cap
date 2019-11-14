package com.cap.customer;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cap.customer.dao.CustomerRepository;
import com.cap.customer.data.Customer;

@SpringBootApplication
public class CustomerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository) {
		return args -> {
			// Save a few customers
			customerRepository.save(new Customer("FN1", "LN1"));
			customerRepository.save(new Customer("FN2", "LN2"));
			customerRepository.save(new Customer("FN3", "LN3"));
			customerRepository.save(new Customer("FN4", "LN4"));
			customerRepository.save(new Customer("FN5", "LN5"));
			
			// Fetch all customer
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for(Customer customer: customerRepository.findAll()) {
				log.info(customer.toString());
			}
			
			// Fetch individual customer by ID
			Optional<Customer> customer = customerRepository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("---------------------------------");
			log.info(customer.get().toString());
			log.info("");
			
			// Fetch customers by last name
			log.info("Customer found with findByLastName('Bauer')");
			log.info("-------------------------------------------");
			
		};
	}

}
