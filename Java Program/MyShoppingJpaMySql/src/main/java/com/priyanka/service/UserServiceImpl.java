package com.priyanka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.dto.UserDTO;
import com.priyanka.entity.User;
import com.priyanka.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
private UserRepository userRepository;
	
	
	@Override
	public void accountCreate(User user) {
		// TODO Auto-generated method stub
		System.out.println(user);
		userRepository.save(user);
		
	}


//	@Override
//	public List<User> getAllUser() {
//		// TODO Auto-generated method stub
//	
//		return userRepository.findAll();
//	}
	
	@Override
	  public List<UserDTO> getAllUser() { 
	List<User> userobj =userRepository.findAll();
	System.out.println("userobj");
	List<UserDTO> userdtos = new ArrayList<>();
	  
	  for(User dto: userobj) {
		  UserDTO userdto= new UserDTO(
				  dto.getId(),
				  dto.getName(),
				  dto.getEmail(),
		  dto.getPhoneno());
		 userdtos.add(userdto);
	  }
	  
		  return userdtos;
	  }

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}


	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}


	@Override
	public void updateUser(User user) {
	 userRepository.save(user);
	}


	@Override
	public User getFirstEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}


	@Override
	public User getEmailPass(String email, String pass) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPass(email, pass);
	}


}
