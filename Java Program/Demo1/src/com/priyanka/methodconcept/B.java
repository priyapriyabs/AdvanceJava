package com.priyanka.methodconcept;

public class B extends A{

	void dis(C c) {
		c.add();
		c.sub();
		System.out.println(super.a);
	}
	@Override
	public  void m9() {
		System.out.println("bbbbbbbbb");
	}
	void my() {
		System.out.println("my....");
	}
}
