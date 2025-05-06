package com.priyanka.superMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.superMarket.entity.AdminEntity;
import com.priyanka.superMarket.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public void adminAccountCreate(AdminEntity adminEntity) {
		adminRepo.save(adminEntity);
		
	}

	@Override
	public List<AdminEntity> displayAllAdmin(AdminEntity adminEntity) {
		
		return adminRepo.findAll();
	}
	
	
}
