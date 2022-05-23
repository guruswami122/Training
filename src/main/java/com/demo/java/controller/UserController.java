package com.demo.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.java.dto.UserRequestDto;
import com.demo.java.dto.UserResponseDto;
import com.demo.java.entity.User;
import com.demo.java.repository.UserRepository;
import com.demo.java.service.UserService;


@RestController
@Validated
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/saveuser")
	public UserResponseDto saveUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		return userservice.saveUser(userRequestDto);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userservice.deleteUser(id);
	}
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
	  return userservice.getAllUsers();
	}

	
	  @GetMapping("/getbyUser/{id}") 
	  public User getbyUser(@PathVariable Integer id) { 
		return userservice.getbyUser(id); 
	}
	 
	@PatchMapping("/updateUser/{id}")
	public User updateUser(@PathVariable Integer id,@RequestBody User user) {
		return userservice.updateUser(id,user);
	}
	@GetMapping("/namesearch")
	public List<User> getUsersByFirstName(@RequestParam String firstName){
		return userservice.getUsersByFirstName(firstName);
	}
	@GetMapping("/fnameAndlnamesearch")
	public List<User> findByFirstNameAndLastName(@RequestParam String firstName, String lastName) {
		// TODO Auto-generated method stub
		return userservice.findByFirstNameAndLastName(firstName, lastName);
	}
	@GetMapping("/pagination")
	public List<User> getAllUsersPagination(@RequestParam int pageNumber, int pageSize) {
		return userservice.getAllUsersPagination(pageNumber, pageSize);
	}
}
