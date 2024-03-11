package com.org.restapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.restapi.dto.Employee;
import com.org.restapi.repository.EmployeeRepository;

@Component
public class EmployeeDao {
		
	@Autowired
	EmployeeRepository repo;
	
	
	public Employee saveAndUpdate(Employee employee) {
			return repo.save(employee);
	}
	
	
	public List<Employee> fetchAllEmployee(){
		return repo.findAll();
	}
	
	
	public Employee fetchById(int id) {
		 Optional<Employee> optional = repo.findById(id);
		 
		 if(optional != null) {
			 return optional.get();
		 }
		 return null;
	}
	
	
	public Employee deleteById(int id) {
		Employee employee = fetchById(id);
		
		if(employee != null) {
			repo.delete(employee);
			return employee;
		}
		return null;
	}
	
	
	
	public List<Employee> verifyEmployee(String email, String password){
		return repo.findByEmailAndPassword(email, password);
	}
	
	
	public List<Employee> fetchBySalary(double salary){
		return repo.findByGreaterSalary(salary);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
