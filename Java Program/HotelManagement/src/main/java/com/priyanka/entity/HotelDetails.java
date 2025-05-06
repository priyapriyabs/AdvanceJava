package com.priyanka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyTemporal;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="hotel_inform")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Hotel_id")
	int id;
	@Column(name="Hotel_name", nullable = false,unique = true)
	String name;
	@Column(name="Hotel_place")
	String place;
	@Column(name="Email_id", unique = true)
	String email;
	@Column(name="Mobile", unique = true)
	int contact;
	
}
