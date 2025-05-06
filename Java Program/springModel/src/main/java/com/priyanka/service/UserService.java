package com.priyanka.service;

import com.priyanka.dto.UserDTO;

public interface UserService {

	public void userAccountCreate(UserDTO userDTO);
	
	public UserDTO loginByEmailAndPass(String email, String password);
}
