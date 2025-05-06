package com.priyanka.methodconcept;

public class MethodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMeth();
		double res = myMeth(10);
		System.out.println(res);
		myMeth("priya");
		int res1 = myMeth(20, 30);
		System.out.println(res1);
	}

	public static void myMeth() {
		System.out.println("emplty");
	}

	public static double myMeth(int a) {
		return a;
	}

	public static int myMeth(int a, int b) {
		return a + b;
	}

	public static void myMeth(String a) {
		System.out.println("emplty" + a);
	}
}
