package com.priyanka.staticvariables;

public class InitializingVariables {
	int id;
	String name;
	String place;
	double salary;
	//Veg veg;
	public static void main(String[] args) {
	InitializingVariables	init=new InitializingVariables(123, "Priyanka", "Shivamoga",10000.12);
	System.out.println("My ID is:"+init.id);
		System.out.println("My Name:"+init.name);
		System.out.println("My Place is:"+init.place);
		System.out.println("My Salary is:"+init.salary);
		//System.out.println(init.veg);
		
//		Veg veg=Veg.Beans;
//		System.out.println(init.veg);
	new InitializingVariables(10);
	new InitializingVariables(10, 20);
	new InitializingVariables(10, 20, 30);
	
	}	
public InitializingVariables(int id,String name,String place,double salary){
	this.id=id;
	this.name=name;
	this.place=place;
	this.salary=salary;
//	this.veg=veg;
}
	public  InitializingVariables(int a) {
System.out.println("one arg"+a);
}
	public InitializingVariables(int a,int b) {
		this(a);
	System.out.println(a+b);
	}
public InitializingVariables(int a,int b,int c) {
	this(a,b);
	System.out.println(a+b+c);
}
}
// enum Veg{
//	Beans,Carrot
// }