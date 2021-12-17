package com.practice.project;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.project.models.Address;
import com.practice.project.models.Employee;
import com.practice.project.repos.EmployeeRepo;

@SpringBootApplication
//@EnableWebMvc
public class EmployeeRegistrationApplication {
	@Autowired
	EmployeeRepo repo;


	@PostConstruct
	public void preLoadMongo() throws Exception {
		Address address = new Address("1", "aa", "bb", "cc", "ee", "ff");
		Employee emp = new Employee("1", "admin", "admin", "admin@cts.com", address, "admin", "abcd", "CTS", "admin", new Date());
		repo.save(emp);
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationApplication.class, args);
	}

	@PreDestroy
	public void deleteDoc() {
		repo.deleteById("1");
	}
}
