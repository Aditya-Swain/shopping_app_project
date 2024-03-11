package com.org.shopping_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.org.shopping_app.dto.Product;
import com.org.shopping_app.repository.ProductRepository;

@Component
public class ProductDao {
		
	@Autowired
	ProductRepository repo;
		
	//------save and update product--------
	
	public Product saveAndUpdate(Product product) {
		return repo.save(product);
	}
	
	
	//-----------fetch all product----------
	
	public List<Product> fetchAllProduct(){
		return repo.findAll();
	}
	//---------fetch product by id------------
	
	public Product fetchById(int id) {
		Optional<Product> optional = repo.findById(id);
		
		if(optional != null)
			return optional.get();
		
		return null;
	}
	
	//--------delete product by id------------
	
	public Product deleteById(int id) { 
		Product product = fetchById(id);
		
		if(product != null)
		{
			repo.delete(product);
			return product;
		}
		
		return null;
	}
	
	
	
}
