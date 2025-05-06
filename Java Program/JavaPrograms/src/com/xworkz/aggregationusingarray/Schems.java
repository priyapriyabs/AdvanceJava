package com.xworkz.aggregationusingarray;

public class Schems {

	String schemName;
	String validity;
	int schemId;
	
	public Schems(String schemName,String validity,int schemId) {
		this.schemName=schemName;
		this.validity=validity;
	this.schemId=schemId;
	}
	
//	public void schemDetails() {
//		System.out.println("Schem name:"+schemName);
//		System.out.println("Schem validity:"+validity);
//		System.out.println("Schem schemId:"+schemId);
//	}

	@Override
	public String toString() {
		return "Schems [schemName=" + schemName + ", validity=" + validity + ", schemId=" + schemId + "]";
	}
	
	
}
