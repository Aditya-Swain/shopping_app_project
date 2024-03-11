package com.org.shopping_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.shopping_app.dto.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{
	
	List<Seller> findByEmailAndPassword(String email, String password);

}
