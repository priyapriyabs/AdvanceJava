package com.priyanka.staticvariables;

public class HPLaptop {
	
	int model;
	static String brand;
	String generation;

	public HPLaptop(int model, String generation) {
		this.model = model;
		this.generation = generation;
	}

	static {
	brand = "HPLaptop";
	
	}
}
