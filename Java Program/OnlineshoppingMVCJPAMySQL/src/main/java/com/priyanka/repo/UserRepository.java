package com.priyanka.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyanka.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
