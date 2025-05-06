package com.priyanka.loops;

public class ForLoops {

	public static void main(String[] args) {
// display natural numbers
		System.out.println("displya natural number");
for(int i=0;i<=10;i++) {
	System.out.print(i);
}
System.out.println("======");
//display even numbers
System.out.println("displya even number");
for(int i=0;i<=10;i++) {
	if(i%2==0) {
		System.out.print(i);
	}
}
System.out.println("======");
System.out.println("displya odd number");
for(int i=0;i<=10;i++) {
	if(i%2!=0) {
		System.out.print(i);
	}
}
//displya 1st 5 numbers
System.out.println("first 5 numbers");
for(int i=0;i<=10;i++) {
	System.out.print(i);
	if(i==5) {	
		
		break;
		
	}
}
System.out.println("===========");
//display number except 5
System.out.println("remove 5 number from the loop");
for(int i=0;i<=10;i++) {
	if(i==5) 	
	continue;
		System.out.print(i);
	}
}
	
}
