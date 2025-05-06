package com.priyanka.swapnum;

public class SwapingOfNum {

	public static void main(String[] args) {
		//swap without using 3rd variable
		
//		int a=10;
//		int b=20;
//		a=a+b;//30
//		b=a-b;//30-20=10
//		a=a-b;//30-10=20
//		System.out.println(a);
//		System.out.println(b);
	
		//swap using 3rd variable
	int g=10;
	int f=20;
	int r=g;
	g=f;//20
	f=r;//10
	System.out.println(g);
	System.out.println(f);
	}
}
