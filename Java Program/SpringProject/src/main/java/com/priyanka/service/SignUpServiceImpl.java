package com.priyanka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.SignUpRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpRepository signUpRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void accountCreate(SignUpDTO signUpDTO) {
		signUpDTO.setOtp("0");
		signUpDTO.setFailedAttempts(0);
		signUpDTO.setAccountLocked(false);
		signUpRepository.save(signUpDTO);

	}

	@Override
	public SignUpDTO getFirstEmail(String email) {
		// TODO Auto-generated method stub
		return signUpRepository.findByEmail(email);
	}

	@Override
	public SignUpDTO getFirstEmailPass(String email, String pass) {
		// TODO Auto-generated method stub
		return signUpRepository.findByEmailPass(email, pass);
	}

	@Override
	public SignUpDTO updateByOTP(String otp) {

		return signUpRepository.updateOTP(otp);

	}

	@Override
	public void sendOTP(SignUpDTO signUpDTO) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(signUpDTO.getEmail());
		message.setSubject("One Time Password");
		message.setText("Dear " + signUpDTO.getUsername() + " " + ", You have been successfully Signed Up,\n\n"
				+ "Please Sign in through this OTP: " + signUpDTO.getOtp() + "\n\n" + "Thanks and Regards,\n" + " "
				+ "XworkzProject Team");
		javaMailSender.send(message);

	}

	

	@Override
	public void lockAccount(SignUpDTO signUpDTO) {
	signUpDTO.setAccountLocked(true);
	signUpDTO.setPassword("00");
	signUpRepository.save(signUpDTO);
	
		
	}

}
