package com.priyanka.staticvariables;

public class TestDemo {

	public static void main(String[] args) {
		JavaCourse course = new JavaCourse(1, "Bangalore", "3-months");
		JavaCourse course1 = new JavaCourse(2, "Chennai", "6-months");
		System.out.println(course.course_name);
		System.out.println(course1.course_name);
		System.out.println("=============");

		PulserBike bike = new PulserBike(1, "Petrol","KA123C4789");
		PulserBike bike1 = new PulserBike(2, "Diesel","KA147K1235");
		System.out.println(bike.bname);
		System.out.println(bike1.bname);
		System.out.println("=============");
		
	HPLaptop	laptop=new HPLaptop(2023,"10th generation");
	HPLaptop	laptop1=new HPLaptop(2024,"11th generation");
	System.out.println(laptop.brand);
	System.out.println(laptop1.brand);

	System.out.println("=============");
	
Iphone	iphone=new Iphone(2022,"Iphon8");
Iphone	iphone1=new Iphone(2024,"Iphon11");
	System.out.println(iphone.brand);
	System.out.println(iphone1.brand);
	}

}
