package com.priyanka.service;

import java.util.List;

import com.priyanka.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO employeeAcountCreate(EmployeeDTO employeeDTO);

	void sendEmailToEmployee(EmployeeDTO employeeDTO,String plainPassword);
	
	EmployeeDTO findByEmployeeEmail(String email);
	
	String generateAndSendOTP(EmployeeDTO employeeDTO);
	
	EmployeeDTO validateEmail(String email);
	
	EmployeeDTO validatePhone(Long phone);

	List<EmployeeDTO> getEmployeeByDepartmentId(Integer departmentId);

}
