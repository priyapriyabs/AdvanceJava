package com.priyanka.service;

import com.priyanka.dto.SignUpDTO;

public interface EditUserIngoService {

	SignUpDTO updateUserProfile(String email, SignUpDTO signUpDTO);
}
