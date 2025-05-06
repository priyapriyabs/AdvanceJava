package com.priyanka.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages={"com.priyanka"})
@PropertySource({"classpath:application.properties"})
@ComponentScan("com.priyanka")
@EnableTransactionManagement
public class JPAConfig {

	@Autowired
	private Environment env;
	
	 @Bean
	    public DataSource getDataSource() {
	        DriverManagerDataSource dataSourceBuilder =new  DriverManagerDataSource();
	        dataSourceBuilder.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	        dataSourceBuilder.setUrl(env.getProperty("jdbc.url"));
	        dataSourceBuilder.setUsername(env.getProperty("jdbc.user"));
	        dataSourceBuilder.setPassword(env.getProperty("jdbc.pass"));
	        return dataSourceBuilder;
	    }
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(getDataSource());
	        em.setPackagesToScan(new String[] { "com.priyanka.dto" });
	        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);
	        em.setJpaProperties(additionalProperties()); //fetches the properties
	        return em;
	}


	 Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
	      properties.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
	      properties.setProperty("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
	      properties.setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));//not fetching/setting property
	      return properties;
	   }

	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tx=new JpaTransactionManager();
	tx.setEntityManagerFactory(emf);
		return tx;
	}
}
