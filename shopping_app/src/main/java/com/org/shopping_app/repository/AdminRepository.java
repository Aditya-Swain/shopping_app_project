package com.org.shopping_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.shopping_app.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

		List<Admin> findByEmailAndPassword(String email, String password);
}
