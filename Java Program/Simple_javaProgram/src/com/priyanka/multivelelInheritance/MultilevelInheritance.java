package com.priyanka.multivelelInheritance;

public class MultilevelInheritance {

	public static void main(String[] args) {
	Audi	audi=new Audi();
	audi.loanDetails();
	audi.provideBlutooth();//Vehical class methods
	
	audi.start();
	audi.stop();//car class methods
	
	audi.musicSystem();
	audi.gps();//audi class methods
	}

}
