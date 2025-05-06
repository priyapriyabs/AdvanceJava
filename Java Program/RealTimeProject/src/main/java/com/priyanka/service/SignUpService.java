package com.priyanka.service;

import com.priyanka.dto.SignUpDTO;


public interface SignUpService {
	
	public void accountCreate(SignUpDTO signUpDTO);

 SignUpDTO	getFirstEmail(String email);
 
 SignUpDTO getFirstEmailPass(String email, String pass);

SignUpDTO updateByOTP(String otp);

void sendOTP(SignUpDTO signUpDTO);


}
