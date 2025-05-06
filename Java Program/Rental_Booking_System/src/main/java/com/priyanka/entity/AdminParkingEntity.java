package com.priyanka.entity;

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
@EqualsAndHashCode
@Slf4j
@Table(name="admin_parking_details")
public class AdminParkingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
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
	
	public AdminParkingEntity(){
		log.info("Created: "+getClass().getSimpleName());
	}
}
