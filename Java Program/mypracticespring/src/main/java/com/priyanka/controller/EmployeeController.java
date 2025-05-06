package com.priyanka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

	@RequestMapping("/home")
	public String getHome() {
		return "Home";
	}
	@RequestMapping("/login")
	public String GetLogin() {
		return "Login";
	}
	@RequestMapping("/reg")
	public String getRegister() {
		return "Register";
	}
	@RequestMapping("/view")
	public String getView() {
		return "EmployeeDetail";
	}
}
