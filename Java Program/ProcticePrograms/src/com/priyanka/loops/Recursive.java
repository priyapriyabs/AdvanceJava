package com.priyanka.loops;

public class Recursive {

	public static void main(String[] args) {
		
		int res=add(2);
		System.out.println(res);
	}
	
	public static int add(int a) {
		if(a>0) {
			return a+add(a-1);
		}else {
			return 0;
		}
		
	}
}
