package com.priyanka.springjavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.priyanka")
@PropertySource("classpath:application.properties")
public class JavaConfig {

	
}
