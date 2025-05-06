package com.priyanka.conditionalstatments;

import java.util.Scanner;

public class IfCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner snc=new Scanner(System.in);
System.out.println("enter number");
int a=snc.nextInt();
if (a>50) {                                //this is if conditional statment(outer if)
	System.out.println("im from if block");
	if (a>80 && a<100) {                    //nested if or inner if conditional statments
		System.out.println("im inside this code");
	}
	else {
		System.out.println("im out side this code");
	}
}else {
	System.out.println("im from else block");
}
// another conditional statments if else if lader
if(a==200) {
	System.out.println("200 = amount");
}
else if(a>=200 && a<=500) {
	System.out.println("between 200 and 500");
}
else if(a>=600 || a<=1000) {
	System.out.println(">600 and <100");
}
else {
	System.out.println("none");
}
	}
}
