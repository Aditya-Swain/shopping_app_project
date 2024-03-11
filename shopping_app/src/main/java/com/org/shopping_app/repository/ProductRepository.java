package com.org.shopping_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.shopping_app.dto.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{
	
}
