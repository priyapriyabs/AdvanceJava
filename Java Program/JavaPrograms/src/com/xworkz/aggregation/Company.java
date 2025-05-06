package com.xworkz.aggregation;

public class Company {

	int id;
	String name;
	String type;//IT or non IT
	
	CEO ceo;
	Manager manager;
	Employees employees;//has-a relationship
	
	public Company(int id,String name,String type,CEO ceo,Manager manager, Employees employees) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.ceo=ceo;
	this.manager=manager;
this.employees=employees;		
	}
	
	public  void display() {
		System.out.println("company id:"+id);
		System.out.println("company name:"+name);
		System.out.println("company type:"+type);
		System.out.println("========================");
		System.out.println("CEO ceo age:"+ceo.age);
		System.out.println("CEO name:"+ceo.cname);	
		System.out.println("CEO email:"+ceo.email);
		System.out.println("=========================");
		System.out.println("Manager id:"+manager.mid);
		System.out.println("Manager name:"+manager.mname);
		System.out.println("Manager place:"+manager.place);
		System.out.println("========================");
		System.out.println("Employees id:"+employees.eid);
		System.out.println("Employees name:"+employees.ename);
		System.out.println("Employees contact:"+employees.contact);
		System.out.println("===================");
		ceo.ceoDetails();
		
	}
	
}
