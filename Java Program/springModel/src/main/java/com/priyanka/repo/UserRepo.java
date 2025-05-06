package com.priyanka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.UserDTO;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, Integer>{

	@Query("select u from UserDTO u where u.email=:email")
	 UserDTO findByEmail(@Param("email") String email);
	
	@Query("select u from UserDTO u where u.email=:email and u.password=:password")
	UserDTO findByEmailAndPass(@Param("email")String email,@Param("password")String password);
}
