package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.SignUpRepository;
import com.priyanka.service.SignUpServiceImpl;
import com.priyanka.util.generateRandomOTP;

@Controller
public class ForgetPasswordController {

	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private SignUpServiceImpl signUpServiceImpl;

	@RequestMapping("/forgetpass")
public String sendOTP(@RequestParam("email") String email,Model model) {
SignUpDTO	getemail=signUpServiceImpl.getFirstEmail(email);
	if(getemail!=null) {
		String getopt=generateRandomOTP.generateOTP();
		System.out.println(getopt+getemail);
		getemail.setOtp(getopt);
		signUpServiceImpl.sendOTP(getemail);
		signUpRepository.save(getemail);
		System.out.println(getemail);
		return "SendOTP";
	}else {
		model.addAttribute("emailerror","Please Enter Valide Email");
		return "ForgetPassword";
	}
	
}
	@RequestMapping("/sendotp")
	public String setopt(@RequestParam String email, @RequestParam String otp, Model model) {
	SignUpDTO	getbyemail=signUpServiceImpl.getFirstEmail(email);
	SignUpDTO	getbyotp=	signUpServiceImpl.updateByOTP(otp);
		if(getbyemail!=null && getbyotp!=null) {
			return "PasswordReset";
		}else {
			model.addAttribute("otperror","Verification Wrong");
			return "SendOTP";
		}
	}

}
