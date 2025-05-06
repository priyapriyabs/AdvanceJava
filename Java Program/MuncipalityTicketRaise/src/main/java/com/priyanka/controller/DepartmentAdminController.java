package com.priyanka.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.dto.AdminDTO;
import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.DepartmentAdminDTO;
import com.priyanka.dto.DepartmentDTO;
import com.priyanka.dto.EmployeeDTO;
import com.priyanka.service.ComplaintsServiceImpl;
import com.priyanka.service.DepartmentAdminServiceImpl;
import com.priyanka.service.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("departmentAdmin")
public class DepartmentAdminController {

	@Autowired
	private DepartmentAdminServiceImpl departmentAdminServiceImpl;
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	private ComplaintsServiceImpl complaintsServiceImpl;
	
	@GetMapping("signup")
	public String departmentSignUp(Model model) {
		model.addAttribute("departmentAdmin", true);
		return "DepartmentAdminSignUp";
	}
	
	@PostMapping("signup")
	public String departmentAdminAcount(@ModelAttribute("departmentAdminDto") DepartmentAdminDTO departmentAdminDTO,Model model,HttpSession session) {
		DepartmentAdminDTO departmentAdminEmail=departmentAdminServiceImpl.findByDepartmentAdminEmail(departmentAdminDTO.getEmail());
	if(departmentAdminDTO.getName()!="" && departmentAdminDTO.getEmail()!="" && departmentAdminDTO.getPassword()!="") {
	if(departmentAdminEmail==null) {
		departmentAdminServiceImpl.deparmentAdminAcountCreate(departmentAdminDTO);
		session.setAttribute("departmentAdminData", departmentAdminEmail);
		model.addAttribute("departmentAdminData", departmentAdminEmail);
		model.addAttribute("acountCreated", "Department Acount Created");
		return "SignIn";
	}else {
		model.addAttribute("emailExist", "This email Already Exist");
	}
		
	}else {
		model.addAttribute("departmentDataRequired", "Please Fill the form");
	}
	return "DepartmentAdminSignUp";
	}

	@GetMapping("signin")
public String departmentSignIn(AdminDTO adminDTO,Model model) {
	model.addAttribute("departmentAdmin", true);
	return "SignIn";
}

	@PostMapping("signin")
public String departmentAdminLogin(@RequestParam String email,@RequestParam String password,HttpSession session,Model model) {
DepartmentAdminDTO	departmentAdminEmail=departmentAdminServiceImpl.findByDepartmentAdminEmail(email);
	if(departmentAdminEmail!=null) {
		if(departmentAdminEmail.getEmail().equals(email) && departmentAdminEmail.getPassword().equals(password)) {
		session.setAttribute("departmentAdmindata", departmentAdminEmail);
		model.addAttribute("departmentAdmindata", departmentAdminEmail);
		return "DepartmentAdmin";
		}else {
			model.addAttribute("errormsg", "invalide email or password");
		}
	}else {
		model.addAttribute("errormsg", "This email or password not exist");
	}
	return "SignIn";
}
	
	@GetMapping("departmentAdminLogout")
	public String departmentAdminSignOut(HttpServletRequest req) {
	HttpSession session	=req.getSession();
	session.invalidate();
	return "redirect:/departmentAdmin/signin";
	}
	
	@GetMapping("addEmployee")
	public String goToaddEmployee(EmployeeDTO employeeDTO,Model model) {
		List<DepartmentDTO> departments=departmentAdminServiceImpl.findAllDepartments();
		model.addAttribute("employeeDTO", employeeDTO);
		model.addAttribute("departments", departments);
		return "AddEmployee";
	}
	
	@PostMapping("addEmployee")
	public String addEmployees(@ModelAttribute("employeeDTO")EmployeeDTO employeeDTO,BindingResult bindingResult, Model model) {
		 if (bindingResult.hasErrors()) {
	            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            model.addAttribute("dto", employeeDTO);
	            return "AddEmployee";
	        }
		 EmployeeDTO existingUser = employeeServiceImpl.validateEmail(employeeDTO.getEmail());
	        if (existingUser!=null) {
	            model.addAttribute("addMsg", "Email is already registered. Cannot register user.");
	            model.addAttribute("dto",employeeDTO);
	            return "AddEmployee";
	        }

	       EmployeeDTO phone = employeeServiceImpl.validatePhone(employeeDTO.getPhone());
	        if (phone!=null) {
	            model.addAttribute("addMsg", "Phone is already registered. Cannot register user.");
	            model.addAttribute("dto",employeeDTO);
	            return "AddEmployee";
	        }
		EmployeeDTO saved=employeeServiceImpl.employeeAcountCreate(employeeDTO);
		if(saved==null) {
			 model.addAttribute("departmentMsg", "Employee added successfully");
		}
		else {
            model.addAttribute("errors", "Error adding employee. Please try again.");
        }
		 model.addAttribute("employeeDTO", new EmployeeDTO());
	        model.addAttribute("departments", departmentAdminServiceImpl.findAllDepartments());
	        return "AddEmployee";
	}
	
	@GetMapping("/departmentAdminViewComplaints")
	public String updateDepartmentAndStatus(@RequestParam(required = false)String departmentName,@RequestParam(required = false)String clear, Model model) {
		complaintsServiceImpl.getAllComplaints();
		List<ComplaintsDTO> complaints;
	if(departmentName==null || departmentName.isEmpty() || "Clear".equals(clear)) {
		 complaints=complaintsServiceImpl.getAllComplaints();
	}else {
		complaints=complaintsServiceImpl.getComplaintByDepartmentName(departmentName);
	}
	Map<Integer, List<EmployeeDTO>> employeesByDepartment=new HashMap<>();
	for(ComplaintsDTO complaint:complaints) {
		Integer departmentId=complaint.getDepartmentId();
		List<EmployeeDTO> departmentEmployees=employeeServiceImpl.getEmployeeByDepartmentId(departmentId);
	employeesByDepartment.put(complaint.getId(), departmentEmployees);
	}
	 // Add complaints and employees by department to the model
    model.addAttribute("complaint", complaints);
    model.addAttribute("employeesByDepartment", employeesByDepartment);
    model.addAttribute("selectedType", departmentName); // Optional for selecting dropdown
    
    return "DepartmentAdminViewComplaints";
	}
	
	@PostMapping("/updateDepartmentAndStatus")
	public String updateDepartmentAndStatus(@RequestParam int id, @RequestParam(required = false) Integer employeeId,@RequestParam(required = false) String status, Model model) {
		if(status!=null && !status.isEmpty() && !status.equals("0")) {
			complaintsServiceImpl.updateComplaintStatus(id, status);
			complaintsServiceImpl.updateComplaintDepartmentAndStatus(id, employeeId, status);
		}
		if(employeeId!=null && employeeId!=0) {
			complaintsServiceImpl.updateComplaintEmployee(id, employeeId);
			complaintsServiceImpl.updateComplaintDepartmentAndStatus(id, employeeId, status);
		}
	List<ComplaintsDTO> complaints=complaintsServiceImpl.getAllComplaints();
	model.addAttribute("complaint", complaints);
	return "redirect:/departmentAdmin/departmentAdminViewComplaints";
	}









}
