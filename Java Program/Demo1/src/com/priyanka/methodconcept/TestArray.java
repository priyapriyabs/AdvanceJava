package com.priyanka.methodconcept;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class TestArray {

	public static void main(String[] args) {

		Employees emp[] = new Employees[7];
		emp[0] = new Employees(1, "priya", "bng");
		emp[1] = new Employees(2, "riya", "hyd");
		emp[2] = new Employees(9, "kushi", "pune");
		emp[3] = new Employees(4, "ruchi", "chennai");
		emp[4] = new Employees(5, "suma", "bng");
		emp[5] = new Employees(6, "uma", "delhi");
		emp[6] = new Employees(7, "rama", "panjab");
	
		int ar[]= {18,2,7,85,4,102};
		
		int br[]= {12,21,34,45,65,71,1};
		
		int cr[]= {99,81,75,60,54,84};
		//System.out.println(Arrays.toString(ar));
//		for(int i=0;i<emp.length-1;i++) {
//			System.out.println(emp[i]);
//		}
//		for(int i=emp.length-1;i>=0;i--) {
//			System.out.println(emp[i]);
//	}	
//System.out.println(Arrays.binarySearch(cr, 54));//array should me increasing order 
		Arrays.sort(emp,new SortByName());
	
		for(Employees e:emp) {
			System.out.println(e);
		}
//		System.out.println(Arrays.binarySearch(emp, 1));	

		//	List	al=new ArrayList<>();
//		al.add(emp);
//	Object	res=al.stream().sorted(Comparator.reverseOrder())
//		.collect(Collectors.toList());
//	System.out.println(res.toString());
	
	
//	int ab[][]= {{74,52},{54,69}};
//	
//	System.out.println(ab[1][1]);
//	for(int[] a:ab) {
//	System.out.println(a);
//	}
	}

}
