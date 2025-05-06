package com.priyanka.controller;

import org.hibernate.cfg.annotations.ListBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.service.SignUpServiceImpl;

import antlr.collections.List;
import jakarta.validation.Valid;

@Controller
public class SignUpController {

	@Autowired
	private SignUpServiceImpl signUpServiceImpl;
	
	@RequestMapping("/sign")
	public String signup() {
		return "Signup";
	}
	
	@RequestMapping("/signup")
	public String signupall(@Valid @ModelAttribute("signupall") SignUpDTO signUpDTO, BindingResult bindingResult,Model model) {
	SignUpDTO	signupdata=signUpServiceImpl.getFirstEmail(signUpDTO.getEmail());
	 if(bindingResult.hasErrors()){
     bindingResult.getAllErrors();
       
         model.addAttribute("errors",bindingResult.getAllErrors());
         model.addAttribute("dto",signUpDTO);
         if(signupdata!=null) {
 			
 			model.addAttribute("emailerrors", "Email Already exit");
 		}
         return "Signup";
     }
	
	 else  {
		
			signUpServiceImpl.accountCreate(signUpDTO);
			return "Signin";
		}
	
	}
		
	}
	

