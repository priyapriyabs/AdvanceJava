package com.xworkz.aggregationusingarray;

public class ChiefMinister {

	String cname;
	int adhar;
	String email;
	
	public ChiefMinister(String cname,int adhar,String email) {
		this.cname=cname;
		this.adhar=adhar;
		this.email=email;
	}
	
	public void cmDetails() {
		System.out.println("CM name:"+cname);
		System.out.println("CM adhar:"+adhar);
		System.out.println("CM email:"+email);
	}

	@Override
	public String toString() {
		return "ChiefMinister [cname=" + cname + ", adhar=" + adhar + ", email=" + email + "]";
	}
	
	
}
