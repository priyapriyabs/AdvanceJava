package com.priyanka.staticvariables;

public class SBIAtm {

	int pid;
	String owner_name;
	static String branch;
	static String transaction_type;
	
	public static void withdraw() {
		SBIAtm.branch="SBI";
		System.out.println("amount withdraw");
		
	}
	public static void deposite() {
		SBIAtm.transaction_type="online transection";
		System.out.println("Amount deposite");
	}
	void totalBalance() {
		
		System.out.println("total balance");
	}
	void passBookDetails() {
		
		System.out.println("Pass Book details");
	}
	
}
