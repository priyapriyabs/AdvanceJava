package com.priyanka.service;

import com.priyanka.dto.PasswordResetDTO;
import com.priyanka.dto.SignUpDTO;

public interface UserSignUpService {

	void userAcountCreated(SignUpDTO signUpDTO);
	
	void sendPasswordToUserEmail(SignUpDTO signUpDTO,String decryptPassword);
	
	SignUpDTO validateEmail(String email);
	
	SignUpDTO validatePhone(Long phone);
	
	SignUpDTO findByUserEmail(String email);
	
	SignUpDTO findByUserPhone(Long phone);
	
	void updateLogInCount(int userId);
	
	 void incrementFailedAttempts(int userId);

	    void resetFailedAttempts(int userId);

	    void lockAccount(int userId);
	    
	    PasswordResetDTO savePasswordRestDto(PasswordResetDTO passwordResetDTO);
	    
	   SignUpDTO findById(int id);
}
