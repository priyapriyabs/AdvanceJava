package com.priyanka.programtolearn;

public class RecursiveProgram {

	public static void main(String[] args) {
//	int	res=sum(4);
//	System.out.println(res);
	
//for(int i=1;i<100;i++) {
//int	pri=primeNum(i, Math.ceil((Math.sqrt(i))));
//System.out.print(pri);
//}
long	res=factNum(5);
	System.out.println(res);	
	}
	
	public static int sum(int a) {
		if(a>0) {
			return a+sum(a-1);
		}else {
			return 0;
		}
		
	}
	
	public static int primeNum(int x,double i) {
		if(i==1) 
			System.out.println(x);
		if(x%i==0)
			return 0;
		else 
			return primeNum(x,i-1);
		
	}
	
	public static long factNum(int b) {
		
			if(b==0) {
				return 1;
			}
		else {
		return b*factNum(b-1);
}
	}
}