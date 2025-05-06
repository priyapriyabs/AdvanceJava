package com.priyanka.singletone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DataBaseConnector {

	public static EntityManagerFactory entityManagerFactory=null;
	public  static EntityManager entityManager=null;
	
	static{
		entityManagerFactory=Persistence.createEntityManagerFactory("mypersist");
	entityManager=entityManagerFactory.createEntityManager();
	}
	
	public static EntityManager getConnection() {
		return entityManager;
	}
}
