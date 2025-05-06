package com.xworkz.aggregation;

public class CEO {

	int age;
	String cname;
	String email;
	
	Salary salary;
	Address address;//has-a
	
	public CEO(int age,String cname,String email, Salary salary, Address address) {
		this.age=age;
		this.cname=cname;
		this.email=email;
		this.salary=salary;
	this.address=address;
	}
	
	public void ceoDetails() {
		System.out.println("Salary basic:"+salary.basic);
		System.out.println("Salary commission:"+salary.commision);
		
		System.out.println("Address pinCode:"+address.pinCode);
		System.out.println("Address area:"+address.area);
		System.out.println("Address state:"+address.state);
		System.out.println("===================");
	}
	
}
