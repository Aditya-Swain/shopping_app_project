package com.org.shopping_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.shopping_app.dao.ProductDao;
import com.org.shopping_app.dao.SellerDao;
import com.org.shopping_app.dto.Product;
import com.org.shopping_app.dto.Seller;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	SellerDao sellerDao;
	
	@Autowired
	ProductDao productDao;
	
	
	
//___________________SELLER__________________
	
	
	//-------Registration Of  New Seller----------
	
	@PostMapping
	public Seller registerNewSeller(@RequestBody Seller seller) {
		
		return sellerDao.saveAndUpdate(seller);
	}
	
	//--------Login Seller-------------
	
	@PostMapping("/{email}/{password}")
	public List<Seller> loginSeller(@PathVariable String email, @PathVariable String password){
		return sellerDao.fetchByEmailAndPassword(email, password);
	}
	
	
	//-----------Update Existing Seller-----------
	
	@PutMapping("/{id}")
	public Seller updateSeller(@PathVariable int id, @RequestBody Seller seller) {
		
		Seller seller2 = sellerDao.fetchById(id);
		
		if(seller2 != null) {
			seller.setSellerId(seller2.getSellerId());
			sellerDao.saveAndUpdate(seller);
			return seller;
		}
		return null;
	}
	
	//-----------Fetch All Sellers------------
	
	@GetMapping
	public List<Seller> fetchAllSellers(){
	
		return sellerDao.fetchAllSeller();
		
	}
	
	//----------Fetch Seller By Id-------------
	
	@GetMapping("/{id}")
	public Seller fetchById(@PathVariable int id) {
		return sellerDao.fetchById(id);
	}
	
	
	
//____________________PRODUCT_______________
	
	
	
	
	
	
	
	//---------fetch all product----------
	
	
	@GetMapping("/product")
	public List<Product> fetchAllProduct(){
		return productDao.fetchAllProduct();
	}
	
	
	
	
	//---------Add Product----------
	
	@PostMapping("/add/product/{sellerId}")
	public Product addProduct(@PathVariable int sellerId ,@RequestBody Product product) {
			
		product.setSeller(sellerDao.fetchById(sellerId));
		return productDao.saveAndUpdate(product);
		
	}
	
	//-----------Update Product---------
	
	@PutMapping("/update/product/{productId}")
	public Product updateProduct(@PathVariable int productId , @RequestBody Product product) {
		
		Product product2 = productDao.fetchById(productId);
		
		if(product2 != null) {
			product.setProductId(product2.getProductId());
			product.setSeller(product2.getSeller());
			productDao.saveAndUpdate(product);
			return product;
		}
		return null;
	}
	
	
	//-----------Delete Product By Id------------
	
	@DeleteMapping("/delete/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		
		
		if(productDao.deleteById(id) != null) 
			return "Product Removed";
		
		return "Product Doesn't Exist !";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
