package com.xworkz.methodOveloading;

public class Employees {

	int id;
	String name;
	double salary;
	
	public static void main(String[] args) {
		empDetails(123);
		empDetails(123,"priyanka");
		empDetails(111,800000.0);
	}
	
	public static  void empDetails(int id) {
		System.out.println("id:"+id);
	}

	public static void empDetails(int id,String name) {
		System.out.println("id:"+id+"name:"+name);
	}
	public static void empDetails(int id, double salary) {
		System.out.println("id:"+id+"salary:"+salary);
	}
}
