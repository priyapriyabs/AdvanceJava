package com.priyanka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.dto.AdminParkingDTO;
import com.priyanka.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DefaultController {

	public DefaultController() {
		log.info("Created: "+getClass().getSimpleName());
	}
	
	@RequestMapping("/onStart")
	public String onStart(Model model) {
		log.info("running onStart()");
	AdminParkingDTO	adminParking=new AdminParkingDTO();
	model.addAttribute("dto2", adminParking);
		return "UpdateAdminParkingInfo";
	}
	
	@RequestMapping("/onRegister")
	public String onRegister(Model model) {
		 log.info("running onStart()");
		UserDTO userDto=new UserDTO();
		 model.addAttribute("userDto", userDto);
		return "UserRegistration";
	}
}
