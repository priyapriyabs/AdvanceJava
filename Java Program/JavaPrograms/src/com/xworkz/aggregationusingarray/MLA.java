package com.xworkz.aggregationusingarray;

public class MLA {

	String thaluk;
	String voterId;
	double salary;
	
	public MLA(String thaluk,String voterId,double salary) {
		this.thaluk=thaluk;
		this.voterId=voterId;
		this.salary=salary;
	}
	
//	public void mlaDetails() {
//		System.out.println("MLA thaluk:"+thaluk);
//		System.out.println("MLA voterid:"+voterId);
//		System.out.println("MLA salary:"+salary);
//	}

	@Override
	public String toString() {
		return "MLA [thaluk=" + thaluk + ", voterId=" + voterId + ", salary=" + salary + "]";
	}
	
	
}
