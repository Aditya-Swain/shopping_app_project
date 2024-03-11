package com.org.shopping_app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String name;
	
	@Column(length = 150)
	private String description;
	
	private int price;
	
	private int quantityAvailable;
		
	
	@ManyToOne
	@JoinColumn
	private Seller seller;
	
	
}
