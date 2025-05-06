package com.priyanka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.dto.UserDTO;
import com.priyanka.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public void userAccountCreate(UserDTO userDTO) {
	UserDTO	userEmail=userRepo.findByEmail(userDTO.getEmail());
		if(userEmail==null) {
		userRepo.save(userDTO);
		System.out.println("User Acount created");
		}
		else {
			System.out.println("User Acount not Created");
		}
	}

	@Override
	public UserDTO loginByEmailAndPass(String email, String password) {
	UserDTO	usermail=userRepo.findByEmail(email);
	if(usermail!=null) {
		System.out.println("User login sucessfully");
		return userRepo.findByEmailAndPass(email, password);
	}
	else {
		System.out.println("User Login fail");
		return null;
	}
		
	}



}
