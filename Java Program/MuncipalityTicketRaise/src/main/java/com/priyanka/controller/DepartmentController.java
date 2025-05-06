package com.priyanka.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyanka.dto.DepartmentDTO;
import com.priyanka.service.DepartmentAdminServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class DepartmentController {

	@Autowired
	private DepartmentAdminServiceImpl departmentAdminServiceImpl;

public DepartmentController() {
	log.info("acount created: "+this.getClass().getSimpleName());
}

@PostMapping("departmentSignup")
public String departmentDetails(@ModelAttribute("departmentsData") DepartmentDTO departmentDTO, Model model, HttpSession session) {
	log.info("Running deparnmentDetails():"+departmentDTO);
DepartmentDTO	depName=departmentAdminServiceImpl.findByDepartmentName(departmentDTO.getDepartmentName());
if(depName==null) {
	departmentAdminServiceImpl.save(departmentDTO);
	model.addAttribute("actCreate", "Acount Created");
	model.addAttribute("depDetail", depName);
}else {
	model.addAttribute("depMessage", "There is some issue to create an acount");
}
return "DepartmentSignUp";
}


}
