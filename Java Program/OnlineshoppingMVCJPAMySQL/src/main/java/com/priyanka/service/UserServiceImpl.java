package com.priyanka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.entity.User;
import com.priyanka.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
private UserRepository userRepository;
	
	
	@Override
	public void accountCreate(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

}
