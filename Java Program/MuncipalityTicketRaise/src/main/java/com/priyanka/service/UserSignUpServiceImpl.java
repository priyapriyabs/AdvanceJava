package com.priyanka.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.priyanka.dto.PasswordResetDTO;
import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.UserSignUpDTORepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserSignUpServiceImpl implements UserSignUpService{

	@Autowired
	private UserSignUpDTORepo userSignUpDTORepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void userAcountCreated(SignUpDTO signUpDTO) {
log.info("running userAcountCreated():"+signUpDTO);
String generatedPassword =generateRandomPassword();
String encryptedpassword=passwordEncoder.encode(generatedPassword);
		signUpDTO.setPassword(encryptedpassword);
		
		String fullName=signUpDTO.getFirstName()+" "+signUpDTO.getLastName();
		signUpDTO.setCreatedBy(fullName);
		signUpDTO.setCreatedAt(LocalDateTime.now());
		signUpDTO.setCount(0);
	SignUpDTO	userData=userSignUpDTORepo.save(signUpDTO);
	sendPasswordToUserEmail(signUpDTO, generatedPassword);
		if(userData!=null) {
			log.info("user Data Saved sucessfully");
		}else {
			log.info("User data not saved");
		}
	}

	 public String generateRandomPassword() {
	        int length = 16; // desired password length
	        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
	        SecureRandom random = new SecureRandom();
	        StringBuilder password = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characterSet.length());
	            password.append(characterSet.charAt(index));
	        }

	        return password.toString();
	    }

	@Override
	public void sendPasswordToUserEmail(SignUpDTO signUpDTO, String decryptPassword) {
		 SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(signUpDTO.getEmail());
	        message.setSubject("One Time Password");
	        message.setText("Dear " + signUpDTO.getFirstName() + " " + signUpDTO.getLastName() + ", You have been successfully Signed Up,\n\n" +
	                "Please Sign in through this password: " +decryptPassword + "\n\n" +
	                "Thanks and Regards,\n" + " " +
	                "Muncipality Team");
	        javaMailSender.send(message);
	    }

	@Override
	public SignUpDTO validateEmail(String email) {
		log.info("running validate email in service"+email);
	long	emailCount=userSignUpDTORepo.countOfEmail(email);
	if(emailCount>=1) {
		return new SignUpDTO();
	}
	
	return null;
	}

	@Override
	public SignUpDTO validatePhone(Long phone) {
		log.info("running validate phone in service"+phone);
	long	phoneCount=userSignUpDTORepo.countOfPhone(phone);
	if(phoneCount>=1) {
		return new SignUpDTO();
	}
	
	return null;
	}

	@Override
	public SignUpDTO findByUserEmail(String email) {
		
		return userSignUpDTORepo.findByUserEmail(email);
	}

	@Override
	public SignUpDTO findByUserPhone(Long phone) {
		
		return userSignUpDTORepo.findByUserPhone(phone);
	}

	@Override
	public void updateLogInCount(int userId) {
	SignUpDTO	userID=userSignUpDTORepo.findById(userId).get();
		if(userID!=null) {
			userID.setCount(userID.getCount()+1);
			userSignUpDTORepo.save(userID);
		}
	}

	@Override
	public void incrementFailedAttempts(int userId) {
	SignUpDTO	userID=userSignUpDTORepo.findById(userId).get();
		if(userID!=null) {
			userID.setFailedAttempts(userID.getFailedAttempts()+1);
			userSignUpDTORepo.save(userID);
		}
	}

	@Override
	public void resetFailedAttempts(int userId) {
		SignUpDTO	userID=userSignUpDTORepo.findById(userId).get();
		if(userID!=null) {
			userID.setFailedAttempts(0);
			userSignUpDTORepo.save(userID);
		}
	}

	@Override
	public void lockAccount(int userId) {
	SignUpDTO	userID=userSignUpDTORepo.findById(userId).get();
		if(userID!=null) {
			userID.setAccountLocked(true);
			userSignUpDTORepo.save(userID);
		}
	}

	@Override
	public PasswordResetDTO savePasswordRestDto(PasswordResetDTO passwordResetDTO) {
		SignUpDTO usermail=userSignUpDTORepo.findByUserEmail(passwordResetDTO.getEmail()+passwordResetDTO.getPassword());
		if(usermail==null) {
			PasswordResetDTO pass=new PasswordResetDTO();
			BeanUtils.copyProperties(pass, usermail);
			return pass;
		}
		
		return null;
	}

	@Override
	public SignUpDTO findById(int id) {
		
		return userSignUpDTORepo.findById(id).get();
	}
		











}
