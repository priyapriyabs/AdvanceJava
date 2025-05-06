package com.priyanka.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.priyanak.model.User;

@Controller
public class UserController {

//	@RequestMapping("/userLogin")
//	public String login(@RequestParam("username") String user,
//			@RequestParam("password") String pass) {
//		System.out.println(user);
//		System.out.println(pass);
//		if(user.equalsIgnoreCase("Priyanka") && pass.equalsIgnoreCase("123")) {
//			return "Home";	
//		}else {
//			return "Login";
//		}
//		
//	}
	@RequestMapping("/userLogin")
	public ModelAndView login(@RequestParam("username") String user,
			@RequestParam("password") String pass) {
		ModelAndView mv=new ModelAndView();
		if(user.equalsIgnoreCase("Priyanka") && pass.equalsIgnoreCase("123")) {
			mv.addObject("LoginNamedet",user );
			mv.setViewName("Home");
			return mv;	
		}else {
			//mv.addObject("LoginNamedet",user );
			System.out.println("invalid log in"+user);
			mv.setViewName("Login");
			return mv;
		}
		
	}

//	@RequestMapping("/view")
//	public ModelAndView viewall() {
//		ModelAndView mv=new ModelAndView();
//		List<String> names=new ArrayList<String>();
//		names.add("Arun");
//		names.add("Kiran");
//		names.add("Jhon");
//		names.add("Priyanka");
//		mv.addObject("snames", names);
//		mv.setViewName("ViewAll");
//		
//			return mv;
//		}
	List<User> alluser=new ArrayList<User>();
	@RequestMapping("/newreg")
	public String register(@ModelAttribute("user") User user) {
		user.setCname("Xworkz");
		alluser.add(user);
		System.out.println(alluser);
		return "Register";
		
	}
	@RequestMapping("/view")
	public ModelAndView viewall() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("userobj", alluser);
		mv.setViewName("ViewAll");
		
			return mv;
		}

		@RequestMapping("/deleteuser")
	public String delete(@RequestParam String id,Model model) {
		System.out.println(id);
		alluser.removeIf(x->x.getMobile().equals(id));
		model.addAttribute("userobj", alluser);
		return "ViewAll";
	}
		
		@RequestMapping("/edituser")
		public String editUser(@RequestParam String mobile,Model model) {
			User returnUser =  alluser.stream().filter(p->p.getMobile()
					.equals(mobile)).findAny().orElse(null);
			model.addAttribute("editUser", returnUser);
			System.out.println(returnUser);
			return "Edituser";
		}
		@RequestMapping("/Update")
		public String update(@ModelAttribute ("user") User user,Model model) {
			int index =IntStream.range(0, alluser.size())
					.filter(i->alluser.get(i).getMobile()
							.equals(user.getMobile()))
					.findFirst().orElse(-1);
			System.out.println(index);
			alluser.set(index, user);
			model.addAttribute("userobj", alluser);
			return "ViewAll";
		}
	}





