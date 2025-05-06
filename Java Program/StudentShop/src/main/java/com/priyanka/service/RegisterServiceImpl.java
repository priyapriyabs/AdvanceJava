package com.priyanka.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.entity.StudentEntity;
import com.priyanka.repo.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterServices {

	@Autowired
	private RegisterRepository registerRepository;
	
	@Override
	public void accountCreate(StudentEntity studentEntity) {
		registerRepository.save( studentEntity);
		
	}

	@Override
	public List<StudentEntity> validatestdandsave(StudentEntity studentEntity) {
		// TODO Auto-generated method stub
		return registerRepository.findAll();
	}

}
