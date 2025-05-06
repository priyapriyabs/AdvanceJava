package com.priyanka.staticvariables;

public class PulserBike {

	int bid;
	static String bname;
	static  String wheels;
	String btype;
	String bnum;

	public PulserBike(int bid, String btype,String bnum) {
		this.bid = bid;
		this.btype = btype;
	}

	static {
		bname = "PulserBike";
		wheels="Two wheeler";
	}
}
