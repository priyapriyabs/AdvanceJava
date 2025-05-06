package com.priyanka.swapnum;

public class SwapArrays {

	public static void main(String[] args) {
		int a[]= {10,2,51,4,63,8,100};
		
		int b[]= {47,51,21,34,11,5,14};
		
		
		int temp=a[0];
		for(int i=0;i<a.length ;i++) {
			a[0]=a[1];
			a[1]=temp;	
			System.out.println(a[i]);
		}
		
		//swaping 2 arrays
//		for(int i=0;i<a.length || i<b.length;i++) {
//			a[i]=a[i]+b[i];
//			b[i]=a[i]-b[i];
//			a[i]=a[i]-b[i];
//			
//			//System.out.print(+b[i]+" ");
//			System.out.print(a[i]+" ");
//		}
	
	}
}
