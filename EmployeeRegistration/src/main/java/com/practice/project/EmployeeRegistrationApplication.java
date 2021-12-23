package com.practice.project;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.practice.project.models.Address;
import com.practice.project.models.Employee;
import com.practice.project.repos.EmployeeRepo;
//@ComponentScan(basePackages = {"com.practice.project.models.Employee"})
//@EntityScan(basePackages = "com.practice.project.models")
//@EnableMongoRepositories ("com.practice.project.repos")
@SpringBootApplication(scanBasePackages= "com.practice.project") 
//@SpringBootApplication
public class EmployeeRegistrationApplication {
	@Autowired
	EmployeeRepo repo;


	@PostConstruct
	public void preLoadMongo() throws Exception {
		Address address = new Address("aa", "bb", "cc", "ee", "ff"); 
		Employee emp = new Employee("1", "admin", "admin", "admin@cts.com","1234567890", address, "admin", "abcd", "CTS", "admin", new Date(), "abcd",null);
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
