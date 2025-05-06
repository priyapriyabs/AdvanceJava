package com.xworkz.methodOveloading;

public class Docter extends Person {
@Override
public void workInfo() {
	System.out.println("working as doctor");
}
@Override
	public void activity() {
	System.out.println("doctor give medicin");
	}
}
