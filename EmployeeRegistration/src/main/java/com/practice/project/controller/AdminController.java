package com.practice.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.project.models.Employee;
import com.practice.project.repos.EmployeeRepo;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	EmployeeRepo repo;
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@DeleteMapping(value = "/admin/delete/{id}")
	public void deleteById(@PathVariable(name = "id") String id) {
		repo.deleteById(id);
	}

	@PutMapping(value = "/admin/update")
	public Employee update(@RequestBody Employee emp) {
		try {
			Employee employee = repo.save(emp);
			return employee;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return (null);
		}
	}

}
