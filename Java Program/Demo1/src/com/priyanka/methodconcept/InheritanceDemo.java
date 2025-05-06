package com.priyanka.methodconcept;

import java.beans.Encoder;

import com.priyanka.operators.Boy;

public class InheritanceDemo {

	public static void main(String[] args) {	
D	d=new D();
//Object	obj=new Object();
//System.out.println(obj.getClass());

String a="java developer";
String b="java full stack";
String c="java developer";

System.out.println(a.charAt(2));
System.out.println(a.codePointAt(3));//asci
System.out.println(a.codePointBefore(3));
System.out.println(a.codePointCount(1, 7));
System.out.println(a.compareTo(c));
System.out.println(a.compareToIgnoreCase("JaVa"));
System.out.println(a.concat(b));
System.out.println(a.contains("a"));
System.out.println(a.contentEquals(c));
System.out.println(a.contentEquals(c));
System.out.println(a.endsWith("r"));
System.out.println(a.equals(b));
System.out.println(a.equalsIgnoreCase("JAvA DeveloPEr"));
System.out.println(a.hashCode());
System.out.println(a.indexOf("v"));
System.out.println(a.indexOf("p"));
System.out.println(a.intern());
System.out.println(a.isEmpty());
System.out.println(a.lastIndexOf("v"));
System.out.println(a.lastIndexOf("e"));
System.out.println(a.length());
System.out.println(a.matches(c));
System.out.println(a.offsetByCodePoints(1, 7));
System.out.println(a.regionMatches(4, c, 4, 4));
System.out.println(a.replace("java", "JAVA"));
System.out.println(a.replace(b, a));
System.out.println(a.replaceAll(a, b));
System.out.println(a.replaceFirst(b, c));
System.out.println(a.startsWith("a", 1));
System.out.println(a.substring(2));
System.out.println(a.substring(1, 7));
System.out.println(a.toCharArray());
System.out.println(a.toString());
System.out.println(a.getClass().toString());
System.out.println(a.split(c));
System.out.println(a.subSequence(2, 8));
System.out.println(a.chars());
System.out.println(a.codePoints());
System.out.println(a.getBytes());
System.out.println(a.format(b, a));
System.out.println(a.join(b, a));
System.out.println(a.valueOf(true));
System.out.println(a.valueOf(c));
System.out.println(a.valueOf(b));



for(int i=0;i<=a.length()-1;i++) {
	System.out.print(a.charAt(i));
}
System.out.println("====");
for(int i=a.length()-1;i>=0;i--) {
	System.out.print(a.charAt(i));
}
for(int i=10-1;i>=0;i--) {
	System.out.print(i);
}
	for(int i='z';i>='a';i--) {
		System.out.print((char)i);
	}
	}
	
}
