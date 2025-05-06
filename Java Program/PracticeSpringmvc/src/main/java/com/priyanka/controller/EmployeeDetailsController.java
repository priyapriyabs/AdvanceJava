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
			empl.setCity("Pune");
				allemp.add(empl);
				System.out.println(allemp);
		return "Login";
		
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
			allemp.removeIf(x->x.getEmp_id()==id);	
			model.addAttribute("emplobj",allemp);
				System.out.println(id);
				return "EmployeeDetail";
			}
			@RequestMapping("/editemp")
			public String editUser(@RequestParam int id, Model model) {
			EmployeeDetails empedit	=allemp.stream().filter(p->p.getEmp_id()==id).findAny().orElse(null);
				model.addAttribute("empledit",empedit);
				System.out.println(empedit);
				return "EditEmp";
			}
			@RequestMapping("/udtate")
			public String updateemp(@ModelAttribute("empl") EmployeeDetails empl, Model model) {
				int index =IntStream.range(0, allemp.size())
						.filter(i->allemp.get(i).getEmp_id()
								==(empl.getEmp_id()))
						.findFirst().orElse(-1);
				System.out.println(index);
				allemp.set(index, empl);
				model.addAttribute("emplobj",allemp);
				
				return "EmployeeDetail";
				
			}
}