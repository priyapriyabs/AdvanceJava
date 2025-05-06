package com.priyanka.methodconcept;

public class StringConcept {

	public static void main(String[] args) {
	try {
		StringBuilder	sb=new StringBuilder("developers in");
		sb.append(" my program");
		
		System.out.println(sb);
		
		String a="Im in development";
		for(int i=a.length()-1;i>=0;i--) {
			
			System.out.print(a.charAt(i));
		}
	} 
	catch (Exception e) {
		System.out.println(e.getMessage());
	}	
	System.out.println("oooooooooooooooo");
	 String res=stringBuild("java Developers");
	System.out.println(res);
	
	}
	
	public static String stringBuild(String srt) {
		 StringBuilder sb=new StringBuilder("Hi ");
	
	for(int i=0;i<srt.length();i++) {
		sb.append(srt.charAt(i));
	}
	return sb.toString();
	}
}
