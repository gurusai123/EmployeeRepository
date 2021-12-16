package com.practice.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Address {
//	@Id
//	@NotNull(message = "")
//	@Pattern(regexp = "[0-9]{3,5}")
	private String id;
//	@NotNull(message = "")
	private String streetName;
//	@NotNull(message = "")
	private String city;
//	@NotNull(message = "")
	private String state;
//	@NotNull(message = "")
//	@Pattern(regexp = "^[1-9]{6}")
	private String zipcode;
//	@NotNull(message = "")
	private String country;
}
