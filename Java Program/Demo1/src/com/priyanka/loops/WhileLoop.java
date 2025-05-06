package com.priyanka.loops;

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn= new Scanner(System.in);
	int	a=scn.nextInt();
	while(a>=10) {
	System.out.println(a);
	--a;
	}
	
	//boolean values we cant handle here because stack overflow will happpen
//boolean	b=scn.nextBoolean();
//System.out.println("enter boolean");
//	while(b) {
//		int c=10;
//		int d=10;
//		int res=c+d;
//		System.out.println(res);
//		res++;
//
//	}
}
}
