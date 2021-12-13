package com.practice.project.models;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

//import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Employee {
//	@Id
//	@NotNull(message = "")
//	@Pattern(regexp = "[0-9]{3,5}")
	private String id;
//	@NotNull(message = "")
//	@Pattern(regexp = "[A-Za-z]")
//	@Size(min = 3, max = 20)
	private String firstName;
//	@NotNull(message = "")
//	@Pattern(regexp = "[A-Za-z]")
//	@Size(min = 3, max = 20)
	private String lastName;
	@DBRef
	@Autowired
	private Address address;
//	@NotNull(message = "")
//	@Pattern(regexp = "[A-Za-z0-9@_]")
	@UniqueElements
	private String userName;
//	@NotNull(message = "")
//	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String company;
	private String designation;
	private Date DOB; 
}
