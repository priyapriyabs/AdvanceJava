package com.priyanka.loops;

public class FactNum {

	public static void main(String[] args) {
		
		
	int	res=factNum(5);
	System.out.println(res);
	
	}
public static int factNum(int n) {
	int fact=1;
	for(int i=1;i<=n;i++) {
		fact*=i;
	}
	return fact;
}
	

}
