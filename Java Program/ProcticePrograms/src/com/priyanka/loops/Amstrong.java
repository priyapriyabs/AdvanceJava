package com.priyanka.loops;

public class Amstrong {

	public static void main(String[] args) {
		
		int s,temp,result=0;
		int num=371;
		temp=num;
		while(temp!=0) {
			s=temp%10;
			result+=Math.pow(s, 3);
			temp/=10;
		}
		if(result==num) {
			System.out.println("poly");
		}else {
			System.out.println("not ploy");
		}
	}
}
