package com.priyanka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class AdminDTO {

	private String email;
	private String password;
	private String loginTime;
	private String name;
	private String created_by;
	private String updated_by;
	private String created_date;
	private String updated_date;
	
	public AdminDTO() {
		log.info("Created: "+getClass().getSimpleName());
	}
}
