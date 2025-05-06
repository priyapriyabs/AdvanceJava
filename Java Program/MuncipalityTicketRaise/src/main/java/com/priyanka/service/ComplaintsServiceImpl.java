package com.priyanka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.EmployeeDTO;
import com.priyanka.dto.HistoryDTO;
import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.ComplaintsDTORepo;
import com.priyanka.repository.HistoryDTORepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ComplaintsServiceImpl implements ComplaintsService {

	@Autowired
	private ComplaintsDTORepo complaintsDTORepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private HistoryDTORepo historyDTORepo;
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Override
	public ComplaintsDTO complaintsDTOAccountCreated(ComplaintsDTO complaintsDTO) {
	
		log.info("Account Created of complaintsDTO");
		complaintsDTO.setStatus("Active");
		complaintsDTO.setDepartmentId(0);
		
		complaintsDTORepo.save(complaintsDTO);
		return complaintsDTO;
	}

	@Override
	public void sendComplaintEmailForUser(SignUpDTO signUpDTO, ComplaintsDTO complaintsDTO) {
		 SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(signUpDTO.getEmail());
	        message.setSubject("Complaint Received");
	        message.setText("Dear " + signUpDTO.getFirstName() + ",\n\nYour complaint has been successfully received." +
	                "\n\nComplaint Details:\nId:"+complaintsDTO.getId() +
	                "\nType: " + complaintsDTO.getType() +
	                "\nDescription: " + complaintsDTO.getDescription() +
	                "\n\nBest regards,\nYour Company");
	        javaMailSender.send(message);
		
	}

	@Override
	public ComplaintsDTO findById(int id) {
		
		return complaintsDTORepo.findById(id).get();
	}

	@Override
	public List<ComplaintsDTO> getComplaintsByUserIdAndStatus(int userId, String status) {
		
		return complaintsDTORepo.findByUserIdAndStatus(userId, status);
	}

	@Override
	public List<ComplaintsDTO> getAllComplaints() {
		
		return complaintsDTORepo.findAll();
	}

	@Override
	public List<ComplaintsDTO> getComplaintByDepartmentName(String departmentName) {
		
		return complaintsDTORepo.findByDepartmentName(departmentName);
	}

	 @Override
	    public void saveHistory(HistoryDTO historyDTO) {
	        historyDTORepo.save(historyDTO);
	    }
	
	@Override
	public void updateComplaintStatus(int complaintId, String status) {
		ComplaintsDTO complaint=complaintsDTORepo.findById(complaintId).get();
//		ComplaintsDTO complaint=new ComplaintsDTO();
	if(complaint!=null) {
		complaint.setStatus(status);
		complaintsDTORepo.save(complaint);
		
	HistoryDTO history=new HistoryDTO();
	history.setComplaintId(complaintId);
	history.setStatus(status);
	history.setUserId(complaint.getUserId());
	saveHistory(history);
	}
	}

	@Override
	public void updateComplaintEmployee(int complaintId, Integer employeeId) {
		ComplaintsDTO complaint=complaintsDTORepo.findById(complaintId).get();
		if(complaint!=null) {
			complaint.setEmployeeId(employeeId);
			complaintsDTORepo.save(complaint);
			
			HistoryDTO history=new HistoryDTO();
		history.setComplaintId(complaintId);
		history.setUserId(complaint.getUserId());
		history.setEmployeeId(employeeId);
		saveHistory(history);
		}
	}

	@Override
	public void updateComplaintDepartmentAndStatus(int id, Integer employeeId, String status) {
		ComplaintsDTO existingComplaint =complaintsDTORepo.findById(id).get();
		if(existingComplaint!=null) {
			existingComplaint.setEmployeeId(employeeId);
			existingComplaint.setStatus(status);
			complaintsDTORepo.save(existingComplaint);
		}
	}

	@Override
	public List<ComplaintsDTO> getComplaintsByUserId(int userId) {
		return complaintsDTORepo.findComplaintByUserId(userId);
	}

	
}
