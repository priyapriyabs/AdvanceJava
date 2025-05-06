package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.SignUpRepository;
import com.priyanka.service.SignUpServiceImpl;

@Controller
public class SignInController {

	@Autowired
	private SignUpRepository signUpRepository;

	@Autowired
	private SignUpServiceImpl signUpServiceImpl;

	@RequestMapping("/signlog")
	public String signinpage() {
		return "Signin";
	}

	
	@RequestMapping("/signin")
	public String signin(@ModelAttribute("signinall") SignUpDTO signUpDTO, Model model) {
		SignUpDTO signindata = signUpServiceImpl.getFirstEmailPass(signUpDTO.getEmail(), signUpDTO.getPassword());
		System.out.println(signindata+"*************");
		if (signindata != null) {
			signindata.setFailedAttempts(0);
			signindata.setAccountLocked(false);
			signUpRepository.save(signindata);
			return "Home";
		}
		else {
			SignUpDTO getdetails = signUpServiceImpl.getFirstEmail(signUpDTO.getEmail());
			System.out.println(getdetails);
			int attemptsLeft =getdetails.getFailedAttempts();
			
			if (attemptsLeft<3) {
				
				getdetails.setFailedAttempts(attemptsLeft+1);
				
				signUpRepository.save(getdetails);
				model.addAttribute("errorsMsg",
						"Incorrect Password or Email. You have 3 attemts " +(attemptsLeft+1) + " attempts used.");
				
			} else {
				signUpServiceImpl.lockAccount(getdetails);
				model.addAttribute("errorsMsglock",
						"Account locked due to multiple failed login attempts. Please reset your password.");
				
			}
			
			return "Signin";
		}
	}

	@RequestMapping("/getpass")
	public String forgetpass() {
		return "ForgetPassword";

	}
}