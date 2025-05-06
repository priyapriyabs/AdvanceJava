package com.xworkz.aggregation;

public class Employees {

	int eid;
	String ename;
	int contact;
	
	Salary salary;
	Address address;
	
	public Employees(int eid, String ename,int contact,Salary salary,Address address) {
		this.eid=eid;
		this.ename=ename;
		this.contact=contact;
		this.salary=salary;
	this.address=address;
}
	
	public void employeeDetails() {
		System.out.println("Salary basic:"+salary.basic);
		System.out.println("Salary commission:"+salary.commision);
		
		System.out.println("Address pinCode:"+address.pinCode);
		System.out.println("Address area:"+address.area);
		System.out.println("Address state:"+address.state);
		System.out.println("===================");
	}
}