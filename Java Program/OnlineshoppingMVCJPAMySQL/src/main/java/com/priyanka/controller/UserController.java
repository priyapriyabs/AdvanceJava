package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.entity.User;
import com.priyanka.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userserviceImpl;
	
	@RequestMapping("/home")
	public String home() {
			return "Home";
		}

	
//	@RequestMapping("/reg")
//public String register() {
//		return "Regist";
//	}
@RequestMapping("/newRegister")
	public String newRegister(@ModelAttribute("user") User user) {
		System.out.println(user);

		userserviceImpl.accountCreate(user);
		return "Login";	
}

//	@RequestMapping("/login")
//	public String newRegister(@ModelAttribute("user") User user) {
//		System.out.println(user);
//
//		userserviceImpl.accountCreate(user);
//		return "Login";	
//}
}
