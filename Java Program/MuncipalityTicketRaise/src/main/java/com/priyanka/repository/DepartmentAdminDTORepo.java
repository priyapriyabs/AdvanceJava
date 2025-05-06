package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.DepartmentAdminDTO;

@Repository
public interface DepartmentAdminDTORepo extends JpaRepository<DepartmentAdminDTO, Integer>{

	@Query("select d from DepartmentAdminDTO d where d.email=:email")
	DepartmentAdminDTO findByDepartmentAdminEmail(@Param("email") String email);
}
