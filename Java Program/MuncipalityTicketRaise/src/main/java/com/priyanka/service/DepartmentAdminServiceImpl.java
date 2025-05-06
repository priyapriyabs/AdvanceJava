package com.priyanka.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.DepartmentAdminDTO;
import com.priyanka.dto.DepartmentDTO;
import com.priyanka.repository.DepartmentAdminDTORepo;
import com.priyanka.repository.DepartmentDTORepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentAdminServiceImpl implements DepartmentAdminService {

	@Autowired
	private DepartmentAdminDTORepo departmentAdminDTORepo;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private JavaMailSender javaMailSender;
	
	@Autowired
	private DepartmentDTORepo departmentDTORepo;
	
	@Override
	public void deparmentAdminAcountCreate(DepartmentAdminDTO departmentAdminDTO) {
		log.info("DepartmentAdmin Dto Acount Created");
		departmentAdminDTO.setCreatedBy(departmentAdminDTO.getName());
		departmentAdminDTO.setCreatedAt(LocalDateTime.now());
		departmentAdminDTO.setModifiedBy(departmentAdminDTO.getName());
		departmentAdminDTO.setModifiedAt(LocalDateTime.now());
		departmentAdminDTORepo.save(departmentAdminDTO);
	}

	@Override
	public DepartmentAdminDTO findByDepartmentAdminEmail(String email) {
		
		return departmentAdminDTORepo.findByDepartmentAdminEmail(email);
	}

	@Override
	public List<DepartmentDTO> findAllDepartments() {
		
		return departmentDTORepo.findAll();
	}

	@Override
	public DepartmentDTO save(DepartmentDTO departmentDTO) {
		
		return departmentDTORepo.save(departmentDTO);
	}

	@Override
	public DepartmentDTO findByDepartmentName(String departmentName) {
		
		return departmentDTORepo.findByDepartmentName(departmentName);
	}

	@Override
	public DepartmentDTO findByDepartmentId(int departmentId) {
		
		return departmentDTORepo.findById(departmentId).get();
	}


	


}
