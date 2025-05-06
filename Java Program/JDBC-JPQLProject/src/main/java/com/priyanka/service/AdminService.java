package com.priyanka.service;

import java.util.List;

import com.priyanka.entity.Admin;

public interface AdminService {

	public void saveAdmin(Admin admin);
	
	public void deleteRow(Admin admin);

public void updateRow(Admin admin);

public List<Admin> findAll(Admin admin);

public void findNorm(Admin admin);

public void addConstraint(Admin admin);

}
