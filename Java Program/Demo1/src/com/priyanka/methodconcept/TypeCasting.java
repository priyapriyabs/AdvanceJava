package com.priyanka.methodconcept;

public class TypeCasting {

	public static void main(String[] args) {
		
		//print the charecters all
//		for(int i=0;i<=130;i++) {
//			
//			System.out.print(i);
//		}
		
		//print A-Z alphabets
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
		}
//		
//		//print a-z alphabets
				for(char i='a';i<='z';i++) {
					System.out.print(i);
				}
				
//	char	res1=upperCase('A');
//		System.out.println(res1);
		
//int	f=charVal('A');
//System.out.println(f);
				System.out.println("ooooooooooo");
				
				//char to string and string to char
				char ch='A';
		
			String	str=Character.toString(ch);
		System.out.println(str);
		
		String s="Priya";
		char c=s.charAt(1);
		System.out.println(c);
	}
	public static char upperCase(char a) {
	
		int res=a+32;
		return (char)res;
	}

	public static int charVal(char c) {
	int	r=(int)c;
		return r;
		
		//char to string
		

	}
}
