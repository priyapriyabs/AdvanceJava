package com.priyanka.loops;

public class ForEachLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {10,2,120,5,20,90};
        int max=maxNum(a);
		System.out.println(max);
	for (int b : a) {
		System.out.print(b+" ");
	}
	}
public static int maxNum(int[] v) {
	int myNum=v[0];
	for(int v1:v) {
	if(v1>myNum) 
		myNum=v1;
	}
return	myNum;
}
}
