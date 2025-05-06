package com.priyanka.configuration;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


import com.priyanka.util.FileConstants;

@Configuration
@Slf4j
public class SpringWebInit extends AbstractAnnotationConfigDispatcherServletInitializer  {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {DBConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
//        configurer.enable();
//    }

    @Override
	protected void customizeRegistration(Dynamic registration) {
		int maxSize=FileConstants.MAX_FILE_SIZE;	//800000000;
		MultipartConfigElement multipartConfigElement=
									new MultipartConfigElement(FileConstants.UPLOAD_DIR, maxSize, maxSize*2, maxSize/2);
		registration.setMultipartConfig(multipartConfigElement);
	}
}

