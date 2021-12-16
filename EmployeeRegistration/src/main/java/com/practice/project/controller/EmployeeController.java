package com.practice.project.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
//@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeRepo repo;
	@Autowired
	LoginCheck check;
    Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
	@PostMapping(value = "/employee")
	public Employee createProduct(@RequestBody Employee emp) {
		try {
		return (repo.save(emp));
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return(null);
		}
		
	}

	@GetMapping(value = "/employee")
	public List<Employee> getAll() {
		List<Employee> emp	= (List<Employee>) repo.findAll();
		for(Iterator<Employee> iterator = emp.iterator(); iterator.hasNext();) {
			Employee e = iterator.next();
			if(e.getUserName().equals("admin")) {
				iterator.remove();
			}
		}
				return(emp);
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

	@PatchMapping(value = "/update")
	public void updateEmployee(@RequestBody Employee emp) {
//		emp.setAddress(emp.getAddress());
		// emp.setFirstName(emp.);
		repo.save(emp);
	}

	@DeleteMapping(value = "/employee/delete")
	public void deleteById(@RequestBody Employee emp) {
		repo.delete(emp);
	}

	@GetMapping(value = "/employee/{username}")
	public Employee getByUserName(@PathVariable(name = "username") String username) {
//		System.out.println(repo.findByUserName(username));
		return (repo.findByUserName(username));
	}

	

	@PostMapping(value = "/login")
	public Employee login(@RequestBody() Map<String, String> json) {
		if (check.login(json.get("UserName"), json.get("password"))) {
			// System.out.println(json.get("UserName"));
			String userName = json.get("UserName");
			Employee emp = repo.findByUserName(userName);
			// System.out.println(emp);
			return emp;

		} else {
			return null;
		}
	}
}
