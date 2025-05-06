package com.xworkz.methodOveloading;

public class Teacher extends Person{

	@Override
	public void workInfo() {
		System.out.println("working as teacher");
	}
	@Override
	public void activity() {
		System.out.println("teach the students");
	}
}
