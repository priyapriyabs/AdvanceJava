package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.service.SignUpServiceImpl;

import jakarta.validation.Valid;

@Controller
public class SignUpController {

	@Autowired
	private SignUpServiceImpl signUpServiceImpl;
	
	@RequestMapping("/sign")
	public String signup() {
		return "Signup";
	}
	
//	@RequestMapping("/signup")
//	    public String setSignUp(@Valid SignUpDTO signUpDTO, BindingResult bindingResult, Model model){
//	        System.out.println("Running setDignUp in SignUpController");
//
//	        if(bindingResult.hasErrors()){
//	            bindingResult.getAllErrors();
//	            model.addAttribute("errors",bindingResult.getAllErrors());
//	            model.addAttribute("dto",signUpDTO);
//	           
//	        }
//	        return "Signup";
//	        }
	
	@RequestMapping("/signup")
	public String signupall(@ModelAttribute("signupall") SignUpDTO signUpDTO, Model model) {
	SignUpDTO	signupdata=signUpServiceImpl.getFirstEmail(signUpDTO.getEmail());

		if(signupdata==null) {
		
			signUpServiceImpl.accountCreate(signUpDTO);
			return "Signin";
		}
		
			model.addAttribute("errors", "Email Already exit");
			return "Signup";
		}
		
		
	}
	

