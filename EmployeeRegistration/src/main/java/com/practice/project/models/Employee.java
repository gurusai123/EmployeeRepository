package com.practice.project.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	private String email;
//	@DBRef
	private Address address;
	@Indexed(unique = true)
	private final String userName;
	private String password;
	private String company;
	private String designation;
	private Date DOB;
//	@JsonProperty(required = false)
//    private Binary image; // file content

//	private boolean isAdmin;
}
