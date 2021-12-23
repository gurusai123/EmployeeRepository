package com.practice.project.models;

import java.util.Date;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.With;
@Repository
@Data
@Document(collection = "employee")
@AllArgsConstructor
public class Employee {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
//	@DBRef
	private Address address;
	@Indexed(unique = true)
	private String  userName;
	private String password;
	private String company;
	private String designation;
	private Date DOB;
//	@JsonProperty(required = false)

	private String title;
	private Binary image;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

//	private boolean isAdmin;
}
