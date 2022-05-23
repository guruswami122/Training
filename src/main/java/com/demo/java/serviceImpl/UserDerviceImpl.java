package com.demo.java.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.demo.java.dto.UserRequestDto;
import com.demo.java.dto.UserResponseDto;
import com.demo.java.entity.User;
import com.demo.java.repository.UserRepository;
import com.demo.java.service.UserService;
import java.util.Optional;

@Service
public class UserDerviceImpl implements UserService{
	
	@Autowired
	UserRepository userrepository;

	//Save the User Application Details
	@Override
	public UserResponseDto saveUser(UserRequestDto userRequestDto) {
		User user=new User();
		BeanUtils.copyProperties(userRequestDto, user);
		User dbuser=userrepository.save(user);
		UserResponseDto userResponseDto=new UserResponseDto();
		BeanUtils.copyProperties(dbuser, userResponseDto);
		return userResponseDto;
	}

	//Delete the User Application Details
	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userrepository.deleteById(id);
		System.out.println("user details deleted");
		
	}

	//Get the User Application Details
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	//Get the Single User Application Details
	  @Override 
	  public User getbyUser(Integer id) {
		  // TODO Auto-generated method
	   return userrepository.findUserById(id); 
	   }
	 

	//Update the User Application Details
	@Override
	public User updateUser(Integer id, User user) {
		// TODO Auto-generated method stub
		User user1=userrepository.findUserById(id);
		if(user.getFirstName()!=null) {
			user1.setFirstName(user.getFirstName());
		}
		//return saveUser(user1);
		return null;
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		// TODO Auto-generated method stub
		//List<User> user=userrepository.findByFirstName(firstName);
		List<User> user=userrepository.findByFirstNameContains(firstName);
		return user;
	}

	@Override
	public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return userrepository.findByFirstNameAndLastName(firstName, lastName);
		
	}


	@Override
	public List<User> getAllUsersPagination(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		//Pageable pageable=PageRequest.of(pageNumber, pageSize);
		Pageable pageable=PageRequest.of(pageNumber, pageSize,Sort.by(Direction.ASC, "firstName"));
		return userrepository.findAll(pageable).getContent();
	}
	
	


}
