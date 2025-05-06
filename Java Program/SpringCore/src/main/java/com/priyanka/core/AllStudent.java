package com.priyanka.core;

import org.springframework.context.annotation.Bean;

public class AllStudent {

	@Bean
	public Student getStudent() {
		return new Student();
	}
	
	@Bean
    public  Book getBook()
	{
		return new Book();
	}
}
