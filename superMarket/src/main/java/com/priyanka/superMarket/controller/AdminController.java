package com.priyanka.superMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.superMarket.entity.AdminEntity;
import com.priyanka.superMarket.service.AdminServiceImpl;

@Controller
@RequestMapping("/")
public class AdminController {
	
    @Autowired
	private AdminServiceImpl adminServiceImpl;

	@GetMapping("/index")
	public String start() {
		return "index";
	}
	
	@GetMapping("/reg")
	public String registration() {
		return "Registration";
	}
	
	@PostMapping("/save")
	public String adminAcountCreate(@RequestParam String marketName,@RequestParam String location,@RequestParam String customerCare,@RequestParam String email
			,@RequestParam String managerName,@RequestParam int managerId) {
		AdminEntity entity=new AdminEntity();
		entity.setMarketName(marketName);
		entity.setLocation(location);
		entity.setCustomerCare(customerCare);
		entity.setEmail(email);
		entity.setManagerName(managerName);
		entity.setManagerId(managerId);
	adminServiceImpl.adminAccountCreate(entity);
	return "Data saved";
	}
	//json
	
	@GetMapping("/view")
	public List<AdminEntity> viewAdmin(AdminEntity adminEntity,Model model) {
		return 	adminServiceImpl.displayAllAdmin(adminEntity);
		
	}
}
