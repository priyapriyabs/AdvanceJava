package com.priyanka.arraylist;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;

public class CollectionsJava {

	public static void main(String[] args) {
		
		List ar=new ArrayList();
		ar.add(10);
		ar.add('c');
		ar.add("priya");
		ar.add(25.47);
	//	System.out.println(ar);
		ar.add(19);

//		System.out.println(ar);
//		ar.remove(0);
//		System.out.println(ar);
////		ar.clear();
////		System.out.println(ar);
//		System.out.println(ar.contains(1));
//		ar.forEach(a->System.out.print(a));
//		System.out.println("ooooooooooo");
//		System.out.println(ar.get(3));
//		System.out.println(ar.indexOf('c'));
//		System.out.println(ar.isEmpty());
//		System.out.println(ar.iterator());
//		System.out.println(ar.lastIndexOf(25.47));
//        System.out.println(ar.retainAll(ar)); 
//		ar.set(3, 147);
//		System.out.println(ar.size());
//		System.out.println(ar.stream());
//		System.out.println(ar);
	
	Spliterator	spl=ar.spliterator();
//		System.out.println(spl.characteristics());
//		System.out.println(spl.estimateSize());
//		System.out.println(spl.getExactSizeIfKnown());
//		System.out.println(spl.hasCharacteristics(0));
//		System.out.println(spl.hashCode());
//		System.out.println(spl.toString());
//		System.out.println(spl.getClass().getName());
//		System.out.println(spl.trySplit());
//		System.out.println(spl.CONCURRENT);
//		System.out.println(spl.DISTINCT);
//		System.out.println(spl.IMMUTABLE);
//		System.out.println(spl.NONNULL);
//		System.out.println(spl.ORDERED);
//		System.out.println(spl.SIZED);
//		System.out.println(spl.SORTED);
//		System.out.println(spl.SUBSIZED);
//	spl.forEachRemaining(a->System.out.println(a));
//	spl.forEachRemaining(b->System.out.println(b));
//	
ListIterator	ltr=ar.listIterator();

//System.out.println(ltr);
//System.out.println(ltr.equals(spl));
//System.out.println(ltr.hasNext());
//System.out.println(ltr.hasPrevious());
//System.out.println(ltr.next());
//System.out.println(ltr.nextIndex());
//System.out.println(ltr.previous());
//System.out.println(ltr.previousIndex());
//System.out.println(ltr.toString());
////ltr.set(ar);
//ltr.remove();
//ltr.add(20);
//ltr.add('a');
//ltr.add("pooja");
//ltr.add(88);
//
//System.out.println(ltr.previous());
//System.out.println(ltr.previous());
//System.out.println(ltr.next());
//System.out.println(ltr.next());
//System.out.println(ltr.nextIndex());
//System.out.println(ltr.previousIndex());
//System.out.println(ar);
		while(ltr.hasNext()) {
			System.out.println(ltr.next());
		}
		while(ltr.hasPrevious()) {

			System.out.println(ltr.previous());
		}
//		
	}
}
