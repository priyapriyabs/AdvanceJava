package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.SignUpRepository;
import com.priyanka.service.SignUpServiceImpl;

@Controller
public class ResetPasswordController {

	@Autowired
	private SignUpRepository signUpRepository;

	@Autowired
	private SignUpServiceImpl signUpServiceImpl;

	@RequestMapping("/changepass")
	public String passchange(@RequestParam("email") String email, @RequestParam("newpassword") String newpassword,
			@RequestParam("conformpassword") String conformpassword, Model model) {

		SignUpDTO setemail = signUpServiceImpl.getFirstEmail(email);

		if (newpassword.equals(conformpassword)) {

			setemail.setPassword(newpassword);
			
			signUpRepository.save(setemail);
			System.out.println("SET NEW PASS" + setemail);

			return "Signin";
		} else {
			model.addAttribute("reseterror", "Password not match");
			return "PasswordReset";
		}

	}
}
