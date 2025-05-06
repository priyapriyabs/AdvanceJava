package com.priyanka.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Slf4j
public class AdminParkingDTO implements Serializable, Comparable<AdminParkingDTO> {
	private static final long serialVersionUID = 1L;
	
	private String location;
	private String vehicleType;
	private String engineType;
	private String classification;
	private String term;
	private int price;
	private int discount;
	
	public AdminParkingDTO() {
		log.info("Created: "+getClass().getSimpleName());
	}

	@Override
	public int compareTo(AdminParkingDTO o) {
		this.getLocation().equals(o.getLocation());
		return 0;
	}

}
