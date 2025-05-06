package com.priyanka.entairconcpt;

import java.time.LocalDateTime;

public class TestApp {

	public static void main(String[] args) {
	AllPrograms	ap=new AllPrograms();
	
ap.setId(1);
ap.setName("priya");
ap.setPlace("bng");
ap.setPhone(9874563);
ap.setSalary(8957412.25558);
ap.setActive(true);

System.out.println(ap.getId());
ap.setName("ruthu");
System.out.println(ap.getName());
System.out.println(ap.getPhone());
System.out.println(ap.getPhone());
System.out.println(ap.getSalary());
System.out.println(ap.getIFSC_CODE());
System.out.println(ap.isActive());
System.out.println(ap.getDateAndTime());
MyPlace mp=new MyPlace();
ap.current(); 
ap.rent(mp);
ap.setMyPlace(mp);
System.out.println(ap.getMyPlace());
	}

	private static LocalDateTime getDateAndTime() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
