package com.priyanka.service;

import java.util.List;

import com.priyanka.dto.ComplaintsDTO;
import com.priyanka.dto.DepartmentAdminDTO;
import com.priyanka.dto.DepartmentDTO;

public interface DepartmentAdminService {

	void deparmentAdminAcountCreate(DepartmentAdminDTO departmentAdminDTO);

     DepartmentAdminDTO   findByDepartmentAdminEmail(String email);
     
     DepartmentDTO save(DepartmentDTO departmentDTO);
     
     DepartmentDTO findByDepartmentName(String departmentName);

List<DepartmentDTO> findAllDepartments();

DepartmentDTO	findByDepartmentId(int departmentId);
}
