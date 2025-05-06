package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.dto.UserDTO;
import com.priyanka.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping("/reg")
	public String registration() {
		return "Registration";
	}
	
	@RequestMapping("/newRegister")
	public String saveUser(@ModelAttribute("user") UserDTO userDTO) {
		userServiceImpl.userAccountCreate(userDTO);
	return "Registration";
	}
	
	@RequestMapping("/login")
	public String userLogin() {
		return "Login";
	}
	
	@RequestMapping("/userlogin")
	public String userSignIn(@RequestParam("email")String email, @RequestParam("password")String password) {
		userServiceImpl.loginByEmailAndPass(email, password);
		return "Home";
	}
}
