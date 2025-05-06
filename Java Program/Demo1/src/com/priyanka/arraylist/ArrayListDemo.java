package com.priyanka.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		 Map map=new TreeMap<>();
			map.put("name", "priya");
			map.put("id", 123);
			map.put("place", "bng");
			
			System.out.println(map.size());
	
	List	ar=new ArrayList<>();
//	List	ar=new ArrayList<>();
//	LinkedList	ar=new LinkedList();
//List	ar=new Vector<>();
//	Stack	ar=new Stack<>();
		ar.add(10);
		ar.add(54);
		ar.add(4);
		ar.add(2);
		ar.add(410);
		ar.add(20.5);
		ar.add("priya");
		ar.add(map);
		
System.out.println(ar.stream().count());
    Object res=ar.stream()
.collect(Collectors.toList());
	System.out.println(res);	
    
//	Object	a=ar.stream().count(); 
//	System.out.println(a);
//		ar.forEach(b->System.out.println(b));
		
		
//		System.out.println(ar.clone());
//		ar.pop();
//		ar.push(120);
//		
		//System.out.println(ar);
//		System.out.println(ar.peek());
//		System.out.println(ar.elementAt(3));
//		System.out.println(ar.firstElement());
//		System.out.println(ar.search(ar));
		
 
	}
	
}
