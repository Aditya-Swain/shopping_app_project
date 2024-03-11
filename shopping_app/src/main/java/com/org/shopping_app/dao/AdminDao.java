package com.org.shopping_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.shopping_app.dto.Admin;
import com.org.shopping_app.repository.AdminRepository;
@Component
public class AdminDao {
			@Autowired
			AdminRepository repo;
	
		//Save And Update Admin	
			
	public Admin saveAndUpdateAdmin(Admin admin) {
		return repo.save(admin);
	}
			
		
		//Verify Admin By Email And Password
			
	public List<Admin> verifyAdmin(String email, String password){
		return repo.findByEmailAndPassword(email, password); 
	}
	
	
}
