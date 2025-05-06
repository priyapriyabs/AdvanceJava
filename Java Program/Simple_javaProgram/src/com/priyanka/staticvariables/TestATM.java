package com.priyanka.staticvariables;

public class TestATM {

	public static void main(String[] args) {
		SBIAtm.deposite();
		SBIAtm.withdraw();
		System.out.println(SBIAtm.branch);
		System.out.println(SBIAtm.transaction_type);
	SBIAtm	sbi=new SBIAtm();
sbi.totalBalance();
sbi.passBookDetails();
	}

}
