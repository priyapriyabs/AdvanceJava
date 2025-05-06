package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.priyanka.entity.AdminEntity;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {

	@Query("select a from AdminEntity a where a.adminEmail=:adminEmail")
	AdminEntity findByAdminEmail(@Param("adminEmail") String adminEmail);

//	boolean updateLoginTime(AdminEntity adminEntity);
}
