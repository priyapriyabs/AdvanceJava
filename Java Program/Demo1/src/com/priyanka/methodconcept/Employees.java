package com.priyanka.methodconcept;

public class Employees {

	int eid;
	String name;
	String place;
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
	
	public Employees() {
		
	}
	public Employees(int eid, String name, String place) {
		super();
		this.eid = eid;
		this.name = name;
		this.place = place;
	}
	@Override
	public String toString() {
		return "Employees [eid=" + eid + ", name=" + name + ", place=" + place + "]";
	}
//	@Override
//	public int compareTo(Object o) {
//	Employees	e=(Employees)o;
//		return e.getName().compareTo(getName());
//	}
//	
	
	
}
