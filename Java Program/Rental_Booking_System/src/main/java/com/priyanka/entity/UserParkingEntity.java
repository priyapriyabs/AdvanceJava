package com.priyanka.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@AllArgsConstructor
@Slf4j
@EqualsAndHashCode
@Table(name="user_parking_details")
public class UserParkingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="USERID_FK")
	private int userId;
	@Column(name="VEHICLE_NO")
	private String vehicleNo;
	@Column(name="LOCATION")
	private String location; 
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	@Column(name="ENGINE_TYPE")
	private String engineType;
	@Column(name="CLASSIFICATION")
	private String classification;
	@Column(name="TERM")
	private String term;
	@Column(name="PRICE")
	private int price;
	@Column(name="DISCOUNT")
	private int discount;
	@Column(name="TOTAL_AMT")
	private int totalAmount;
	@Column(name = "FILE_NAME")
	private String fileName;
	@Column(name = "PAYMENT")
	private String payment;
	@Column(name = "ORIGINAL_FN")
	private String originalFileName;
	@Column(name = "CONTENT_TYPE")
	private String contentType;
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;
	@Column(name = "UPDATED_DATE")
	private LocalDateTime updatedDate;
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	public UserParkingEntity() {
		log.info("Created: "+getClass().getSimpleName());
	}
}
