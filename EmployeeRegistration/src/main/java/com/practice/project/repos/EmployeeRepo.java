package com.practice.project.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.practice.project.models.Employee;


public interface EmployeeRepo  extends MongoRepository<Employee, String>{
	@Query("{userName:?0}")
	public Employee findByUserName(String username);

	public List<Employee> findByUserNameAndPassword(String userName, String password);

}
