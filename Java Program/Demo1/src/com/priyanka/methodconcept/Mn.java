package com.priyanka.methodconcept;

public class Mn {

	
	public static void main(String[] args) {
		int arr[]= {14,5,87,20,1,55};
		int n=arr.length;
		int temp=0;
		for(int i=0;i<n;i++) {
			for(int j=1;j<(n-i);j++) {
				if(arr[j-1]<arr[j]) {
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
				
			}
			
		}
		for(int ar:arr) {
	System.out.println(ar);
	}
		
	}
}
