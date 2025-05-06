package com.priyanka.repo;

import java.util.List;


import com.priyanka.entity.HotelDetails;
import com.priyanka.util.DBConnection;
import com.priyanka.util.SQLQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HotelRepoImpl implements HotelRepo {

 EntityManager em= DBConnection.getEntity();
	
	@Override
	public void saveHotel(HotelDetails hotelDetails) {
		em.getTransaction().begin();
		em.persist(hotelDetails);
		em.getTransaction().commit();
	}

	@Override
	public List<HotelDetails> findAll() {
	Query query=em.createQuery(SQLQuery.FIND_ALL);
	return query.getResultList();
		 
	}


}
