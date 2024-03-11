package com.org.shopping_app.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Cart {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@OneToMany(mappedBy = "cart" , cascade = CascadeType.ALL) 
	private List<Item> items;
	
	private long totalAmount;
	
	@OneToOne
	private Customer customer;
}
