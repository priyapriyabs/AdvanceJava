package com.priyanka.repo;

import java.util.List;

import com.priyanka.entity.HotelDetails;

public interface HotelRepo {

	void saveHotel(HotelDetails hotelDetails);
	
List<HotelDetails>	findAll();
	
}
