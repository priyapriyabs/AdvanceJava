package com.priyanka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Student_info")

public class StudentEntity {

	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	@Size(min = 2, max = 25, message = "Char should me 2 to 30")
	private String username;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@NotNull
	private String state;
	
	@NotNull
	private String zip;
	
	
}
