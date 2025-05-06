package com.priyanka.service;

import java.util.List;


import com.priyanka.entity.StudentEntity;


public interface RegisterServices {

	void accountCreate(StudentEntity studentEntity);
	
	List<StudentEntity> validatestdandsave(StudentEntity studentEntity);
	
	
}
