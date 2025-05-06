package com.priyanka.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.dto.AdminDTO;
import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.SignUpDTO;
import com.priyanka.service.AdminServiceImpl;
import com.priyanka.service.ComplaintsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("admin")
@Slf4j
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Autowired
	private ComplaintsServiceImpl complaintsServiceImpl;

	public AdminController() {
		log.info("Account create:"+this.getClass().getSimpleName());
	}
	
	@PostConstruct
	public void init() {
		log.info("AdminController Start: ");
	}

@GetMapping("signup")
public String adminSignUp(Model model) {
	model.addAttribute("admin", true);
	return "AdminSignUp";
}

@PostMapping("signup")
public String adminAccountCreate(@ModelAttribute("adminDto") AdminDTO adminDTO, Model model,HttpSession session) {
AdminDTO	adminEmail=adminServiceImpl.FindByAdminEmail(adminDTO.getEmail());
if(adminDTO.getEmail()!="" && adminDTO.getName()!="" && adminDTO.getPassword()!="") {
	if(adminEmail==null) {
		adminServiceImpl.adminDTOAcountCreate(adminDTO);
		session.setAttribute("adminData", adminEmail);
		model.addAttribute("adminData", adminEmail);
		return "SignIn";
	}else {
		model.addAttribute("adminerror", "This Email Already Exist");
		
	}
}else {
	model.addAttribute("dataRequiredError", "Please Fill the form");
}
return "AdminSignUp";
}

@GetMapping("signin")
public String adminLogin(AdminDTO adminDTO, Model model) {
	model.addAttribute("admin", true);
	return "SignIn";
}

@PostMapping("signin")
public String adminLogin(@RequestParam String email,@RequestParam String password, HttpSession session, Model model) {
log.info("running adminLogin():");
AdminDTO	adminemail=adminServiceImpl.FindByAdminEmail(email);
 AdminDTO  adminEmailPass=adminServiceImpl.FindByAdminEmailAndPass(email, password);
if(adminEmailPass!=null) {
	if(adminemail.getEmail().equals(email) && adminemail.getPassword().equals(password) || adminemail.getEmail()!="" && adminemail.getPassword()!="") {
		session.setAttribute("adminData", adminemail);
		model.addAttribute("adminLoginEmail", adminemail);
		return "Admin";
	} 
	else {
		model.addAttribute("errormsg", "Please enter valide email");
	}
}
else {
	model.addAttribute("errormsg", "This email or password  not Exist");
}
return "SignIn";
}


@GetMapping("/viewUsers")
public String viewUsers(Model model) {
    List<SignUpDTO> users = adminServiceImpl.getAllUsers();
    log.info("{}",users);
    model.addAttribute("users", users);
    return "ViewUsers";
}

@GetMapping("/adminViewComplaints")
public String adminViewComplaints(
        @RequestParam(required = false) String type,
        @RequestParam(required = false) String area,

        Model model
) {
    List<ComplaintsDTO> complaints;

    complaints=complaintsServiceImpl.getAllComplaints();
    log.info("Type:{} " , type , ", Area:{} " , area);
    log.info("Type is empty:{} " , (type == null || type.isEmpty()));
    log.info("Area is empty:{} " , (area == null || area.isEmpty()));

    if ((type == null || type.isEmpty()) && (area == null || area.isEmpty())) {
        complaints = complaintsServiceImpl.getAllComplaints(); // Fetch all complaints
    } else {
        List<ComplaintsDTO> list = adminServiceImpl.searchComplaintsByTypeOrArea(type, area);
        if (!list.isEmpty()) {
            model.addAttribute("complaint", list);
            return "AdminViewComplaint";
        } else {
            model.addAttribute("msg", "Data not found");
            List<ComplaintsDTO> list1 = adminServiceImpl.searchComplaintsByTypeOrArea(type, area);
            if (!list1.isEmpty()) {
                model.addAttribute("complaint", list1);
                return "AdminViewComplaint";
            }
        }
    }

    model.addAttribute("complaint", complaints);
    return "AdminViewComplaint";
}

@PostMapping("/updateComplaintAssignAnsStatus")
public String updateComplaintStatus(
        @RequestParam int id,
        @RequestParam(required = false) String status,
        @RequestParam("departmentName") String departmentName,
        Model model
) {
    if (status != null && !status.isEmpty() && !status.equals("0")) {
        adminServiceImpl.updateComplaintStatus(id, status);
    }

    List<ComplaintsDTO> complaints = complaintsServiceImpl.getAllComplaints();// Assuming you fetch all complaints again
    model.addAttribute("complaint", complaints);


    if (departmentName != null && !departmentName.isEmpty()) {
        // updating department id
        Integer departmentId = adminServiceImpl.getDepartmentIdByType(departmentName);
        if (departmentId != null) {
            // Update complaint with department ID
            adminServiceImpl.updateComplaintDepartment(id, departmentId);
        } 
    }    else {
            model.addAttribute("msg", "Department not found for the given name.");
        }
    


    return "redirect:/admin/adminViewComplaints"; // Redirect to the complaints view page
}

@GetMapping("/adminLogout")
public String logout(HttpServletRequest request){
    HttpSession httpSession = request.getSession();
    httpSession.invalidate();
    return "redirect:/admin/signin";
}




@PreDestroy
public void destroy() {
	log.info("AdminController end: ");
}

}



