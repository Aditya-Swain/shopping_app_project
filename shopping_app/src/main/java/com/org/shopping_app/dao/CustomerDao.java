package com.org.shopping_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.shopping_app.dto.Customer;
import com.org.shopping_app.repository.CustomerRepository;

@Component
public class CustomerDao {
		
	@Autowired
	CustomerRepository repo;
	
	// --------Save and update customer-----------
	
	public Customer saveAndUpdate(Customer customer) {
		return repo.save(customer);
	}
	
	//--------Fetch all Customers---------
	
	public List<Customer> fetchAllCustomer(){
		return repo.findAll();
	}
	
	
	//--------Fetch by id-------------
	
	public Customer fetchById(int id) {
		Optional<Customer> optional = repo.findById(id);
		
		if(optional != null) {
			return optional.get();
		}
		return null;
	}
	
	
	//---------Verify Customer-----------
	
	public List<Customer> verifyCustomer(String email,String password){
		return repo.findByEmailAndPassword(email, password);
	}
	
	
	//---------Delete Customer by id---------
	
	public Customer deleteById(int id) {
		Customer customer = fetchById(id);
		
		if(customer != null) {
			repo.delete(customer);
			return customer;
		}
		
		return null;
	}
	
	
	
}
