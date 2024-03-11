package com.org.shopping_app.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Item {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn
	private Product product;
	
	@ManyToOne
	@JoinColumn
	private Cart cart;
}
