package com.priyanka.util;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GenerateOTP {

	private static final String OTP="0123456789";
	private static final int OTPLENGTH=6;
	private static final SecureRandom secure=new SecureRandom();
	
	public static String generateOtp() {
		StringBuilder	 stringBuilder=new StringBuilder(OTPLENGTH);
	      for(int i=0; i<OTPLENGTH;i++)
	      {
	    	
	    stringBuilder.append(OTP.charAt(secure.nextInt(OTP.length())));	  
	  
	      }
	      return stringBuilder.toString();
		
	}

}
