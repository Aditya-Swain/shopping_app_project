package com.org.shopping_app.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false , unique=true)
	private long mobile;
	
	@Column(nullable = false , unique = true)
	private String email;
	
	private String password;
	
	
	
}
