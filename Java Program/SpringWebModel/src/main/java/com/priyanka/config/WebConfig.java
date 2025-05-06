package com.priyanka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.priyanka")
public class WebConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver viewResolve() {
		InternalResourceViewResolver vrs=new InternalResourceViewResolver();
		vrs.setPrefix("/");
		vrs.setSuffix(".jsp");
		return vrs;
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/URLToResource/**").addResourceLocations("/WEB-INF/static/");
	}

	@Bean
	public PasswordEncoder encoder(){
	    return new BCryptPasswordEncoder();
	}
}
