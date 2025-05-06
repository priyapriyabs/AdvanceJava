package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.AdminDTO;

@Repository
public interface AdminDTORepo extends JpaRepository<AdminDTO, Integer>{

	@Query("select a from AdminDTO a where a.email=:email")
  AdminDTO	findByAdminEmail(@Param("email") String email);
	
	@Query("select a from AdminDTO a where a.email=:email and a.password=:password")
	  AdminDTO	findByAdminEmailAndPass(@Param("email") String email,@Param("password") String password);
}
