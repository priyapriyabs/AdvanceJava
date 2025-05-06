package com.priyanka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.UserSignUpDTORepo;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EditUserInfoServiceImpl implements EditUserIngoService {

	@Autowired
	private UserSignUpDTORepo upDTORepo;

	@Override
	public SignUpDTO updateUserProfile(String email, SignUpDTO signUpDTO) {
		SignUpDTO existingUser=upDTORepo.findByUserEmail(email);
		if(existingUser!=null) {
		existingUser.setFirstName(signUpDTO.getFirstName());	
			existingUser.setLastName(signUpDTO.getLastName());
			existingUser.setPhone(signUpDTO.getPhone());
			existingUser.setProfileImage(signUpDTO.getProfileImage());
			upDTORepo.save(existingUser);
			log.info("saved upated user data");
		}
		log.info("not saved updated data");
		return existingUser;
	}





}
