package com.priyanka.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.dto.EmployeeDTO;
import com.priyanka.dto.PasswordResetDTO;
import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.UserSignUpDTORepo;
import com.priyanka.service.EmployeeServiceImpl;
import com.priyanka.service.UserSignUpServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class UserSignUpController {

	@Autowired
	private UserSignUpServiceImpl upServiceImpl;
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserSignUpDTORepo upDTORepo;

public UserSignUpController() {
	log.info("acount created: "+this.getClass().getSimpleName());
}

@PostMapping("userSignup")
public String userRegister(@Valid SignUpDTO signUpDTO,BindingResult bindingResult,Model model) {
	log.info("UserSignUP() Running");
	if(bindingResult.hasErrors()) {
		 bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
         model.addAttribute("errors",bindingResult.getAllErrors());
         model.addAttribute("dto",signUpDTO);
	}else {
	SignUpDTO	existEmail=upServiceImpl.validateEmail(signUpDTO.getEmail());
	if(existEmail!=null) {
		  model.addAttribute("signupMsg", "Email is already registered. Cannot register user.");
          model.addAttribute("dto",signUpDTO);
          return "SignUp";
	}
SignUpDTO	existPhone=upServiceImpl.validatePhone(signUpDTO.getPhone());
	if(existPhone!=null) {
		 model.addAttribute("signupMsg","Phone is already registered.cannot register user");
         model.addAttribute("dto",signUpDTO);
         return "SignUp";
	}
SignUpDTO	userEmail=upServiceImpl.findByUserEmail(signUpDTO.getEmail());
	if(userEmail==null) {
upServiceImpl.userAcountCreated(signUpDTO);
String generatePass=upServiceImpl.generateRandomPassword();
model.addAttribute("signupMsg","Successfully Signed Up "+signUpDTO.getFirstName()+" "+signUpDTO.getLastName());
model.addAttribute("password","Your password is "+generatePass);
return "SignIn";
	}else {
		 model.addAttribute("signupMsg"," Signed Up is Failed "+signUpDTO.getFirstName());
	}
	}
	
	return "SignUp";
}

@PostMapping("/signIn")
public String userAndEmpDetails(SignUpDTO signUpDTO,EmployeeDTO employeeDTO,HttpServletRequest req,Model model) {
	log.info("running userAndEmpDetails()");
  SignUpDTO userInfo=upServiceImpl.findByUserEmail(signUpDTO.getEmail());
    EmployeeDTO  empInfo=employeeServiceImpl.findByEmployeeEmail(employeeDTO.getEmail());
if(empInfo!=null && empInfo.getPassword().equals(employeeDTO.getPassword())) {
             HttpSession session=req.getSession();
	session.setAttribute("user", empInfo);
	session.setAttribute("empInfo", empInfo.getId());
	return "Employee";
}

if(userInfo!=null) {
	
	if(userInfo.getCount()==0 && !passwordEncoder.matches(signUpDTO.getPassword(), userInfo.getPassword())) {
	upServiceImpl.updateLogInCount(userInfo.getId());	
		model.addAttribute("dto", userInfo);
		model.addAttribute("message", "Login sucsessfully");
		
		HttpSession session=req.getSession();
	session.setAttribute("userId", userInfo.getId());
	return "PasswordResetPage";
	}	
         else {
        	 HttpSession session=req.getSession();
         session.setAttribute("email", userInfo.getEmail());
         session.setAttribute("firstName",userInfo.getFirstName());
         session.setAttribute("lastName",userInfo.getLastName());
         session.setAttribute("phone",userInfo.getPhone());
         session.setAttribute("action","edit");
//         httpSession.setAttribute("image",userOptional.get().getProfileImage());
         upServiceImpl.updateLogInCount(userInfo.getId());
         session.setAttribute("userId", userInfo.getId());
         
         String profileImageUrl="/images/"+userInfo.getProfileImage();
         session.setAttribute("profileImage",profileImageUrl);
         model.addAttribute("dto", userInfo);
         model.addAttribute("message", "Login Successful, Welcome Back");
         return "Home";
     }
         }

	 else {
         upServiceImpl.incrementFailedAttempts(userInfo.getId());
         int attemptsLeft = 2 - userInfo.getFailedAttempts();
         if (attemptsLeft > 0) {
             model.addAttribute("errorsMsg", "Incorrect Password or Email. You have " + attemptsLeft + " attempts left.");
         } else {
             upServiceImpl.lockAccount(userInfo.getId());
             model.addAttribute("errorsMsg", "Account locked due to multiple failed login attempts. Please reset your password.");
             model.addAttribute("userLocked", true);
         }
	 }
model.addAttribute("errorsMsg", "User not found for email");
 return "SignIn";
}


@PostMapping("/resetPassword")
public String resetPassword(@Valid PasswordResetDTO passwordResetDTO, BindingResult bindingResult,HttpSession session,Model model ) {
log.info("running resetPassword in Signup controller"+passwordResetDTO);	
	if(bindingResult.hasErrors()) {
		model.addAttribute("dto", passwordResetDTO);
		model.addAttribute("errors", bindingResult.getAllErrors());
		return "PasswordResetPage";
	}
	if(!passwordResetDTO.getNewPassword().equals(passwordResetDTO.getConfirmPassword())) {
		log.info("New Password and conform Password not match");
		model.addAttribute("dto", passwordResetDTO);
        model.addAttribute("passnotmatch", "new Password and Confirm password are not matches");
        return "PasswordResetPage";
	}
SignUpDTO	userSameEmail=upServiceImpl.findByUserEmail(passwordResetDTO.getEmail());
    
	if(userSameEmail!=null) {
//		String randomPass=upServiceImpl.generateRandomPassword();
		if(userSameEmail.getEmail().equals(passwordResetDTO.getEmail())) {
		if(!passwordEncoder.matches(passwordResetDTO.getPassword(), userSameEmail.getPassword())) {
			 log.info("password is resetting.....");
			String encodedPass=passwordEncoder.encode(passwordResetDTO.getNewPassword());
		userSameEmail.setNewPassword(encodedPass);
		upDTORepo.save(userSameEmail);
		 session.setAttribute("action","edit");
         model.addAttribute("message", "Password reset successful. Please login with your new password.");
         return "SignIn";
		}
		}
	}
	 model.addAttribute("message","Invalid Email or Password");
     return "PasswordResetPage";
}

@GetMapping("logout")
public String logOutUser(HttpServletRequest req) {
	HttpSession session=req.getSession();
session.invalidate();
return "SignIn";

}





}

