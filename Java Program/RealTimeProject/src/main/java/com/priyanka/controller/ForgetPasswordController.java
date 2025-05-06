package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.dto.SignUpDTO;
import com.priyanka.service.SignUpServiceImpl;
import com.priyanka.util.generateRandomOTP;

@Controller
public class ForgetPasswordController {

	@Autowired
	private SignUpServiceImpl signUpServiceImpl;

public String sendOTP(@RequestParam("email") String email,Model model) {
SignUpDTO	getemail=signUpServiceImpl.getFirstEmail(email);
	if(getemail!=null) {
		String getopt=generateRandomOTP.generateOTP();
		getemail.setOtp(getopt);
		signUpServiceImpl.updateByOTP(getopt);
		return "SendOTP";
	}else {
		return "ForgetPassword";
	}
	
}

}
