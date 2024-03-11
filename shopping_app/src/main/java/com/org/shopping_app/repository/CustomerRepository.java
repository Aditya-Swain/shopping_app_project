package com.org.shopping_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.shopping_app.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
		
	
	List<Customer> findByEmailAndPassword(String email,String password);
}
