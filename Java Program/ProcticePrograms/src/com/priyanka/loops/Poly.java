package com.priyanka.loops;

public class Poly {

	public static void main(String[] args) {
		
		int s,temp,sum=0;
		int n=121;
		temp=n;
		while(n>0) {
			s=n%10;
			sum=sum*10+s;
			n=n/10;
		}
		if(sum==temp) {
			System.out.println("ploy");
		}else {
			System.out.println("not poly");
		}
	}
}
