package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.service.SignUpServiceImpl;

@Controller
public class SignInController {

	@Autowired
	private SignUpServiceImpl signUpServiceImpl;
	
	@RequestMapping("/signlog")
	public String signinpage() {
		return "Signin";
	}
	
	@RequestMapping("/signin")
	public String signin(@ModelAttribute("signinall") SignUpDTO signUpDTO, Model model) {
	SignUpDTO	signindata=signUpServiceImpl.getFirstEmailPass(signUpDTO.getEmail(),signUpDTO.getPassword());
	if(signindata!=null) {
	return "Home";
	}
	else {
		model.addAttribute("errorsall","Email and Password Already exist");
		return "Signin";
	}
}
	@RequestMapping("/getpass")
	public String forgetpass() {
		return "ForgetPassword";
		
	}
}