package com.priyanka.staticvariables;

public class SimpleMethod {
	public static void main(String[] args) {
		car(12345);
		car(20000.36,"BMW");
		car(2024, 4);
SimpleMethod	simpl=new SimpleMethod();
	simpl.carStop();
	
	}

	public  static void car(int num) {
		
		System.out.println("Car number:"+num);
	}

	public static void car(double price,String name) {
		System.out.println("Car price and name:"+"price:"+price+"name:"+name);
	}
	public static void car(int model,int wheels) {
	
		System.out.println("Car model and wheels:"+"model:"+model+"wheels:"+wheels);
	
	}

	void carStop() {
		
		System.out.println("car Stop.....");
	car(10);
	}
  
}