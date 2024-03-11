package com.org.shopping_app.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false , unique=true)
	private long mobile;
	
	@Column(nullable = false , unique=true)
	private String email;
	
	private String password;
	
	private String status = "active" ;
	
	@OneToOne
	private Cart cart;
	
	
	
	
	
}
