package com.org.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.restapi.dao.EmployeeDao;
import com.org.restapi.dto.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
		@Autowired
		EmployeeDao dao;
		
		@PostMapping
		public Employee saveEmployee(@RequestBody Employee employee) {
			return dao.saveAndUpdate(employee);
		}
		
		@PutMapping("/{id}")
		public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
			Employee employee2 = dao.fetchById(id);
			
			if(employee2 != null) {
				employee.setId(employee2.getId());
				dao.saveAndUpdate(employee);
				return employee;
			}
			return null;
				
		}
		
		@GetMapping
		public List<Employee> fetchAllEmp(){
			return dao.fetchAllEmployee();
		}
		
		
		@GetMapping("/{id}")
		public Employee fetchById(@PathVariable int id) {
			return dao.fetchById(id);
		}
		
		@DeleteMapping("/{id}")
		public String deleteEmp(@PathVariable int id) {
			dao.deleteById(id);
			return "employee data deleted";
		}
		
		
		@PostMapping("/{email}/{password}")
		public List<Employee> verifyEmployee(@PathVariable String email, @PathVariable String password){
			return dao.verifyEmployee(email, password);
		}
		
			@GetMapping("/sal/{salary}")
		public List<Employee> fetchByGreaterSalary(@PathVariable double salary){
			return dao.fetchBySalary(salary);
		}
		
		
}
