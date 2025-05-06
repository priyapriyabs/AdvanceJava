package com.priyanka.service;

import java.util.List;

import com.priyanka.dto.UserDTO;
import com.priyanka.entity.User;

public interface UserService {


	void accountCreate(User user);
	
	User getFirstEmail(String email);
	
//	public List<User> getAllUser();
	
	public List<UserDTO> getAllUser();
	
	void deleteUser(int id);
	
	User getUserById(int id);
	
 void	updateUser(User user);
 
	User getEmailPass(String email,String pass);
	
	
}
