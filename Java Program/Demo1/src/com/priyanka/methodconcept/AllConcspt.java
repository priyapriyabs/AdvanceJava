package com.priyanka.methodconcept;

public class AllConcspt {

	int a=100;
	String name;
	int b=120;
	String place;
static String email;
	{
System.out.println("non Static bloack");
	}
	static {
System.out.println("static block");
	}

	public static void main(String[] args) {
		AllConcspt all = new AllConcspt();
		all.m1();
		all.m1(10, 20);
		
		AllConcspt all2 = new AllConcspt();
		
	AllConcspt	a1=new AllConcspt(140, 77);
	
	AllConcspt	a2=new AllConcspt(140, 77);
	System.out.println(a1.hashCode());
	System.out.println(a2.hashCode());
	System.out.println(a1.equals(a2));
	
	System.out.println(a1);
a1.m1();
a1.m1(50, 44);

m1(41, "priya@gmail.com");
	}

	public AllConcspt() {
	
	System.out.println(this.getClass().getSimpleName());
	}
	
	public AllConcspt(int a, int b) {
	this.a=a;
	this.b=b;
	
	}

	public AllConcspt(String name, String place) {
	
	}

	public void m1() {
	
		System.out.println(a);
		System.out.println(b);
		System.out.println("m1 method");
	}

	public void m1(int a, int b) {
		this.a = a;
		this.b = b;

		System.out.println("m1 method oveload"+a+b);
	}

	public static void m1(int a, String place) {
		System.out.println(email);
		System.out.println("m1 method is overloading...."+a+place);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a+" "+b+" "+name+place+email;
	}
	@Override
	public boolean equals(Object obj) {
	AllConcspt	allcon=(AllConcspt)obj;
		return this.a==allcon.a && this.b==allcon.b;
	}
}
