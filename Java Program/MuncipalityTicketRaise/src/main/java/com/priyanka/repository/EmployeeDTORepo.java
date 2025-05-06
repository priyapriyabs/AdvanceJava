package com.priyanka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.EmployeeDTO;

@Repository
public interface EmployeeDTORepo extends JpaRepository<EmployeeDTO, Integer>{

	@Query("select e from EmployeeDTO e where e.email=:email")
  EmployeeDTO	findByEmployeeEmail(@Param("email") String email);
	
	@Query("select count(e.email) from EmployeeDTO e where e.email=:email")
	long countByEmail(@Param("email")String email);
	
	@Query("select count(e.phone) from EmployeeDTO e where e.phone=:phone")
	long countByPhone(@Param("phone")Long phone);

	@Query("select e from EmployeeDTO e where e.departmentId=:departmentId")
    List<EmployeeDTO>  findByDepartmentId(@Param("departmentId")Integer departmentId);
}
