package com.priyanka.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.DepartmentDTO;
import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.ComplaintsDTORepo;
import com.priyanka.service.ComplaintsServiceImpl;
import com.priyanka.service.DepartmentAdminServiceImpl;
import com.priyanka.service.EmployeeServiceImpl;
import com.priyanka.service.UserSignUpServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class RaiseComplaintController {

	@Autowired
	private ComplaintsServiceImpl complaintsServiceImpl;

	@Autowired
	private UserSignUpServiceImpl upServiceImpl;
	
	@Autowired
	private ComplaintsDTORepo complaintsDTORepo;
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	private DepartmentAdminServiceImpl departmentAdminServiceImpl;
public RaiseComplaintController() {
	log.info("acount created :"+this.getClass().getSimpleName());
}

@GetMapping("raiseComplaintPage")
public String raiseComplaintPage(Model model) {
	List<DepartmentDTO> departments=departmentAdminServiceImpl.findAllDepartments();
	model.addAttribute("departments", departments);
	model.addAttribute("action", "submit");
	return "RaiseComplaint";
}

@PostMapping("raiseComplaint")
public String setComplaint(ComplaintsDTO complaintsDTO, Model model,HttpSession session,@RequestParam String btn) {
	log.info("running setComplaint() in  complaint controller");
  boolean	edit=btn.equalsIgnoreCase("Edit");
Integer userId=(Integer)session.getAttribute("userId");
Integer empInfo=(Integer)session.getAttribute("empInfo");

if(userId==null || userId==0) {
	model.addAttribute("complaintMsg", "User not logged in.");
	return "RaiseComplaint";
}

      SignUpDTO  signUpDTO=upServiceImpl.findById(userId);
complaintsDTO.setCreatedBy(signUpDTO.getFirstName()+" "+signUpDTO.getLastName());
complaintsDTO.setCreatedAt(LocalDateTime.now());
complaintsDTO.setUserId(userId);
complaintsDTO.setEmployeeId(empInfo);
complaintsDTORepo.save(complaintsDTO);
if(!edit) {
	
	
	ComplaintsDTO saved=complaintsServiceImpl.complaintsDTOAccountCreated(complaintsDTO);
	if(saved!=null){
		 model.addAttribute("complaintMsg", "Your Complaint is Received");
         model.addAttribute("complaint", complaintsDTO);
         model.addAttribute("action", "submit");
         complaintsServiceImpl.sendComplaintEmailForUser(signUpDTO, complaintsDTO);
	}else {
		 model.addAttribute("complaintMsg", "Your Complaint is not Received, Please try again");
	}
}
else {
	int complaintId=complaintsDTO.getId();
	ComplaintsDTO existingComplaint =complaintsServiceImpl.findById(complaintId);
	
	if(existingComplaint ==null || existingComplaint.getUserId()!=userId) {
		 model.addAttribute("complaintMsg", "No such complaint found.");
         return "ViewComplaint";
	}
	complaintsDTO.setId(complaintId);
Boolean	update=complaintsDTORepo.save(complaintsDTO)!=null;
if(update) {
	  model.addAttribute("complaintMsg", "Complaint successfully updated.");
      model.addAttribute("complaint", complaintsDTO);
      model.addAttribute("action", "edit");
  } else {
      model.addAttribute("complaintMsg", "Failed to update the complaint, Please try again");
  }
}
return "RaiseComplaint";
}

@GetMapping("viewComplaints")
public String viewComplaints(Model model,HttpSession session,@RequestParam(value = "status",required = false)String status) {
	 Integer userId = (Integer) session.getAttribute("userId");
     if (userId == null || userId == 0) {
         model.addAttribute("complaintMsg", "User not logged in.");
         return "ViewComplaint";
     }
     if (status == null) {
         status = "active"; // default to "active" if no status is provided
     }
   List<ComplaintsDTO> complaints  = complaintsServiceImpl.getComplaintsByUserIdAndStatus(userId, status);
     if (complaints.isEmpty()) {
         model.addAttribute("complaintMsg", "No complaints found");
     } else {
         model.addAttribute("complaints", complaints);
     }
     model.addAttribute("selectedStatus", status);
     return "ViewComplaint";
 }

@GetMapping("/editComplaint")
public String editComplaints(@RequestParam("id")int id, Model  model,HttpSession session) {
	session.setAttribute("id", id);
	 Integer userId = (Integer) session.getAttribute("userId");
     if (userId == null || userId == 0) {
         model.addAttribute("complaintMsg", "User not logged in.");
         return "RaiseComplaint";
     }
     ComplaintsDTO complaint =complaintsServiceImpl.findById(id);
     if (complaint == null || complaint.getUserId() != userId) {
         model.addAttribute("complaintMsg", "No such complaint found.");
         return "ViewComplaint";
     }
     model.addAttribute("complaint", complaint);
     model.addAttribute("action", "edit");
     return "RaiseComplaint";
}

@GetMapping("/downloadComplaints")
public void downloadComplaints(HttpSession session, HttpServletResponse response) throws IOException {
    // Retrieve the userId from the session
    Integer userId = (Integer) session.getAttribute("userId");
    log.info("User ID from session: {}", userId);
    if (userId == null || userId == 0) {
        // Handle case where user is not logged in
        response.sendRedirect("logout"); // Redirect to logout or login page
        return;
    }

    List<ComplaintsDTO> complaints = complaintsServiceImpl.getComplaintsByUserId(userId);

    // Set the content type and headers for the response
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "attachment; filename=\"complaints.xlsx\"");

    // Create Excel workbook and sheet
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Complaints");

    // Create header row
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("ID");
    headerRow.createCell(1).setCellValue("Type");
    headerRow.createCell(2).setCellValue("Description");
    headerRow.createCell(3).setCellValue("Status");

    // Populate data rows
    int rowNum = 1; // Start from row 1 (after header)
    for (ComplaintsDTO complaint : complaints) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(complaint.getId());
        row.createCell(1).setCellValue(complaint.getType());
        row.createCell(2).setCellValue(complaint.getDescription());
        row.createCell(3).setCellValue(complaint.getStatus());
    }

    for (int i = 0; i < headerRow.getLastCellNum(); i++) {
        sheet.autoSizeColumn(i);
    }

    // Write workbook to response output stream
    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
}


}
