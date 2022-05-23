package com.demo.java.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestDto {
	
	@NotNull(message = "First name is mandatory")
	@Size( min=4,max=6)
	private String firstName;
	@NotNull(message = "Last name is mandatory")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
