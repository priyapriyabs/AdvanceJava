package com.priyanka.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
@EqualsAndHashCode
public class UserDTO implements Serializable, Comparable<UserDTO> {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private long phoneNo;
	private String createdBy;
	private LocalDate createdDate;
	private String updatedBy;
	private LocalDate updatedDate;
	private String otp;
	private int otpCount;
	private String AcctStatus;
	private LocalTime otpExpiryTime;
	
	
	public UserDTO() {
		log.info("created: "+this.getClass().getSimpleName());
	}
	@Override
	public int compareTo(UserDTO o) {
		name.compareTo(o.getName());
		return 0;
	}

}
