package com.priyanka.service;

import java.util.List;

import com.priyanka.dto.UserDTO;

public interface UserService {

	public void userAccountCreate(UserDTO userDTO);
	
	public UserDTO findByEmail(String email);
	
	public UserDTO loginByEmailAndPass(String email, String password);
	
	public List<UserDTO> getAllUsers();
	
	public void deleteUserById(Integer id);
	
	public UserDTO editUserById(Integer id);
	
	public void updateUser(UserDTO userDTO);
	
	public UserDTO validatePhone(Long contact_number);
}
