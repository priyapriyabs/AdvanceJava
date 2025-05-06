package com.priyanka.service;

import java.util.List;

import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.HistoryDTO;
import com.priyanka.dto.SignUpDTO;

public interface ComplaintsService {

	ComplaintsDTO complaintsDTOAccountCreated(ComplaintsDTO complaintsDTO);
	
	void sendComplaintEmailForUser(SignUpDTO signUpDTO,ComplaintsDTO complaintsDTO);
	
	ComplaintsDTO findById(int id);
	
	 List<ComplaintsDTO> getComplaintsByUserIdAndStatus(int userId, String status);

	 List<ComplaintsDTO> getAllComplaints();
	 
	 List<ComplaintsDTO> getComplaintByDepartmentName(String departmentName);
	 
	 void saveHistory(HistoryDTO historyDTO);

	 void updateComplaintStatus(int complaintId, String status);
	 
	 void updateComplaintDepartmentAndStatus(int id, Integer employeeId, String status);
	 
	 void updateComplaintEmployee(int complaintId, Integer employeeId);
	 
	 List<ComplaintsDTO> getComplaintsByUserId(int userId);
}
