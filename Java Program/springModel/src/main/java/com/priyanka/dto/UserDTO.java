package com.priyanka.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_info")
public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String username;
	Integer contact_number;
	String email;
	String address;
	String password;
}
