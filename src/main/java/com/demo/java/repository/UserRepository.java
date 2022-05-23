package com.demo.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.java.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findUserById(Integer id);
	List<User> findByFirstName(String firstName);
	List<User> findByFirstNameAndLastName(String firstName, String lastName);
	List<User> findByFirstNameContains(String firstName);
	List<User> findByFirstNameAndLastNameContains(String firstName, String lastName);
}
