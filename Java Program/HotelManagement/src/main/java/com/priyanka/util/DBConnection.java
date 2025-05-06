package com.priyanka.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBConnection {

	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager entityManager = null;
  static{
		entityManagerFactory = Persistence.createEntityManagerFactory("hotelInfo");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public static EntityManager getEntity() {
		return entityManager;
	}
}
