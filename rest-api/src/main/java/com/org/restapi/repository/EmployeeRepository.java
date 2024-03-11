package com.org.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.restapi.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
		
	List<Employee> findByEmailAndPassword(String email, String password);
	
	@Query("SELECT e FROM Employee e WHERE e.salary>=?1")
	List<Employee> findByGreaterSalary(double salary);
}
