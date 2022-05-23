package com.demo.java.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.demo.java.dto.UserRequestDto;
import com.demo.java.dto.UserResponseDto;
import com.demo.java.entity.User;

public interface UserService {
	
	public UserResponseDto saveUser(UserRequestDto userRequestDto);
    public void deleteUser(Integer id);
    public List<User> getAllUsers();
    public User getbyUser(Integer id) ;
    public User updateUser(Integer id,User user);
    public List<User> getUsersByFirstName(String firstName);
	public List<User> findByFirstNameAndLastName(String firstName, String lastName);
	public List<User> getAllUsersPagination(int pageNumber, int pageSize);
}
