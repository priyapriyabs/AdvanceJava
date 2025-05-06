package com.priyanka.programtolearn;

import java.util.Scanner;

public class ATMDemo {

	public static void main(String[] args) {
		
		int balance=100000;
		int withdraw,deposite;
		
		Scanner scn= new Scanner(System.in);
		System.out.println("Please enter pin");
	int	pin=scn.nextInt();
	if(pin==123) {
		while(true) {
		System.out.println("Welcome to SBI");
		options();
		System.out.println("slelect option");
		int	opt=scn.nextInt();
	
		switch (opt) {
		case 1:
			mainBalance(balance);
			break;
		case 2:
			System.out.println("enter your amount to withdraw");
			withdraw=scn.nextInt();
			withdraw(balance, withdraw);
			break;
		case 3:
			System.out.println("enter amount deposite");
			 deposite=scn.nextInt();
			 deposit(balance, deposite);
			break;
		default:
			System.exit(0);
			
		}
	}
	}
	else {
		System.out.println("invalide pin");
	}
	
	}
	public static void options() {
		System.out.println("1:Check balance");
		System.out.println("2:withdraw");
		System.out.println("3:deposite");
		System.out.println("4:exit");
	}
	
	public static void mainBalance(int balance) {
		System.out.println("Your main balance is: "+balance);
		
	}
	public static int withdraw(int balance, int withdraw) {
		System.out.println("your balance: "+balance);
		if(balance>=withdraw) {
			balance=balance-withdraw;
	System.out.println(" withdraw amount : "+withdraw);
	System.out.println("your current balance: "+balance);
		}
		else {
			System.out.println("insuficient balance");
		}
		return balance;
		
	}
	public static int deposit(int balance, int deposite) {
		System.out.println("your balance: "+balance);
		if(balance>=deposite) {
		balance=balance+deposite;
		
	System.out.println("your deposite amount is: "+deposite);
	System.out.println("your current balance is:"+balance);
	}else {
		System.out.println("please check amount");
	}
		return balance;
	}
}
