package com.priyanka.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.priyanka.dto.UserDTO;
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

	
	@RequestMapping("/reg")
public String register() {
		System.out.println("Welcome to reg");
		return "Regist";
	}
//@RequestMapping("/newRegister")
//	public String newRegister(@ModelAttribute("user") User user) {
//		System.out.println(user);
//
//		userserviceImpl.accountCreate(user);
//		return "redirect:/view";	
//}
@RequestMapping("/newRegister")
public String newRegister(@ModelAttribute("user") User user,Model model ) {
 User userData= userserviceImpl.getFirstEmail(user.getEmail());
if(userData==null)	{
 userserviceImpl.accountCreate(user);
 System.out.println(userData);
	return "Login";	
}else {
	model.addAttribute("error","Email already exist");
	return "Regist";
}
}
//	@RequestMapping("/login")
//	public String newLogin(@ModelAttribute("user") User user) {
//		System.out.println(user);
//
//		userserviceImpl.accountCreate(user);
//		return "Login";	
//}
//List<User> alluser=new ArrayList<User>();
//@RequestMapping("/newRegister")
//public String register(@ModelAttribute("user") User user) {
//	
//	alluser.add(user);
//	System.out.println(alluser);
//	return "Regist";
//	
//}
//@RequestMapping("/view")
//public ModelAndView viewall() {
//	ModelAndView mv=new ModelAndView();
//    List<User> alluser= userserviceImpl.getAllUser();
//	mv.addObject("userobj", alluser);
//	mv.setViewName("ViewUser");
//	
//		return mv;
//	}

@RequestMapping("/view")
public ModelAndView viewall() {
	ModelAndView mv=new ModelAndView();
    List<UserDTO> alluser= userserviceImpl.getAllUser();
	mv.addObject("userobj", alluser);
	mv.setViewName("ViewUser");
	
		return mv;
	}

	@RequestMapping("/deleteuser")
public ModelAndView delete(@RequestParam int id,Model model) {
	System.out.println(id);
	ModelAndView mv=new ModelAndView();
	userserviceImpl.deleteUser(id);
    List<UserDTO> alluser=  userserviceImpl.getAllUser();
	mv.addObject("userobj", alluser);
	mv.setViewName("ViewUser");
	return mv;
}
	
	@RequestMapping("/edituser")
	public String editUser(@RequestParam int id,Model model) {
		ModelAndView mv=new ModelAndView();
	User returnUser=	userserviceImpl.getUserById(id);
		model.addAttribute("editUser", returnUser);
		System.out.println(returnUser);
		return "Edituser";
	}
	@RequestMapping("/Update")
	public String update(@ModelAttribute ("user") User user,Model model) {
		userserviceImpl.updateUser(user);
		
		return "redirect:/view";	

}
	@RequestMapping("/login")
	public String newLogin(@ModelAttribute("user") User user,Model model ) {
	 User userData= userserviceImpl.getEmailPass(user.getEmail(), user.getPassword());
// userserviceImpl.accountCreate(user);
	 System.out.println(userData);
	if(userData!=null)	{
		
		return "Home";	
	}else {
		
		model.addAttribute("error","Invalide Email or Password");
		return "Login";
	}

	}
	

}

