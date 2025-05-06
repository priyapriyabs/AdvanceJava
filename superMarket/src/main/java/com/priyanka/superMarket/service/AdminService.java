package com.priyanka.superMarket.service;

import java.util.List;

import com.priyanka.superMarket.entity.AdminEntity;

public interface AdminService {

	public void adminAccountCreate(AdminEntity adminEntity);
	
	public List<AdminEntity> displayAllAdmin(AdminEntity adminEntity);
}
