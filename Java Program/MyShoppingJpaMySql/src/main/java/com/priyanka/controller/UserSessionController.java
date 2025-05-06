package com.priyanka.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.priyanka.entity.User;

@Controller
@SessionAttributes("usersession")
public class UserSessionController {

	@RequestMapping("/newRegister")
	
	public ModelAndView showSession(@RequestParam String name, @SessionAttribute("usersession") User user) {
		// HttpSession session = request.getSession(true);
		ModelAndView mv=new ModelAndView();
			mv.addObject("usersession", name);
			System.out.println(name);
			mv.setViewName("Home");
			return mv;
			
		}
}
