package com.org.shopping_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.shopping_app.dto.Seller;
import com.org.shopping_app.repository.SellerRepository;

@Component
public class SellerDao {
		
	@Autowired
	SellerRepository repo;
	
	// Save And Update Seller
	public Seller saveAndUpdate(Seller seller) {
		
		return repo.save(seller);
	}
	
	//Fetch All Seller
	public List<Seller> fetchAllSeller(){
		
		return repo.findAll();
	}
	
	
	//Fetch By Email And Password
	
	public List<Seller> fetchByEmailAndPassword(String email ,String password){
		
		return repo.findByEmailAndPassword(email, password);
	}
	
	
	//Fetch Seller By Id
	
	public Seller fetchById(int id) {
		
		Optional<Seller> optional = repo.findById(id);
		
		if(optional != null) {
			return optional.get();
		}
		return null;
	}
	
	
	//Delete Seller By Id
	
	public Seller deleteById(int id) {
		
		Seller seller = fetchById(id);
		
		if(seller != null) {
			repo.delete(seller);
			return seller;
		}
		return null;
		
		}

	
}
