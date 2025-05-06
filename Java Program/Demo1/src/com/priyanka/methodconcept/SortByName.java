package com.priyanka.methodconcept;

import java.util.Comparator;


public class SortByName implements Comparator<Employees> {

	@Override
	public int compare(Employees o1, Employees o2) {
		
		return o2.getName().compareTo(o1.getName());
	}
	

}
