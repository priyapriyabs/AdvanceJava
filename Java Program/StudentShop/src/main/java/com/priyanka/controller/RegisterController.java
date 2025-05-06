package com.priyanka.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.entity.StudentEntity;
import com.priyanka.service.RegisterServiceImpl;


import jakarta.validation.Valid;


@Controller

public class RegisterController {
	
	@Autowired
	private RegisterServiceImpl registerServiceImpl;
	
	public RegisterController() {
		// TODO Auto-generated constructor stub
	System.out.println("Register Controller obj Created");
	}
	
	@RequestMapping("/reg")
	public String reg() {
		return "Registration";
	}
	
//	@RequestMapping("/newreg")
//	public String regAcountCreate(@ModelAttribute("student") StudentEntity studentEntity) {
//		registerServiceImpl.accountCreate(studentEntity);
//		
//		return"Login";
//	}
//	
	
	@RequestMapping("/newreg")
	public String validatesave(@Valid StudentEntity studentEntity, BindingResult bindingResult,Model model) {
//	List<StudentEntity>	allsave=registerServiceImpl.validatestdandsave(studentEntity);
//	allsave.add(studentEntity);
//		if(allsave==bindingResult) {
//			
//			registerServiceImpl.accountCreate(studentEntity);
//			model.addAttribute("student", allsave);
//			return "Login";	
//		}
//		model.addAttribute("error",bindingResult.hasErrors());
//		
//		return "Registration";
		
		  if(bindingResult.hasErrors()){
	            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
	            model.addAttribute("errors",bindingResult.getAllErrors());
	            model.addAttribute("dto",studentEntity);

	        }
		  return "Registration";
	}
	

}
