package com.priyanka.entity;

import java.time.LocalDate;
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
@Table(name="user_registration")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL_ID")
	private String email;
	
	@Column(name = "CONTACT_NO")
	private long phoneNo;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "UPDATE_DATE")
	private LocalDate updatedDate;
	
	@Column(name = "OTP")
	private String otp;

	@Column(name = "COUNT")
	private int otpCount;
	
	@Column(name = "STATUS")
	private String AcctStatus; 
	
	@Column(name = "EXPIRE_ON")
	private LocalTime otpExpiryTime;
	
	public UserEntity() {
		log.info("created: "+this.getClass().getSimpleName());
	}
}
