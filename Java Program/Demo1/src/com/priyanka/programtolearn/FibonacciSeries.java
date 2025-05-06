package com.priyanka.programtolearn;

public class FibonacciSeries {

	public static void main(String[] args) {

	int n1=0,n2=1;
int num=8;

for(int i=0;i<num;i++) {
	System.out.print(n1+" ");
	int n3=n2+n1;
	n1=n2;//1 
	n2=n3;//0+1=1
	//System.out.print(n2);
}

	}

}
//next class how to find simple interest
//swaping of 2 numbers without using 3rd variable