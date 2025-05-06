package com.priyanka.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import com.priyanka.entity.Admin;
import com.priyanka.queries.SQLQueries;
import com.priyanka.singletone.DataBaseConnector;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AdminServiceImlp implements AdminService {

	EntityManager em = DataBaseConnector.getConnection();

	@Override
	public void saveAdmin(Admin admin) {
		em.getTransaction().begin();
		em.persist(admin);
		em.getTransaction().commit();
	}

	
	@Override
	public void deleteRow(Admin admin) {
		Query query = em.createQuery(SQLQueries.delete_row).setParameter("abc",402);
		em.getTransaction().begin();
		int res=query.executeUpdate();
		System.out.println(res);
		em.getTransaction().commit();
	
	}

	@Override
	public void updateRow(Admin admin) {
		em.getTransaction().begin();
		Query query=em.createQuery(SQLQueries.UPDATE_ROW).setParameter(1, 302);
int	update=query.executeUpdate();
	System.out.println(update);
	em.getTransaction().commit();
	
	}

	@Override
	public List<Admin> findAll(Admin admin) {
		Query query=em.createQuery(SQLQueries.FIND_ALL);
		 List<Admin> admin1=query.getResultList();
		 return admin1;
	}


	@Override
	public void findNorm(Admin admin) {
		Admin ad=em.find(Admin.class, 302);
		
		em.getTransaction().begin();
		ad.setAdmin_name("Rohith Sharma");
		em.merge(ad);
		em.getTransaction().commit();
		System.out.println(ad.getAdmin_name()+ad.getAdmin_adress());
	}


	@Override
	public void addConstraint(Admin admin) {
	
	Query query=em.createQuery(SQLQueries.ALTER_COMPANY);
	int alter=query.executeUpdate();
	System.out.println(alter);
	
	}

}
