package com.priyanka.springjavaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestJava {

	public static void main(String[] args) {
		
ApplicationContext apx=new AnnotationConfigApplicationContext(JavaConfig.class);
SalaryDetails emp	=apx.getBean(SalaryDetails.class);
	emp.details();
	
	}

}
