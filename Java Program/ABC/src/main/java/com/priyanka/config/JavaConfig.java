package com.priyanka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.EmbeddedValueResolutionSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.priyanka")
public class JavaConfig {

	@Bean
	public InternalResourceViewResolver getView() {
	InternalResourceViewResolver vrs=new InternalResourceViewResolver();
	vrs.setPrefix("/");
	vrs.setSuffix(".jsp");
	return vrs;
	}
}
