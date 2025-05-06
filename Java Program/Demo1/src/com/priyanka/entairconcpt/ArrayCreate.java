package com.priyanka.entairconcpt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ArrayCreate {

	public static void main(String[] args) {
      AllPrograms al=new AllPrograms(1, "priya", "bng", 98745,true ,new MyPlace());
      AllPrograms bl=new AllPrograms(3, "rohan", "hyd", 97412,false ,new MyPlace());
//   
//      AllPrograms[] all=new AllPrograms[5];
//     all[0]=al;
//      all[1]=al2;
      
     int a[]= {25,5,587,12,47};
    
List<AllPrograms> ls=new ArrayList<AllPrograms>();
	ls.add(al);
//	ls.add(bl);
	System.out.println(ls);	
  
	
	
	
ListIterator	ltr=ls.listIterator();
System.out.println(ltr.next());

//while(ltr.hasPrevious()) {
//	System.out.println(ltr.previous());
//}

	}

}
