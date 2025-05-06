package com.priyanka.util;

import java.security.SecureRandom;
import java.util.Random;

public class generateRandomOTP {

	private static final String OTP="0123456789";
	private static final int OTPLENGTH=6;
	private static final SecureRandom secure=new SecureRandom();
	
	public static String generateOTP(){  
		  StringBuilder	 stringBuilder=new StringBuilder(OTPLENGTH);
		      for(int i=0; i<OTPLENGTH;i++)
		      {
		    	
		    stringBuilder.append(OTP.charAt(secure.nextInt(OTP.length())));	  
		  
		      }
		      return stringBuilder.toString();
	}
}
