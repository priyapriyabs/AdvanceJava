//package com.priyanka.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.IntStream;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//
//import com.priyanka.entity.StudentEntity;
//
//
//@Controller
//public class StudentController {
//	
////	@Autowired
////	private RegisterServiceImpl registerServiceImpl;
//
//	@RequestMapping("/reg")
//	public String goToRegister() {
//		
//		return "Registration";
//	}
//	
//	List<StudentEntity> allstd=new ArrayList<StudentEntity>();
//	@RequestMapping("/newreg")
//	public String goToNextReg(@ModelAttribute("student") StudentEntity studententity,Model model) {
//		//registerServiceImpl.accountCreate(studententity);
//		allstd.add(studententity);
//		
//		System.out.println(allstd);
//		return "Login";
//	}
//	
//	@RequestMapping("/view")
//public ModelAndView view() {
//		ModelAndView mv=new ModelAndView();
//	mv.addObject("stdobj", allstd);
//	mv.setViewName("ViewUser");
//	return mv;
//}
//	
//	@RequestMapping("/deletestud")
//	public String deletStd(@RequestParam String id, Model model) {
//		allstd.removeIf(a->a.getEmail().equals(id));
//		model.addAttribute("stdobj", allstd);
//		System.out.println(id);
//		return "ViewUser";
//		}
//
//	@RequestMapping("/editstud")
//public String edit(@RequestParam String id, Model model) {
//StudentEntity	resendEdit=allstd.stream().filter(x->x.getEmail().equals(id)).findAny().orElse(null);
//	model.addAttribute("editobj", resendEdit);
//	System.out.println(resendEdit);
//	return "EditStudent";
//}
//	
//	@RequestMapping("/update")
//	public String update(@ModelAttribute ("user") StudentEntity studentEntity,Model model) {
//		int index =IntStream.range(0, allstd.size())
//				.filter(i->allstd.get(i).getEmail()
//						.equals(studentEntity.getEmail()))
//				.findFirst().orElse(-1);
//		System.out.println(index);
//		allstd.set(index, studentEntity);
//		model.addAttribute("stdobj", allstd);
//		return "ViewUser";
//	}
//	
//
//}
//
