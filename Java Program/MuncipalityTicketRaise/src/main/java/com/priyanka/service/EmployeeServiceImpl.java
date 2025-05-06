package com.priyanka.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.priyanka.dto.EmployeeDTO;
import com.priyanka.repository.EmployeeDTORepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDTORepo employeeDTORepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public EmployeeDTO employeeAcountCreate(EmployeeDTO employeeDTO) {
		 String genaratePassword=generateRandomPassword();
	        String encryptedPassword = passwordEncoder.encode(genaratePassword);
	       
	        employeeDTO.setPassword(encryptedPassword);
	        sendEmailToEmployee(employeeDTO, genaratePassword);
		employeeDTORepo.save(employeeDTO);
		return employeeDTO;
	}

	
	@Override
	public void sendEmailToEmployee(EmployeeDTO employeeDTO, String plainPassword) {
		 SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(employeeDTO.getEmail());
	        message.setSubject("Complaint Received");
	        message.setText("Dear " + employeeDTO.getName() + ",\n\n" +
	                "You have been successfully registered.\n\n" +
	                "Please sign in using this password: " + plainPassword + "\n\n" +
	                "Thanks and Regards,\n" +
	                "Muncipality Team");
	        javaMailSender.send(message);
		
	}


	 public String generateRandomPassword() {
	        int length = 6; // desired password length
	        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        SecureRandom random = new SecureRandom();
	        StringBuilder password = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characterSet.length());
	            password.append(characterSet.charAt(index));
	        }

	        return password.toString();
	    }


	@Override
	public EmployeeDTO findByEmployeeEmail(String email) {
		
		return employeeDTORepo.findByEmployeeEmail(email);
	}


	@Override
	public String generateAndSendOTP(EmployeeDTO employeeDTO) {
		String otp=generateRandomOtp();
		employeeDTO.setPassword(otp);
		employeeDTORepo.save(employeeDTO);
		sendOtpEmail(employeeDTO, otp);
		return null;
	}
	
	 private String generateRandomOtp() {
	        int length = 6; // desired OTP length
	        String characterSet = "0123456789";
	        SecureRandom random = new SecureRandom();
	        StringBuilder otp = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characterSet.length());
	            otp.append(characterSet.charAt(index));
	        }

	        return otp.toString();
	    }

	 public void sendOtpEmail(EmployeeDTO employee, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(employee.getEmail());
	        message.setSubject("Your OTP for Login");
	        message.setText("Dear " + employee.getName() + ",\n\n" +
	                "Your OTP for login is: " + otp + "\n\n" +
	                "Thanks and Regards,\n" +
	                "XworkzProject Team");
	        javaMailSender.send(message);
	    }


	@Override
	public EmployeeDTO validateEmail(String email) {
	long	count=employeeDTORepo.countByEmail(email);
	if(count>=1) {
		return new EmployeeDTO();
	}
	return null;
	}


	@Override
	public EmployeeDTO validatePhone(Long phone) {
	long	count=employeeDTORepo.countByPhone(phone);
	if(count>=1) {
		return new EmployeeDTO();
	}
	return null;
	}


	@Override
	public List<EmployeeDTO> getEmployeeByDepartmentId(Integer departmentId) {
		if(departmentId==null) {
			return new ArrayList<>();
		}
	List<EmployeeDTO> employees=employeeDTORepo.findByDepartmentId(departmentId);
		return employees!=null ?employees:new ArrayList<>();
	}
	
	
	
	
	
}
