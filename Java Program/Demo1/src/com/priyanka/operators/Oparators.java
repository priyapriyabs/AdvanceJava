package com.priyanka.operators;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class Oparators {

	public static void main(String[] args) {
		//Arithmatic oparatoes
Scanner scn=new Scanner(System.in);
System.out.println("enter number1");
int a=scn.nextInt();
System.out.println("enter number2");
int b=scn.nextInt();

	System.out.println("addition: "+(a+b));	
	System.out.println("substraction: "+(a-b));	
	System.out.println("multiplication: "+(a*b));	
	System.out.println("division: "+(a/b));	
	System.out.println("Modulus%: "+(a%b));	
	System.out.println("========");
	System.out.println("unary operator");
	
	//unaray operator
	System.out.println("post increment: "+(a++));
	System.out.println("pre increment: "+(++a));
	System.out.println("post decrement: "+(a--));
	System.out.println("pre decrement: "+(--a));
System.out.println("========");

//logical operation
	System.out.println("enter boolean value");
boolean	c=scn.nextBoolean();
boolean	d=scn.nextBoolean();
	System.out.println("logical operator");
	System.out.println("logicla && operator"+(c && d));
	System.out.println("logicla || operator"+(c || d));
	System.out.println("logicla != operator"+(c != d));
	System.out.println("logicla == operator"+(c == d));
////	
////	//Assignment operatoer
	System.out.println("enter number for assignment operator");
	System.out.println("assignment operator for addition:"+(a+=1));
	System.out.println("assignment operator for substraction:"+(a-=1));
	System.out.println("assignment operatorfor division:"+(a/=2));
	System.out.println("assignment operator for multiplication:"+(a*=2));
//	
////	//relational operator
	System.out.println("enter number for relational operator");
	System.out.println("Grater than:"+(a>b));
	System.out.println("less than:"+(a<b));
	System.out.println("equals:"+(a==b));
	System.out.println("not equals:"+(a!=b));
	
//	//ternamry operators
	System.out.println("ternamry operators");
	int res=(a>b)? a: b;
	System.out.println("ternamry result:"+res);

//bitwise operators
	System.out.println("bitwise operators");
	System.out.println("bitwise &:"+(a & b));
	System.out.println("bitwise |:"+(a | b));
	System.out.println("bitwise ~:"+(~a));
	System.out.println("bitwise ^:"+(a ^ b));

//	//shifting operator
	System.out.println("shift left:"+(a<<b));
	System.out.println("shift right:"+(a>>b));
	System.out.println("Unsignedshift right:"+(a>>>b));
	
	//instance operators
Person	obj1=new Person();
Person	obj2=new Boy();
System.out.println(obj1 instanceof Person);
System.out.println(obj1 instanceof Boy);
System.out.println(obj1 instanceof MyInterface);
	System.out.println("boj2 instance===");
System.out.println(obj2 instanceof Person);
System.out.println(obj2 instanceof Boy);
System.out.println(obj2 instanceof MyInterface);
	
	}

}
