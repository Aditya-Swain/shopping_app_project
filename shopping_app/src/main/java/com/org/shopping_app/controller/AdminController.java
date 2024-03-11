package com.org.shopping_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.shopping_app.dao.AdminDao;
import com.org.shopping_app.dao.SellerDao;
import com.org.shopping_app.dto.Admin;
import com.org.shopping_app.dto.Seller;

@RestController
@RequestMapping("/admin")
public class AdminController {
		
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	SellerDao sellerDao;
	
	
	//------Register Admin------
	
	@PostMapping
	public Admin registerAdmin(@RequestBody Admin admin) {
		return adminDao.saveAndUpdateAdmin(admin);
	}
	
	
	//------Login Admin----------
	
	@PostMapping("/{email}/{password}")
	public List<Admin> loginAdmin(@PathVariable String email,@PathVariable String password){
		return adminDao.verifyAdmin(email, password);
	}
	
	
	//--------View Seller accounts--------
	
	
	@GetMapping("/seller")
	public List<Seller> viewAllSeller(){
			
		return sellerDao.fetchAllSeller();
	}
	
	
	//----------View Seller By Id---------
	
	@GetMapping("/seller/{id}")
	public Seller viewSellerById(@PathVariable int id) {
		return sellerDao.fetchById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
