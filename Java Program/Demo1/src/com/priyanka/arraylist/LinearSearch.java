package com.priyanka.arraylist;

public class LinearSearch {

	public static void main(String[] args) {
		
		int ar[]= {74,103,4,95,54,1,65};
		try {
			
		
		int num=01;
		
		for(int i=0;i<ar.length;i++) {
			if(ar[i]==num && num>=0) {
				System.out.println(num+"present in index"+i);	
			}
			else if(ar[i]!=num) {
				
			}
		}
		} catch (Exception e) {
			System.out.println("num not found in array");
		}
		}
	
}
