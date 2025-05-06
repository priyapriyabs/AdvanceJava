package com.priyanka.loops;

public class GCD {

	public static void main(String[] args) {
		int gcd=1;
		int a=8,b=4;
		for(int i=1;i<=a && i<=b;i++) {
			if(a%i==0 && b%i==0) {
				gcd=i;
			}
		}
		System.out.println(gcd);
	}
}
