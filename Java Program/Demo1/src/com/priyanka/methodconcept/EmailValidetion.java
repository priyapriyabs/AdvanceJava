package com.priyanka.methodconcept;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidetion {

	public static void main(String[] args) {
		
//		
//	boolean	res=match("priya","@gmail.com");
//		System.out.println(res);
String res=reverse("java develops");
System.out.println(res);

	}
	public static boolean match(String name,String email) {
		
		String emailPatt=name+"@gmail.com";
		Pattern p=Pattern.compile(name+emailPatt);
Matcher m=	p.matcher(name+email);
return m.matches();
	}

	public static String reverse(String string)
{
		StringBuffer	sb=new StringBuffer();
		
for(int i=string.length()-1;i>=0;i--) {
	sb.append(string.charAt(i));
}
return sb.toString();
}
}
