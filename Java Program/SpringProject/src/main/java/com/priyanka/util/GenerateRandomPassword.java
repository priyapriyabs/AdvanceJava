package com.priyanka.util;

import java.security.SecureRandom;

public class GenerateRandomPassword {

	 public String generateRandomPassword() {
	        int length = 16; // desired password length
	        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
	        SecureRandom random = new SecureRandom();
	        StringBuilder password = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characterSet.length());
	            password.append(characterSet.charAt(index));
	        }

	        return password.toString();
	    }

}
