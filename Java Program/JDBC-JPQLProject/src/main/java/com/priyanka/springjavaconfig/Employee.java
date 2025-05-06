package com.priyanka.springjavaconfig;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Employee implements Company {
	
	int eid;
	String name;
	String place;
	
	public Employee() {
	System.out.println(this.getClass().getSimpleName()+"object created");
	}
	
	public Employee(int eid, String name, String place) {
		super();
		this.eid = eid;
		this.name = name;
		this.place = place;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	

	

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", place=" + place + "]";
	}

	@Override
	public void salary() {
		System.out.println("emp salary......");
		
	}

	



}
