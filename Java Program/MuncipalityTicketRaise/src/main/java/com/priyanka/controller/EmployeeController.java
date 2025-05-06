package com.priyanka.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.dto.EmployeeDTO;
import com.priyanka.service.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

//@PostMapping("employeeSave")
//public String empAcountCreate(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,Model model,HttpSession session) {
//EmployeeDTO empMail=employeeServiceImpl.findByEmployeeEmail(employeeDTO.getEmail());	
//if(empMail==null) {
//	if(employeeDTO.getName()!="" && employeeDTO.getEmail()!=""  && employeeDTO.getPassword()!="" && employeeDTO.getDesignation()!="") {
//
//		employeeServiceImpl.employeeAcountCreate(employeeDTO);
//		session.setAttribute("empDetails", empMail);
//		model.addAttribute("empDetails", empMail);	
//		return "EmployeeSignIn";
//}else {
//	model.addAttribute("emperror", "Please fill the form");
//}
//}else {
//	model.addAttribute("emperror", "This email already exist");
//}
//return "EmployeeSignUp";
//}

@PostMapping("getOtp")
public String getOtp(@RequestParam("email")String email, Model model) {
	EmployeeDTO empEmail=employeeServiceImpl.findByEmployeeEmail(email);
	if(empEmail!=null) {
	employeeServiceImpl.generateAndSendOTP(empEmail);
	model.addAttribute("empId", empEmail.getId());
		model.addAttribute("message", "OTP sent to your email.");
	}else {
		model.addAttribute("emailError", "Email not found.");
	}
return "EmployeeSignIn";
}

@PostMapping("loginWithOtp")
public String logInWithOtp(@RequestParam String email, @RequestParam String otp, HttpSession session, Model model) {
	EmployeeDTO empMail=employeeServiceImpl.findByEmployeeEmail(email);
	if(empMail!=null) {
		session.setAttribute("employee", empMail);
		
	if(empMail.getPassword().equals(otp.trim())) {
		model.addAttribute("message", "Login successful. Welcome back!");
		return "Employee";
	}else {
		 model.addAttribute("otpError", "Invalid OTP. Please try again.");	
	}
	}else {
		 model.addAttribute("otpError", "Employee not found.");
	}
	return "EmployeeSignIn";
}

@GetMapping("employeeLogout")
public String employeeLogOut(HttpServletRequest req) {
	HttpSession session=req.getSession();
session.invalidate();
return "EmployeeSignIn";
}



}
