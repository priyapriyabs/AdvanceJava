package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.SignUpDTO;

@Repository
public interface UserSignUpDTORepo extends JpaRepository<SignUpDTO, Integer>{

	@Query("select count(u.email) from SignUpDTO u where u.email=:email")
	long countOfEmail(@Param("email")String email);
	
	@Query("select count(u.phone) from SignUpDTO u where u.phone=:phone")
	long countOfPhone(@Param("phone")Long phone);
	
	@Query("select u from SignUpDTO u where u.email=:email")
	SignUpDTO findByUserEmail(@Param("email")String email);

	@Query("select u from SignUpDTO u where u.phone=:phone")
	SignUpDTO findByUserPhone(@Param("phone")Long phone);

	
}