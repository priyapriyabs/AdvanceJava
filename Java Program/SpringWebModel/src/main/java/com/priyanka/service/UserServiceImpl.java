package com.priyanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.priyanka.dto.UserDTO;
import com.priyanka.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void userAccountCreate(UserDTO userDTO) {
	UserDTO	userEmail=userRepo.findByEmail(userDTO.getEmail());
		if(userEmail==null) {
			String encryptedpassword=passwordEncoder.encode(userDTO.getPassword());
					userDTO.setPassword(encryptedpassword);
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

	@Override
	public List<UserDTO> getAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public UserDTO findByEmail(String email) {
	UserDTO	userEmail=userRepo.findByEmail(email);
		return userEmail;
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepo.deleteById(id);
		
	}

	@Override
	public UserDTO editUserById(Integer id) {
		
		return userRepo.findById(id).get();
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		userRepo.save(userDTO);
		
	}

	@Override
	public UserDTO validatePhone(Long contact_number) {
		return userRepo.validatePhone(contact_number);
	}



}
