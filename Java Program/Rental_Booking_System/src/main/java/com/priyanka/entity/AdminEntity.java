package com.priyanka.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@AllArgsConstructor
@Slf4j
@EqualsAndHashCode
@Table(name = "admin_login")
public class AdminEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL_ID")
	private String adminEmail;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="CREATED_BY")
	private String created_by;
	
	@Column(name="UPDATED_BY")
	private String updated_by;
	
	@Column(name="CREATED_DATE")
	private LocalDateTime created_date;
	
	@Column(name="UPDATED_DATE")
	private LocalDateTime updated_date;
	
	@Column(name="LOGIN_TIME")
	private String loginTime;
		
    public AdminEntity() {
    	log.info("Created: "+getClass().getSimpleName());
    	
	}
}
