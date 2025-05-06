package com.priyanka.programtolearn;

public class PolyndronNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int s,temp,sum=0;
int num=121;
temp=num;
while (num>0) {
	s=num%10;
	sum=(sum*10)+s;
	num=num/10;
}
		if(temp==sum) {
			System.out.println("Polindron number"+sum);
		}
		else {
			System.out.println("not polyndron"+temp);
		}
	}

}
