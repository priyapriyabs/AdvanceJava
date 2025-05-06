package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.SignUpDTO;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpDTO, Integer> {

	@Query("select s from SignUpDTO s where s.email=:email")
	SignUpDTO findByEmail(@Param("email") String email);

	@Query("select s from SignUpDTO s where s.email=:email and s.password=:password ")
	SignUpDTO findByEmailPass(@Param("email") String email, @Param("password") String pass);

	@Query("select s from SignUpDTO s where s.otp=:otp")
	SignUpDTO updateOTP(@Param("otp") String otp);
	
}


