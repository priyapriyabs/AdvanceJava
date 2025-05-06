package com.priyanka.staticvariables;

public class Iphone {

	int pmodel;
	static String brand;
	String type;
	
	public Iphone(int pmodel,String type) {
		this.pmodel=pmodel;
		this.type=type;
	}
	
	static {
		brand="Iphone";
	}
}
