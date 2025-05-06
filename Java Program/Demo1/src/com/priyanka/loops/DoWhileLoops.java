package com.priyanka.loops;

import java.util.Scanner;

public class DoWhileLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn= new Scanner(System.in);
		int	a=scn.nextInt();
		
		//first we will write the code then will give condition
		do {
			System.out.println(a);
			a++;
		} while (a<=10);
		
	}

}
