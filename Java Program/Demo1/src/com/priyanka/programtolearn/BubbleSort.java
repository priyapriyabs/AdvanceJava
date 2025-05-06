package com.priyanka.programtolearn;

public class BubbleSort {

	public static void main(String[] args) {
		int array[]= {14,5,87,20,1,55};
		
		bubbleSortArray(array);
	
		for(int a:array) {
			System.out.println(a);
		}
		//sort String array
	//	String[] array1= {"priya","roopa","rekha","anu"};
//		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
	}
	
	public static void bubbleSortArray(int arr[]) {
		int n=arr.length;
		int temp=0;
		for(int i=0;i<n;i++) {
			for(int j=1;j<(n-i);j++) {
				if(arr[j-1]>arr[j]) {
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
	}
	
	
}
