package com.practice.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.project.models.Employee;
import com.practice.project.repos.EmployeeRepo;
import com.practice.project.service.LoginCheck;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepo repo;
	@Autowired
	LoginCheck check;

	@PostMapping(value = "/employee")
	@Validated
	public Employee createProduct(@RequestBody Employee emp) {
		return (repo.save(emp));
	}

	@GetMapping(value = "/employee")
	public List<Employee> getAll() {
		return (List<Employee>) (repo.findAll());
	}

	private boolean employeeExists(String id) {
		return (repo.existsById(id));
	}

	@GetMapping(value = "/employee/byid/{id}")
	public ResponseEntity<Employee> getUserById(@PathVariable(name = "id") String id) {
		if (employeeExists(id)) {
			return (ResponseEntity.ok(repo.findById(id).get()));
		} else {
			return (ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
		}
	}

	@PatchMapping(value = "/employee/update")
	public void updateEmployee(@RequestBody Employee emp) {
//		emp.setAddress(emp.getAddress());
		// emp.setFirstName(emp.);
		repo.save(emp);
	}

	@DeleteMapping(value = "/employee/delete/{id}")
	public void deleteById(@PathVariable(name = "id") String id) {
		repo.deleteById(id);
	}

	@GetMapping(value = "/employee/{username}")
	public Employee getByUserName(@PathVariable(name = "username") String username) {
//		System.out.println(repo.findByUserName(username));
		return (repo.findByUserName(username));
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/employee/login")
	public ResponseEntity login(@RequestBody() Map<String, String> json) {

//		System.out.println(json.get("UserName") + " " + json.get("password"));

		if (check.login(json.get("UserName"), json.get("password"))) {
			return new ResponseEntity<>("login sucessfull", HttpStatus.OK);
		}

		return new ResponseEntity<>("login failed", HttpStatus.UNAUTHORIZED);
	}
}
