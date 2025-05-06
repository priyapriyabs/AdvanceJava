package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.DepartmentDTO;

@Repository
public interface DepartmentDTORepo extends JpaRepository<DepartmentDTO, Integer>{

	@Query("select d from DepartmentDTO d where d.departmentName=:departmentName")
	DepartmentDTO findByDepartmentName(@Param("departmentName")String departmentName);
	
	@Query("SELECT d.id FROM DepartmentDTO d WHERE d.departmentName = :departmentName")
	int findByDepartmentIdByType(@Param("departmentName")String departmentName);
}
