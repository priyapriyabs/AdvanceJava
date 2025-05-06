package com.priyanka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanka.entity.StudentEntity;

@Repository
public interface RegisterRepository extends JpaRepository<StudentEntity, Integer> {

	
}
