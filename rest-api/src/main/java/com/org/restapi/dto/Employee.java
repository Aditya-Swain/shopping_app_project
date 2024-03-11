package com.org.restapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	private int age;
	
	private String designation;
	
	private double salary;
	
	@Column(nullable = false,unique = true)
	private long mobile;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	private String password;
}
