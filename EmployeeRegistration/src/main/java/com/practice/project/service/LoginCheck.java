package com.practice.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.project.models.Employee;
import com.practice.project.repos.EmployeeRepo;

@Service
public class LoginCheck {
	@Autowired
	EmployeeRepo repo;

	public boolean login(String userName,String password) {
		
		List<Employee> nameAndPassword = repo.findByUserNameAndPassword(userName,password);
//		nameAndPassword.forEach((i)->{
//			System.out.println(i);
//		});
		if(nameAndPassword.isEmpty()) {
			return(false);
		}
		return(true);
	}

}

