package com.priyanka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.priyanka.model.EmployeeDetails;

@Controller
public class EmployeeDetailsController {

	@RequestMapping("/userlogin")
	public ModelAndView GetUserLogin(@RequestParam("email") String email, @RequestParam("password") String pass) {
		ModelAndView mv=new ModelAndView();
		 
			  mv.addObject("logby",email);
			mv.setViewName("Home");
			return mv;
	}
	List<EmployeeDetails> allemp=new ArrayList<>();
			@RequestMapping("/newreg")
	public String getRegister(@ModelAttribute("empl") EmployeeDetails empl ) {
			empl.setCity("Bangalore");
				allemp.add(empl);
				System.out.println(allemp);
		return "Register";
		
}
			@RequestMapping("/viewall")
			public ModelAndView empView() {
				ModelAndView mv=new ModelAndView();
				mv.addObject("emplobj",allemp );
				mv.setViewName("EmployeeDetail");
				return mv;
				
			}
			
			@RequestMapping("/deleteemp")
			public String deleteempl(@RequestParam int id, Model model ){
				
				model.addAttribute("emplobj",allemp);
				System.out.println(id);
				return "EmployeeDetail";
			}
			
			
			
}