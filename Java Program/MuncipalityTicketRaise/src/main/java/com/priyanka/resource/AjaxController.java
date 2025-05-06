package com.priyanka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.service.UserSignUpServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/")
@EnableWebMvc
public class AjaxController {
	
	@Autowired
	private UserSignUpServiceImpl upServiceImpl;

	public AjaxController() {
		log.info("acount created:"+this.getClass().getSimpleName());
	}

@GetMapping("/validateEmail" )
public String validateEmail(@RequestParam String email) {
  SignUpDTO	userEmail=upServiceImpl.findByUserEmail(email);
return userEmail!=null?"Email is Already exist":"";
}

@GetMapping("/validatePhone")
public String validatePhone(@RequestParam Long phone) {
SignUpDTO	userPhone=upServiceImpl.findByUserPhone(phone);
return userPhone!=null?"Phone number Already exist":"";

}
}
