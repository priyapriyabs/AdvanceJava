package com.priyanka.conditionalstatments;

import java.math.BigDecimal;
import java.util.Scanner;

public class SwitchConditio {

	public static void main(String[] args) {
		
		Scanner snc=new Scanner(System.in);
		System.out.println("enter number");
		int a=snc.nextInt();
		switch(a) {   //switch handle integer number
		
		case 1:
			System.out.println("number 1:"+a);
			break;
		case 2:
			System.out.println("number 2:"+a);
			break;
		case 3:
			System.out.println("number 3:"+a);
			break;
			default:
				System.out.println("invalide");
		
		//switch handle srings
				System.out.println("enter String ");
			String	b=snc.next();
		switch (b) {
		case "a":
			System.out.println("im a side"+b);
			break;
		case "b":
			System.out.println("im b side"+b);
			break;
		case "c":
			System.out.println("im c side"+b);
				break;
		default:
			System.out.println("invalide String");
			break;
		
		}
		

		//switch canot handle into decimla, boolean, double values
		//switch only can handle int, String
		
		}
		
	}
}
