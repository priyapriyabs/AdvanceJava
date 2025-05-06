package com.xworkz.methodOveloading;

public class Lawyer extends Person{
@Override
public void workInfo() {
System.out.println("working as lawyer");
}
@Override
	public void activity() {
		System.out.println("Reading book is activity");
	}
}
