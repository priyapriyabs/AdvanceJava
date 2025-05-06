package com.priyanka.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.priyanka.dto.UserDTO;
import com.priyanka.service.UserServiceImpl;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping("/reg")
	public String registration() {
		return "Registration";
	}
	
	@RequestMapping("/newRegister")
	public String saveUser(@Valid UserDTO userDTO,Model model,BindingResult bindingResult) {
		UserDTO	existPhone=userServiceImpl.validatePhone(userDTO.getContact_number());
		if(bindingResult.hasErrors()) {
			 bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
	         model.addAttribute("errors",bindingResult.getAllErrors());
	         model.addAttribute("dto",userDTO);
		}
	
	else if(existPhone!=null) {
			 model.addAttribute("signupMsg","Phone is already registered.cannot register user");
	         model.addAttribute("dto",userDTO);
	         return "Registration";
		}
		else {
		
		UserDTO	userMail=userServiceImpl.findByEmail(userDTO.getEmail());
		if(userMail==null) {
		userServiceImpl.userAccountCreate(userDTO);
		model.addAttribute("user", userMail);
		model.addAttribute("userName", userDTO);
	return "Login";
		}else {
			model.addAttribute("error", "This mail already exist please Register with different email");
		}
		}
		return "Registration";
	}
	
	@RequestMapping("/view")
	public String viewUser(UserDTO userDTO, Model model) {
		List<UserDTO> allUsers=userServiceImpl.getAllUsers();
		model.addAttribute("users", allUsers);
		return "ViewUser";
	}
	
	@RequestMapping("/login")
	public String userLogin() {
		return "Login";
	}
	
	@RequestMapping("/userlogin")
	public String userSignIn(@RequestParam("email")String email, @RequestParam("password")String password,Model model) {
	UserDTO	emailUser=userServiceImpl.loginByEmailAndPass(email,password);
	if(emailUser!=null) {
		userServiceImpl.loginByEmailAndPass(email, password);
		model.addAttribute("userDetails", emailUser);
		return "Home";
	}else {
		model.addAttribute("emailError", "Please Enter Valide Email");
		return "Login";
	}
	}
	
	@RequestMapping("/home")
public String homePage() {
	return "index";
}
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam int id, Model model) {
		userServiceImpl.deleteUserById(id);
		List<UserDTO> allUsers=userServiceImpl.getAllUsers();
		model.addAttribute("deleteUsers",allUsers );
		return "redirect:/view";
	}
	
	@RequestMapping("/editUser")
	public String editUser(@RequestParam int id, Model model) {
		UserDTO editUser=userServiceImpl.editUserById(id);
	model.addAttribute("editAllUser", editUser);
	return "EditUser";
	}

@RequestMapping("/updateUser")
public String updateUser(@ModelAttribute("userUpdate") UserDTO userDTO) {
	userServiceImpl.updateUser(userDTO);
	return "redirect:/view";
}

}


