package com.priyanka.service;

import java.util.List;

import com.priyanka.dto.AdminDTO;
import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.SignUpDTO;

public interface AdminService {

	void adminDTOAcountCreate(AdminDTO adminDTO);
	
	AdminDTO  FindByAdminEmail(String email);

	AdminDTO  FindByAdminEmailAndPass(String email,String password);

List<SignUpDTO> getAllUsers();

List<ComplaintsDTO> searchComplaintsByTypeOrArea(String type, String area);

void updateComplaintStatus(int complaintId, String status);

int getDepartmentIdByType(String departmentName);

void updateComplaintDepartment(int complaintId, int departmentId);
}
