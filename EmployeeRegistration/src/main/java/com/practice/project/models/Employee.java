package com.practice.project.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document(collection = "employee")
@AllArgsConstructor
public class Employee {
	@Id
	private final String id;
	private String firstName;
	private String lastName;
//	@DBRef
	private Address address;
	private final String userName;
	private final String password;
	private String company;
	private String designation;
	private Date DOB;
//	private boolean isAdmin;
}
