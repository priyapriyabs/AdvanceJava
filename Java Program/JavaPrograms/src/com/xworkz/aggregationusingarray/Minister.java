package com.xworkz.aggregationusingarray;

public class Minister {

	int age;
	String mname;
	String place;
	
	public Minister(int age,String mname,String place) {
		this.age=age;
		this.mname=mname;
		this.place=place;
	}
	
//public void	ministerDetails(){
//		System.out.println("minister age:"+age);
//		System.out.println("minister name:"+mname);
//		System.out.println("minister place:"+place);
//	}

@Override
public String toString() {
	return "Minister [age=" + age + ", mname=" + mname + ", place=" + place + "]";
}

}
