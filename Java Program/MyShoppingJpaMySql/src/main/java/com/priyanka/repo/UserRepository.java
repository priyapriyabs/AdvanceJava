package com.priyanka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.priyanka.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	
	@Query("select u from User u where u.email=:email")
 User	findByEmail(@Param("email") String email);

	@Query("select u from User u where u.email=:email and u.password=:password")
 User	findByEmailAndPass(@Param("email") String email,@Param("password") String pass);
}
