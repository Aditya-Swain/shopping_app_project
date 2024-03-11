package com.org.shopping_app.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Seller {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int sellerId;
		
		private String name;
		
		@Column(nullable = false , unique=true)
		private long mobile;
		
		@Column(nullable = false , unique=true)
		private String email;
		
		private String password;
		
		private String status = "active";
		
		private String address;
		
		
		@OneToMany(mappedBy = "seller" , cascade = CascadeType.ALL)
		private List<Product> product;
		
		
}
