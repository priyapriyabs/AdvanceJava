package com.priyanka.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.dto.AdminDTO;
import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.HistoryDTO;
import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.AdminDTORepo;
import com.priyanka.repository.ComplaintsDTORepo;
import com.priyanka.repository.DepartmentDTORepo;
import com.priyanka.repository.HistoryDTORepo;
import com.priyanka.repository.UserSignUpDTORepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDTORepo adminDTORepo;
	
	@Autowired
	private UserSignUpDTORepo upDTORepo;

	@Autowired
	private ComplaintsDTORepo complaintsDTORepo;
	
	@Autowired
	private HistoryDTORepo historyDTORepo;
	
	@Autowired
	private DepartmentDTORepo departmentDTORepo;
	
	@Override
	public void adminDTOAcountCreate(AdminDTO adminDTO) {
		adminDTO.setCreatedAt(LocalDateTime.now());
		adminDTO.setCreatedBy(adminDTO.getName());
		adminDTO.setModifiedAt(LocalDateTime.now());
		adminDTO.setModifiedBy(adminDTO.getName());
		adminDTO.setFailedAttemptedCount(0);
		adminDTORepo.save(adminDTO);
	}

	@Override
	public AdminDTO FindByAdminEmail(String email) {
		
		return adminDTORepo.findByAdminEmail(email);
	}

	@Override
	public AdminDTO FindByAdminEmailAndPass(String email, String password) {
		
		return adminDTORepo.findByAdminEmailAndPass(email, password);
	}

	@Override
	public List<SignUpDTO> getAllUsers() {
		
		return upDTORepo.findAll();
	}

	@Override
	public List<ComplaintsDTO> searchComplaintsByTypeOrArea(String type, String area) {
	List<ComplaintsDTO> list=complaintsDTORepo.searchComplaintsByTypeOrArea(type, area);
	  if(!list.isEmpty()){
          log.info("List found");
          return list;
      }else {
          return null;
      }
	}

	@Override
	public void updateComplaintStatus(int complaintId, String status) {
		 ComplaintsDTO complaint = complaintsDTORepo.findById(complaintId).get();
	        if (complaint != null) {
	            complaint.setStatus(status); // Update the status
	            complaintsDTORepo.save(complaint); // Save the updated complaint

	            HistoryDTO history = new HistoryDTO();

	            history.setComplaintId(complaintId);
	            history.setUserId(complaint.getUserId()); // Assuming the complaint has userId
	            history.setStatus(status);
	            historyDTORepo.save(history);
	        }
	}

	@Override
	public int getDepartmentIdByType(String departmentName) {
		
		return departmentDTORepo.findByDepartmentIdByType(departmentName);
	}

	@Override
	public void updateComplaintDepartment(int complaintId, int departmentId) {
		 ComplaintsDTO complaint = complaintsDTORepo.findById(complaintId).get();
	        if (complaint != null) {
	            complaint.setDepartmentId(departmentId);
	            complaintsDTORepo.save(complaint); // Save the updated complaint

	            HistoryDTO history = new HistoryDTO();

	            history.setComplaintId(complaintId);
	            history.setUserId(complaint.getUserId()); // Assuming the complaint has userId
	            history.setDepartmentId(departmentId);
	            historyDTORepo.save(history);
	        }
		
	}

	
	
	
}
