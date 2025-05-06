package com.priyanka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String getHome() {
		System.out.println("calling home page");
		return "Home";
	}
	@RequestMapping("/login")
	public String getLogin() {
		System.out.println("calling Login page");
		return "Login";
	}
	@RequestMapping("/reg")
	public String getRegister() {
		System.out.println("calling Register page");
		return "Register";
	}
	@RequestMapping("/tab")
	public String getTable() {
		System.out.println("calling Table page");
		return "Table";
	}
	
}
