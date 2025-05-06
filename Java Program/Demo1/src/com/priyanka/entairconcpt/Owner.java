package com.priyanka.entairconcpt;

public interface Owner {

	public void rent(MyPlace mp);
	
	void current();
	
	public default void paint(MyPlace mp) {
		mp.mymethod();
		System.out.println("paint requires");
	}
	
}
