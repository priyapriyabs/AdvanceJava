package com.priyanka;

import java.util.List;

import com.priyanka.entity.HotelDetails;
import com.priyanka.repo.HotelRepoImpl;

public class HotelController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//	HotelDetails	h1=new HotelDetails(0, "ayodhya", "bng", "ayodhya@gmail.com", 1234);
//	HotelDetails	h2=new HotelDetails(0, "Myhotel", "pune", "myhotel@gmail.com", 4567);
//	HotelDetails	h3=new HotelDetails(0, "shiva", "hyd", "shiva@gmail.com", 9874);
	
HotelRepoImpl	himpl=new HotelRepoImpl();
//	himpl.saveHotel(h1);
//	himpl.saveHotel(h2);
//	himpl.saveHotel(h3);
//	
	List<HotelDetails> hl=himpl.findAll();
	hl.forEach(e->System.out.println(e));
	//System.out.println(hl);
	}

}
