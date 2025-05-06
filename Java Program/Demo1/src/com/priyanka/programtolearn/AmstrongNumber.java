package com.priyanka.programtolearn;

import java.util.concurrent.CountDownLatch;

public class AmstrongNumber {

	public static void main(String[] args) {
		
int orignum,remainder,result=0;
int mynum=153;
orignum=mynum;
while(orignum!=0) {
	remainder=orignum%10;
	result+=Math.pow(remainder, 3);
	orignum/=10;
}
		
if(result==mynum) {
	System.out.println("amstrong"+mynum+"="+result);
}
else {
	System.out.println("not amstrong"+ mynum+"="+result);
}
	}

}
