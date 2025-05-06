package com.xworkz.aggregation;

public class Manager {

	int mid;
	String mname;
	String place;

	Salary salary;
	Address address;
	
	public Manager(int mid,String mname,String place,Salary salary,Address address) {
		this.mid=mid;
		this.mname=mname;
		this.place=place;
		this.salary=salary;
	this.address=address;	
	}
	
	public void managerDetails() {
		System.out.println("Salary basic:"+salary.basic);
		System.out.println("Salary commission:"+salary.commision);
	
		System.out.println("Address pinCode:"+address.pinCode);
		System.out.println("Address area:"+address.area);
		System.out.println("Address state:"+address.state);
		System.out.println("===================");
	}
}
